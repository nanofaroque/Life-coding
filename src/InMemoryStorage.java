import java.util.*;

public class InMemoryStorage {
    static class ValueEntry {
        String value;
        long timestamp; // set time
        long expiry;    // timestamp + ttl, -1 if no TTL

        ValueEntry(String value, long timestamp, long ttl) {
            this.value = value;
            this.timestamp = timestamp;
            this.expiry = ttl > 0 ? timestamp + ttl : -1;
        }
		
		ValueEntry(String value, long timestamp) {
			this.value = value;
			this.timestamp = timestamp;
			this.expiry=0;
		}

        ValueEntry(String value) {
            this.value = value;
            this.timestamp = 0;
            this.expiry = -1;
        }
    }

    TreeMap<String, TreeMap<String, PriorityQueue<ValueEntry>>> storage;

    public InMemoryStorage() {
        storage = new TreeMap<>();
    }

    public static void main(String[] args) {
        InMemoryStorage in = new InMemoryStorage();
		/*
		// Second Test
        in.set("A", "BC", "E");
        in.set("A", "BD", "F");
        in.set("A", "C", "G");

        String resf = in.scanByPrefix("A", "B");
        String scanf = in.scan("A");
        String ress = in.scanByPrefix("B", "B");

        System.out.println(
                "SCAN_BY_PREFIX: " + resf +
                        " SCAN: " + scanf +
                        " SCAN_BY_PREFIX: " + ress
        );
        */
		//third Test
		in.setAtWithTtl("A", "BC", "E",1L,9L);
		in.setAtWithTtl("A", "BC", "E",5L,10L);
		in.setAt("A","BD","F",5L);
		
		String spaf = in.scanByPrefixAt("A", "B", 14L);
		String spas = in.scanByPrefixAt("A", "B", 15L);
		System.out.println(
				"SCAN_BY_PREFIX_AT: " + spaf +
						" SCAN_BY_PREFIX_AT: " + spas
		);
    }
	/**
 	* First Part
 	* */
    public void set(String key, String field, String value) {
		// field to list
		TreeMap<String, PriorityQueue<ValueEntry>> map = storage.get(key);
		if(map==null){
			map = new TreeMap<>();
			map.compute(field, (_,v)
					-> v==null?new PriorityQueue<>((a,b)-> Math.toIntExact(a.expiry - b.expiry)):v).add(new ValueEntry(value));
			storage.put(key, map);
		}else{
			map.compute(field, (_,v)
					-> v==null?new PriorityQueue<>((a,b)-> Math.toIntExact(a.expiry - b.expiry)):v).add(new ValueEntry(value));
			
		}
    }
	
    public String get(String key, String field) {
        Map<String, PriorityQueue<ValueEntry>> map = storage.get(key);
        if (map == null) return "*";
		ValueEntry valueEntry = map.get(field).poll();
        return valueEntry == null ? "*" : valueEntry.value;
    }

    public boolean delete(String key, String field) {
		Map<String, PriorityQueue<ValueEntry>> map = storage.get(key);
        if (map == null) return false;

        boolean existed = map.remove(field) != null;

        if (map.isEmpty()) {
            storage.remove(key);
        }
        return existed;
    }
    /**
     * Second Part
     * */
    public String scan(String key) {
		Map<String, PriorityQueue<ValueEntry>> map = storage.get(key);
        if (map == null) return "*";

        StringBuilder res = new StringBuilder();
        for (Map.Entry<String, PriorityQueue<ValueEntry>> entry : map.entrySet()) {
            res.append(entry.getKey())
                    .append("(")
                    .append(Objects.requireNonNull(entry.getValue().peek()).value)
                    .append("),");
        }

        res.deleteCharAt(res.length() - 1);
        return res.toString();
    }

    public String scanByPrefix(String key, String prefix) {
        TreeMap<String, PriorityQueue<ValueEntry>> map = storage.get(key);
        if (map == null) return "*";

        StringBuilder res = new StringBuilder();
        for (Map.Entry<String, PriorityQueue<ValueEntry>> entry : map.entrySet()) {
            if (entry.getKey().startsWith(prefix)) {
                res.append(entry.getKey())
                        .append("(")
                        .append(Objects.requireNonNull(entry.getValue().peek()).value)
                        .append("),");
            }
        }

        if (res.length() == 0) return "*";

        res.deleteCharAt(res.length() - 1);
        return res.toString();
    }
	
	/*
	 * Third part
	 * */
	public String setAt(String key, String field, String value, long timestamp) {
        TreeMap<String, PriorityQueue<ValueEntry>> map = storage.get(key);
		if(map==null){
			map = new TreeMap<>();
			map.compute(field, (_,v)
					-> v==null?new PriorityQueue<>((a,b)-> Math.toIntExact(a.expiry - b.expiry)):v).add(new ValueEntry(value,timestamp));
			storage.put(key, map);
		}else{
			map.compute(field, (_,v)
					-> v==null?new PriorityQueue<>((a,b)-> Math.toIntExact(a.expiry - b.expiry)):v).add(new ValueEntry(value,timestamp));
			
		}
		return "*";
	}
	
	public String setAtWithTtl(String key, String field, String value, long timestamp, long ttl) {
		TreeMap<String, PriorityQueue<ValueEntry>> map = storage.get(key);
		if(map==null){
			map = new TreeMap<>();
			map.compute(field, (_,v)
					-> v==null?new PriorityQueue<>((a,b)-> Math.toIntExact(a.expiry - b.expiry)):v).add(new ValueEntry(value,timestamp,ttl));
			storage.put(key, map);
		}else{
			map.compute(field, (_,v)
					-> v==null?new PriorityQueue<>((a,b)-> Math.toIntExact(a.expiry - b.expiry)):v).add(new ValueEntry(value,timestamp,ttl));
			
		}
		return "*";
	}
	
	public boolean deleteAt(String key, String field, long timestamp) {
		TreeMap<String, PriorityQueue<ValueEntry>> map = storage.get(key);
		if(map==null) return false;
		PriorityQueue<ValueEntry> pq = map.get(field);
		boolean isDeleted=false;
		for(ValueEntry ve:pq){
			if(ve.timestamp == timestamp){
				pq.remove(ve);
				isDeleted=true;
			}
		}
		return isDeleted;
	}
	
	public String getAt(String key, String field, long timestamp) {
		TreeMap<String, PriorityQueue<ValueEntry>> map = storage.get(key);
		if (map == null) return "*";
		PriorityQueue<ValueEntry> pq = map.get(field);
		for(ValueEntry ve:pq){
			if(ve.timestamp == timestamp){
				return ve.value;
			}
		}
		
		return "";
	}
	
	public String scanAt(String key, long timestamp) {
		TreeMap<String,PriorityQueue<ValueEntry>> fieldMap = storage.get(key);
		if (fieldMap == null) return "*";
		
		StringBuilder res = new StringBuilder();
		for (Map.Entry<String, PriorityQueue<ValueEntry>> entry : fieldMap.entrySet()) {
				for (ValueEntry valueEntry : entry.getValue()) {
					if(valueEntry.expiry!=0 && valueEntry.expiry<=timestamp) continue;
					res.append(entry.getKey())
							.append("(")
							.append(Objects.requireNonNull(valueEntry.value))
							.append("),");
					
				}
		}
		return res.toString();
	}
	
	public String scanByPrefixAt(String key, String prefix, long timestamp) {
		TreeMap<String,PriorityQueue<ValueEntry>> fieldMap = storage.get(key);
		if (fieldMap == null) return "*";
		
		StringBuilder res = new StringBuilder();
		for (Map.Entry<String, PriorityQueue<ValueEntry>> entry : fieldMap.entrySet()) {
			if (entry.getKey().startsWith(prefix)) {
				for (ValueEntry valueEntry : entry.getValue()) {
					if(valueEntry.expiry!=0 && valueEntry.expiry<=timestamp) continue;
					res.append(entry.getKey())
							.append("(")
							.append(Objects.requireNonNull(valueEntry.value))
							.append("),");
				}
			}
		}
		return res.toString();
	}
}
