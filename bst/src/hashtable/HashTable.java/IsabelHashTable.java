package hashtable.HashTable.java;


import java.util.LinkedList;

/**
 * Created by Isabel on 7/26/2016.
 */
public class IsabelHashTable {
    int[] primes = {3, 5, 7, 11, 13, 23};
    int currentPrimeIndex = 0;
    LinkedList<Object>[] arrayOfLists;
    int size=0;

    public IsabelHashTable() {
        setLists();
    }

    public void setLists() {
        arrayOfLists = new LinkedList[primes[currentPrimeIndex]];
        for (int i = 0; i < arrayOfLists.length; i++) {
            arrayOfLists[i] = new LinkedList<>();
        }
    }

    public static void main(String args[]) {
        Employee e1 = new Employee("Isabel", 18, 200000, 123);
        Employee e2 = new Employee("Isabel2", 2, 2222222, 23);
        Employee e3 = new Employee("Isabel3", 2, 2222222, 23);
        Employee e4 = new Employee("Isabel4", 2, 2222222, 23);
        Employee e5 = new Employee("Isabel5", 2, 2222222, 23);
        IsabelHashTable hash1 = new IsabelHashTable();
        hash1.insert(e1);
        hash1.insert(e2);
        hash1.displayAll();


        hash1.insert(e3);
        hash1.displayAll();

        hash1.insert(e4);
        hash1.displayAll();

        hash1.insert(e5);
        hash1.displayAll();
        hash1.insert(e2);
        hash1.displayAll();
    }

    public Object insert(Object toInsert) {
        int newSize=size+1;
        if(newSize==primes[currentPrimeIndex]){
            nextPrime();
            rehash();
        }
        int whichList = toInsert.hashCode()%arrayOfLists.length;

        if(!arrayOfLists[whichList].contains(toInsert)) {
            arrayOfLists[whichList].add(toInsert);
            size++;
        }


        return null;
    }

    public boolean delete(Object toDelete) {
        int whichList = toDelete.hashCode()%arrayOfLists.length;
        boolean toDel=arrayOfLists[whichList].remove(toDelete);
        if(toDel)
            size--;
        return toDel;
    }

    public Object find(Object toFind) {
        int whichList = toFind.hashCode()%arrayOfLists.length;
        if(arrayOfLists[whichList].contains(toFind))
            return toFind;
        return null;
    }

    public boolean contains(Object toCheck) {
        int whichList = toCheck.hashCode()%arrayOfLists.length;
        return arrayOfLists[whichList].contains(toCheck);
    }

    public void nextPrime() {
        currentPrimeIndex++;
        if (currentPrimeIndex >= primes.length) {
            throw new RuntimeException("Too much data!");
        }
    }

    public void rehash() {
        LinkedList<Object>[] oldData= arrayOfLists;
        arrayOfLists = new LinkedList[primes[currentPrimeIndex]];
        for (int k = 0; k < arrayOfLists.length; k++) {
            arrayOfLists[k] = new LinkedList<>();
        }
        size=0;

        for(int i = 0; i < oldData.length; i++){
            for(Object item: oldData[i])
                insert(item);
        }
    }
    public void displayAll() {
        System.out.println("Current table size: " + primes[currentPrimeIndex]);
        for (int i = 0; i < arrayOfLists.length; i++) {
            System.out.println("array index "+ i);
            for (Object item : arrayOfLists[i])
                System.out.println(item + " hash " + item.hashCode());
        }
    }
}

class Employee {
    String name;
    Integer phoneNumber;
    double salary;
    int age;

    public int hashCode() {
        int hc=phoneNumber.hashCode()+37*name.hashCode();
        if(hc<0)
            return hc*-1;
        return hc;
    }
    public Employee(String name, int age, double salary, int phoneNumber) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.phoneNumber = phoneNumber;
    }
    public boolean equals(Object o){
        return this.name.equals(((Employee)o).name) && this.phoneNumber==((Employee)o).phoneNumber;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }
}
