package linkedlist;

/**
 * Created by Isabel on 7/19/2016.
 */
public class LinkedListImplementation2 {
    public static void main(String args[]) {
        LinkedList x = new LinkedList();
        x.insertFront(1);
        x.insertFront(2);
        x.insertFront(3);
        System.out.println(x.contains(-1));
        System.out.println(x.size);
        x.display();
    }
}

class Node2 {
    Object data;
    Node2 next;

    public Node2(Object x) {
        this.data = x;
        this.next = null;
    }
}

class LinkedList {

    Node2 head = null;
    int size = 0;
    Node2 temp = null;

    public LinkedList() {
        head = null;
    }

    public void insertFront(Object x) {
        Node2 insert = new Node2(x);
        if (head == null) {
            head = insert;
        } else {
            temp = head;
            head = insert;
            head.next = temp;
        }
        size++;
    }

    public boolean contains(Object toCheck){
        Node2 current=head;
        while(current!=null){
            if(current.data==toCheck)
                return true;
            current=current.next;
        }
        return false;
    }

    public void display() {
        temp = head;
        while (temp != null) {
            System.out.print((Integer) temp.data + " ");
            temp = temp.next;
        }
    }

    public boolean delete(Object toDel) {
        temp = head;
        Node2 previous = head;
        int counter = 1;
        if (head == null)
            return false;
        if (head.data.equals(toDel)) {
            head = head.next;
            return true;
        }
        while (temp != null && !temp.data.equals(toDel)) {
            counter++;
            previous = temp;
            temp = temp.next;
        }
        if (counter == size && temp.data.equals(toDel)){
            previous.next = null;
            return true;
        }
        if(counter==size)
            return false;
        previous.next = temp.next;
        size--;
        return true;
    }
}
