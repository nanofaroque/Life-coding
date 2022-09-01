package effort_2022;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class LC_981 {
    Map<String, TreeMap<Integer,String>> map;

    public LC_981() {
        map=new HashMap<>();

    }

    public void set(String key, String value, int timestamp) {
        map.compute(key,(k,v)-> v==null ? new TreeMap<Integer,String>():v).put(timestamp,value);

    }

    public String get(String key, int timestamp) {
        TreeMap<Integer,String> tMap= map.get(key);
        if(tMap==null) return "";
        if(tMap.floorKey(timestamp)==null) return "";
        return  tMap.get( tMap.floorKey(timestamp));
    }
}
