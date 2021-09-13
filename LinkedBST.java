/*
Written by Brady Ruth
 */
public class LinkedBST <T extends Comparable <T>> {
    private class Node {
        T data;  // establish data of any type
        Node leftChild;
        Node rightChild;

        public Node(T aData) {  // create a node containing the data
            data = aData;
            leftChild = rightChild = null;
        }
    }

    private Node root; //head

    public LinkedBST() {  // create a new BST and set the root to null so the first element added becomes the root
        root = null;
    }

    public void add(T aData) {
        if (root == null) {
            root = new Node(aData);  // if the root is null, set the data entered as the root
        } else {
            add(root, aData);  // if the root is not null, add the data as a child node
        }
    }

    private Node add(Node aNode, T aData) {
        if (aNode == null) {
            aNode = new Node(aData);  // if the node passed in doesnt exist, create a new node for the data
        } else if (aData.compareTo(aNode.data) < 0) { //GO LEFT if data is less than the data in the parent node
            aNode.leftChild = add(aNode.leftChild, aData);
        } else if (aData.compareTo(aNode.data) > 0) { //GO RIGHT if the data is greater than the data in the parent node
            aNode.rightChild = add(aNode.rightChild, aData);
        }
        return aNode;  // return the node
    }

    public void printPreorder() {
        printPreorder(root);
    }

    private void printPreorder(Node aNode) {
        if (aNode == null) {
            return;
        }
        System.out.println(aNode.data); //PROCESS
        printPreorder(aNode.leftChild); //LEFT
        printPreorder(aNode.rightChild); //RIGHT
    }

    void printInorder() {
        printInorder(root);
    }

    private void printInorder(Node aNode) {
        if (aNode == null) {
            return;
        }
        printInorder(aNode.leftChild); //LEFT
        System.out.println(aNode.data); //PROCESS
        printInorder(aNode.rightChild); //RIGHT
    }

    public void printPostorder() {
        printPostorder(root);
    }
    private void printPostorder(Node aNode) {
        if (aNode == null) {
            return;
        }
        printPostorder(aNode.leftChild); //LEFT
        printPostorder(aNode.rightChild); //RIGHT
        System.out.println(aNode.data); //PROCESS
    }

    public boolean search(T aData) {
        return search(root, aData);
    }
    private boolean search(Node aNode, T aData) {
        if (aNode == null) {
            return false;
        }
        else if (aData.compareTo(aNode.data) < 0) { //GO LEFT
            return search(aNode.leftChild, aData);
        }
        else if (aData.compareTo(aNode.data) > 0) { //GO RIGHT
            return search(aNode.rightChild, aData);
        }
        return true;  // returns true if a node is found, however it will eventually run into a null node, kicking the program out of the loop
    }

    void remove(T aData) {
        root = remove(root, aData);
    }
    private Node remove(Node aNode, T aData) {
        //Find the Node
        if (aNode == null) {
            return null;
        }
        else if (aData.compareTo(aNode.data) < 0) {
            aNode.leftChild = remove(aNode.leftChild, aData);  // if the data is less than the parent node, continue searching on the left side of the tree
        }
        else if (aData.compareTo(aNode.data) > 0) {
            aNode.rightChild = remove(aNode.rightChild, aData);  // if the data is greater than the parent node, continue searching on the right
        }
        else { //FOUND IT
            if (aNode.rightChild == null) {
                return aNode.leftChild;
            }
            else if (aNode.leftChild == null) {
                return aNode.rightChild;
            }
            Node temp = findMinInTree(aNode.rightChild);
            aNode.data = temp.data;
            aNode.rightChild = remove(aNode.rightChild, temp.data);
        }
        return aNode;
    }
    private Node findMinInTree(Node aNode) {
        if (aNode == null) {
            return null;
        }
        else if (aNode.leftChild == null) {
            return aNode;
        }
        else {
            return findMinInTree(aNode.leftChild);
        }
    }


    private void deleteGreaterThan(double area){
        System.out.println("Deleting values greater than " + area);
        Node temp = root;
    }
}
