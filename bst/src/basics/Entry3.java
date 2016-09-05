package basics;

/**
 * Created by Isabel on 7/23/2016.
 */
public class Entry3 implements Comparable{
    Comparable key;
    Object value;

    public Entry3(Comparable key, Object value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public int compareTo(Object o) {
        return key.compareTo(((Entry3)o).key);
    }
}
