package com.binarysearch;

public class CreateBinaryTree  <T extends  Comparable<T>> {
    //nested class
    static class MyBinaryNode<T> {

        //define variables for binary search tree
        T data;
        MyBinaryNode left;
        MyBinaryNode right;

        //declaring parameterised constructor
        MyBinaryNode(T value) {
            this.data = value;
            this.left = null;
            this.right = null;
        }
    }

    MyBinaryNode root = null;

    //adding to binary search tree by linked list
    public void addToBinarySearchTree(T data) {
        this.root = this.insertRec(this.root, data);
    }

    //ultimate function to insert a newNode with given data in binary search tree
    public MyBinaryNode insertRec(MyBinaryNode node, T data) {
        if (node == null) {
            this.root = new MyBinaryNode(data);
            return this.root;
        }
        int comparator = data.compareTo((T) node.data);
        //otherwise,recursively adding down the tree
        if(comparator <=0){
            node.left =this.insertRec(node.left,data);
        }else {
            node.right =this.insertRec(node.right ,data);
        }
        return node;
    }

    //printing the binary search tree
    public void traversal(){
        inorderUtil(this.root);
    }
    //utility function for inorder traversal of tree
    public void  inorderUtil(MyBinaryNode node){
        if (node == null){
            return;
        }
        inorderUtil(node.left);
        System.out.println(node.data+ "");
        inorderUtil(node.right);
    }
    public static void main(String [] args){
        CreateBinaryTree tree =new CreateBinaryTree();

        tree.addToBinarySearchTree(56);
        tree.addToBinarySearchTree(30);
        tree.addToBinarySearchTree(70);
        tree.traversal();
    }
}
