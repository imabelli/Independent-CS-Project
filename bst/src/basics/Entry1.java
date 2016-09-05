package basics;

/**
 * Created by Isabel on 7/23/2016.
 */
public class Entry1 implements Comparable {

    Integer key;
    String value;

    public Entry1(Integer key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public int compareTo(Object o) {
        return key-((Entry1)o).key;
    }
}
