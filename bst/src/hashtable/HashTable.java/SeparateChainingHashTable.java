package hashtable.HashTable.java;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Isabel on 7/23/2016.
 */
public class SeparateChainingHashTable<K, V> {

    int[] primes = {5, 7, 11, 13, 17, 19, 1009, 2087, 4157};

    int currentPrimeIndex = 0;
    //private static final int DEFAULT_TABLE_SIZE = 101;
    private List<EntryJier<K, V>>[] theLists;
    private int currentSize;

    protected int nextPrime() {
        currentPrimeIndex++;

        if (currentPrimeIndex == primes.length) {
            throw new RuntimeException("Too much data,  please modify hash table to dynamically/programmtically find next prime");
        }

        return primes[currentPrimeIndex];
    }


    public SeparateChainingHashTable() {
        theLists = new LinkedList[primes[currentPrimeIndex]];
        for (int i = 0; i < theLists.length; i++)
            theLists[i] = new LinkedList<>();
    }


//    public SeparateChainingHashTable( int size )
//    {
//
//    }


    public void put(K x, V y) {
        EntryJier entryJier = new EntryJier(x, y);

        insert(entryJier);

    }


    public void insert(EntryJier<K, V> x) {
        List<EntryJier<K, V>> whichList = theLists[myhash(x)];
        if (!whichList.contains(x)) {
            whichList.add(x);

            // Rehash; see Section 5.5
            if (++currentSize > theLists.length)
                rehash();
        }
    }


    public void remove(K x) {
        EntryJier entryJier = new EntryJier(x, null);
        /* Figure 5.10 */
        List<EntryJier<K, V>> whichList = theLists[myhash(entryJier)];
        if (whichList.contains(entryJier)) {
            whichList.remove(x);
            currentSize--;
        }

    }

    public boolean contains(EntryJier<K, V> x) {
        /* Figure 5.10 */
        List<EntryJier<K, V>> whichList = theLists[myhash(x)];
        return whichList.contains(x);

    }

    public void makeEmpty() {
        /* Figure 5.9 */
        for (int i = 0; i < theLists.length; i++)
            theLists[i].clear();
        currentSize = 0;

    }


    private void rehash() {
        List<EntryJier<K, V>>[] oldLists = theLists;

        // Create new double-sized, empty table
        theLists = new List[nextPrime()];
        for (int j = 0; j < theLists.length; j++)
            theLists[j] = new LinkedList<>();

        // Copy table over
        currentSize = 0;
        for (int i = 0; i < oldLists.length; i++)
            for (EntryJier<K, V> item : oldLists[i]) {
                insert(item);
            }


    }

    private int myhash(EntryJier x) {
        /* Figure 5.7 */
        int hashVal = x.key.hashCode();

        hashVal %= theLists.length;
        if (hashVal < 0)
            hashVal += theLists.length;

        return hashVal;

    }

    public V get(K key) {

        EntryJier<K, V> entryJier = new EntryJier<>(key, null);
        List<EntryJier<K, V>> whichList = theLists[myhash(entryJier)];

        for (EntryJier<K, V> entryJier2 : whichList) {
            if (entryJier2.equals(entryJier))
                return (V) entryJier2.value;
        }


        return null;


    }

    public static void main(String[] args) {
        SeparateChainingHashTable<Integer, String> theMap = new SeparateChainingHashTable<>();

        theMap.put(1, "jier");
        theMap.put(2, "isa");
        theMap.put(3, "monster");
        theMap.put(4, "daddy");

        System.out.println(theMap.get(2));
    }


}

class EntryJier<K, V> {
    K key;
    V value;

    public EntryJier(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public boolean equals(Object other) {
        EntryJier otherEntryJier = (EntryJier) other;

        return key.equals(otherEntryJier.key);

    }

    public int hashCode() {
        return key.hashCode();
    }

}