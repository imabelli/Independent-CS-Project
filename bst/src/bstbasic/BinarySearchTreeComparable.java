package bstbasic;

/**
 * Created by Isabel on 7/19/2016.
 */
public class BinarySearchTreeComparable {
    NodeComparable root;
    NodeComparable previous;

    public BinarySearchTreeComparable() {
        root = null;
    }

    public static void main(String args[]) {
        BinarySearchTreeComparable b = new BinarySearchTreeComparable();
        b.insert(3);
        b.insert(5);
        b.insert(2);
        b.insert(1);
        b.insert(4);
        b.insert(6);
        b.delete(0);
        if(b.delete(0)==false)
            System.out.println("f");
        b.display(b.root);
    }
    public int getLeftLeavesSum(NodeComparable root) {
        return 0;
    }
    public void display(NodeComparable root) {
        if (root != null) {
            display(root.left);
            System.out.print(" " + root.data);
            display(root.right);
        }
    }

    public NodeComparable find(Comparable toFind) {
        NodeComparable current = root;
        if (toFind.compareTo(root.data) == 0)
            return root;
        while (current != null && current.data.compareTo(toFind) != 0) {
            if (toFind.compareTo(current.data) < 0) {
                previous = current;
                current = current.left;
            }
            else if (toFind.compareTo(current.data) > 0) {
                previous = current;
                current = current.right;
            }
        }
        if(current==null)
            return null;
        return current;
        //throw new RuntimeException("The Node you tried to find (to delete) is not in this tree.");
    }

    public boolean delete(Comparable toDel) {
        NodeComparable found = find(toDel);
        if(found==null) {
            return false;
        }
        NodeComparable replacement = getSuccessor(found);
        NodeComparable temp1=root.right;
        NodeComparable temp2=root.left;
        if(toDel.compareTo(root.data)==0){
            if(root.right!=null && root.left != null){
            root=getSuccessor(root);
            }
            if(temp1.left!=null) {
                root.right=temp1;
                root.left=temp2;
                previous.left=null;
            }
            else{
                root.right=temp1.right;
                root.left=temp2;
            }
        }
        else if (found.right == null && found.left == null) {
            if (previous.right != null && previous.right.data.compareTo(found.data) == 0) {
                previous.right = null;
                return true;
            }
            if (previous.left != null && previous.left.data.compareTo(found.data) == 0) {
                previous.left = null;
                return true;
            }
        } else if (found.right == null) {
            if(found.left.data.compareTo(previous.data)>0){
                previous.right=found.left;
            }
            if(found.left.data.compareTo(previous.data)<0){
                previous.left=found.left;
            }
            return true;

        /*
            if (replacement.data.compareTo(previous.data) < 0) {
                previous.left = replacement;
                replacement.left = found.left;
                return true;
            }
            if (replacement.data.compareTo(previous.data) > 0) {
                previous.right = replacement;
                replacement.left = found.left;
                return true;
            }*/
        }
        else if (found.left==null){
            if(found.right.data.compareTo(previous.data)>0){
                previous.right=found.right;
            }
            if(found.right.data.compareTo(previous.data)<0){
                previous.left=found.left;
            }
            return true;
        }
        else if (found.left!=null && found.right != null)
        {
            if (replacement.data.compareTo(previous.data) < 0) {
                previous.left = replacement;
                replacement.right = found.right;
                return true;
            }
            if (replacement.data.compareTo(previous.data) > 0) {
                previous.right = replacement;
                replacement.right = found.right;
                return true;
            }
        }
        /*else if (found.left == null || (found.left != null && found.right != null)) {
            if (replacement.data.compareTo(previous.data) < 0) {
                previous.left = replacement;
                replacement.right = found.right;
                return true;
            }
            if (replacement.data.compareTo(previous.data) > 0) {
                previous.right = replacement;
                replacement.right = found.right;
                return true;
            }
        }
        */
        return false;
    }

    public NodeComparable getSuccessor(NodeComparable toDel) {
        NodeComparable successor = null;
        successor=root.right;
        while(successor.left!=null)
        {
            successor=successor.left;
        }
        return successor;
        /*if (toDel.right == null) {
            successor = toDel.left;
            while (successor != null) {
                successor = successor.right;
            }
        } else if (toDel.left == null || (toDel.right != null && toDel.left != null)) {
            successor = successor.right;
            while (successor != null) {
                successor = successor.left;
            }
        }
        return successor;*/
    }

    public void insert(Comparable toInsert) {
        NodeComparable fresh = new NodeComparable(toInsert);
        NodeComparable temp = null;
        NodeComparable current = null;

        if (root == null) {
            root = fresh;
            temp = root;
            return;
        }

        temp = root;

        while (temp != null) {
            if (toInsert.compareTo(temp.data) < 0) {
                current = temp;
                temp = temp.left;
            } else if (toInsert.compareTo(temp.data) > 0) {
                current = temp;
                temp = temp.right;
            }
        }

        if (current.data.compareTo(toInsert) > 0)
            current.left = fresh;
        if (current.data.compareTo(toInsert) < 0)
            current.right = fresh;

    }

}

class NodeComparable {
    Comparable data;
    NodeComparable left;
    NodeComparable right;

    public NodeComparable(Comparable data) {
        this.data = data;
        left = null;
        right = null;
    }
}
