package utils;

/**
 * Created by Isabel on 7/16/2016.
 */
public class Node<T extends Comparable<?>> {
    Node<T> left, right;
    T data;

    public Node(T data) {
        this.data = data;
    }
}