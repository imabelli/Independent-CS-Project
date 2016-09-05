package basics;

/**
 * Created by Isabel on 7/23/2016.
 */
public class Entry2 implements Comparable{
    String key;
    String value;

    public Entry2(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public int compareTo(Object o) {
        return key.compareTo(((Entry2)o).key);
    }
}
