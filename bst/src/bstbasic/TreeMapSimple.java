package bstbasic;

import java.util.Map;

/**
 * Created by Isabel on 7/22/2016.
 */
public class TreeMapSimple {
    private BinarySearchTreeComparable core = new BinarySearchTreeComparable();

    public void put(Comparable key, Object value){
        Entry entry = new Entry(key, value);
        core.insert(entry);
    }

    public Object get(Comparable key){
        Entry entry = new Entry(key, null);
        return ((Entry)(core.find(entry).data)).value;
    }

    public static void main(String[] args){
        TreeMapSimple map = new TreeMapSimple();

//        map.put(1, "isa");
//        map.put(2, "jier");
//
//        map.put(3, "dadddy");
//
//        System.out.println(map.get(2));
        StudentRecord s1 = new StudentRecord("1", "isa", 2014, "math", "a", 0);
        StudentRecord s2 = new StudentRecord("2", "bel", 2014, "english", "b", 2);
        StudentRecord s3 = new StudentRecord("2", "bel", 2013, "english", "c", 2);
        map.put(s1.getKey(), s1);
        map.put(s2.getKey(), s2);
        map.put(s3.getKey(), s3);
        System.out.println(map.get(s2.getKey()));
    }

}

class Entry implements Comparable{
    Comparable key;
    Object value;

    public Entry (Comparable key, Object value){
        this.key  = key;
        this.value = value;
    }

    public int compareTo(Object o){
        return key.compareTo(((Entry)o).key);
    }



}
