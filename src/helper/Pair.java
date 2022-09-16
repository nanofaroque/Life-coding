package helper;

public class Pair<K,V> {
    K k;
    V v;
    public Pair(K k, V v){
        this.k=k;
        this.v=v;
    }

    public K getKey(){
        return k;
    }
    public V getValue(){
        return v;
    }
}
