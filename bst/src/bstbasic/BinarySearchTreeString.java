package bstbasic;

/**
 * Created by Isabel on 7/16/2016.
 */
public class BinarySearchTreeString {

    public   Node root;
    public BinarySearchTreeString(){
        this.root = null;
    }

    public boolean find(String item){
        Node current = root;
        while(current!=null){
            if(current.data.equals(item)){
                return true;
            }else if(current.data.compareTo(item)>0){
                current = current.left;
            }else{
                current = current.right;
            }
        }
        return false;
    }
    public boolean delete(String item){
        Node parent = root;
        Node current = root;
        boolean isLeftChild = false;
        while(current.data!=item){
            parent = current;
            if(current.data.compareTo(item)<0){
                isLeftChild = true;
                current = current.left;
            }else{
                isLeftChild = false;
                current = current.right;
            }
            if(current ==null){
                return false;
            }
        }
        //if i am here that means we have found the node
        //Case 1: if node to be deleted has no children
        if(current.left==null && current.right==null){
            if(current==root){
                root = null;
            }
            if(isLeftChild ==true){
                parent.left = null;
            }else{
                parent.right = null;
            }
        }
        //Case 2 : if node to be deleted has only one child
        else if(current.right==null){
            if(current==root){
                root = current.left;
            }else if(isLeftChild){
                parent.left = current.left;
            }else{
                parent.right = current.left;
            }
        }
        else if(current.left==null){
            if(current==root){
                root = current.right;
            }else if(isLeftChild){
                parent.left = current.right;
            }else{
                parent.right = current.right;
            }
        }else if(current.left!=null && current.right!=null){

            //now we have found the minimum element in the right sub tree
            Node successor	 = getSuccessor(current);
            if(current==root){
                root = successor;
            }else if(isLeftChild){
                parent.left = successor;
            }else{
                parent.right = successor;
            }
            successor.left = current.left;
        }
        return true;
    }

    public Node getSuccessor(Node deleleNode){
        Node successsor =null;
        Node successsorParent =null;
        Node current = deleleNode.right;
        while(current!=null){
            successsorParent = successsor;
            successsor = current;
            current = current.left;
        }
        //check if successor has the right child, it cannot have left child for sure
        // if it does have the right child, add it to the left of successorParent.
//		successsorParent
        if(successsor!=deleleNode.right){
            successsorParent.left = successsor.right;
            successsor.right = deleleNode.right;
        }
        return successsor;
    }
    public void insert(String item){
        Node newNode = new Node(item);
        if(root==null){
            root = newNode;
            return;
        }
        Node current = root;
        Node parent = null;
        while(true){
            parent = current;
            if(item.compareTo(current.data)<0){
                current = current.left;
                if(current==null){
                    parent.left = newNode;
                    return;
                }
            }else{
                current = current.right;
                if(current==null){
                    parent.right = newNode;
                    return;
                }
            }
        }
    }
    public void display(Node root){
        if(root!=null){
            display(root.left);
            System.out.print(" " + root.data);
            display(root.right);
        }
    }
    public static void main(String arg[]){
        BinarySearchTreeString b = new BinarySearchTreeString();


        insertHelper(b);

    }

    protected static void originalInsert(BinarySearchTreeString b){
        b.insert("3");b.insert("8");
        b.insert("1");b.insert("4");b.insert("6");b.insert("2");b.insert("10");b.insert("9");
        b.insert("20");b.insert("25");b.insert("15");b.insert("16");
        System.out.println("Original Tree : ");
        b.display(b.root);
        System.out.println("");
        System.out.println("Check whether Node with value 4 exists : " + b.find("4"));
        System.out.println("Delete Node with no children (2) : " + b.delete("2"));
        b.display(b.root);
        System.out.println("\n Delete Node with one child (4) : " + b.delete("4"));
        b.display(b.root);
        System.out.println("\n Delete Node with Two children (10) : " + b.delete("10"));
        b.display(b.root);
    }

    protected static void insertHelper(BinarySearchTreeString b){
        b.insert("20");
        b.display(b.root);

        System.out.println();

        b.insert("15");
        b.display(b.root);

        System.out.println();

        b.insert("10");
        b.display(b.root);

        System.out.println();


        b.insert("18");
        b.display(b.root);

        System.out.println();


        b.insert("116");
        b.display(b.root);

        System.out.println();


        b.insert("19");
        b.display(b.root);

        System.out.println();

        b.insert("25");

        b.display(b.root);
        System.out.println();

        b.insert("17");

        b.display(b.root);
        System.out.println();

        b.delete("115");

        System.out.println();
        b.display(b.root);
    }

    class Node{
        String data;
        Node left;
        Node right;
        public Node(String data){
            this.data = data;
            left = null;
            right = null;
        }


    }
}


