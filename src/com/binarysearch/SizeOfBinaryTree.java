package com.binarysearch;

public class SizeOfBinaryTree <T  extends Comparable <T>>{
    static class MyBinaryNode<T>{
        //define variables for binary search tree
        T data;
        MyBinaryNode left;
        MyBinaryNode right;

        //Declaring parameterized constructor
        MyBinaryNode (T value){
            this.data =value;
            this.left = null;
            this.right =null;
        }
    }
    Integer [] passValue = { 56 ,30,70,22,40,12,45,78,1,98,88,11,44};

    MyBinaryNode root =null;

    //adding function to insert  a new node with given data in binary search tree
    public void addToBST(T data){
        this.root =this.insertRec(this.root,data);
    }
    public MyBinaryNode insertRec(MyBinaryNode node,T data){
        if(node == null){
            this.root =new MyBinaryNode(data);
            return this.root;
        }
        int comparator =data.compareTo((T) node.data);

        //otherwise recursively adding down the tree
        if(comparator <=0){
            node.left =this.insertRec(node.left ,data);
        }
        else {
            node.right = this.insertRec(node.right ,data);
        }
        return node;
    }
    //printing the binary tree
    public void traversal(){
        inorderUtil(this.root);
    }
    //Utility function for inorder traversal of tree
    public void inorderUtil(MyBinaryNode node){
        if ((node == null)) {

            return;
        }
        inorderUtil(node.left);
        System.out.println(node.data+ "");
        inorderUtil((node.right));
    }
    //calculating height of BST
    public int calculatingHeight(MyBinaryNode node){
        if (node == null){
            return 0;
        }else {

            //computing depth of each subtree
            int leftDepth = calculatingHeight(node.left);
            int rightDepth = calculatingHeight(node.right);

            if(leftDepth > rightDepth){
                return (leftDepth +1);
            }
            else {
                return (rightDepth +1);
            }
        }
    }

    //calculating the size  of BST
    public void calculatingSize(){
        System.out.println("The size of the Binary Search tree is : " + size(root));
    }

    //compute the size recursively
    public int size(MyBinaryNode node) {
        if (node == null) {
            return 0;
        } else {
            return (size(node.left) + 1 + size(node.right));
        }
    }

        //check all the elements from BST
        public boolean ifNodeExist(MyBinaryNode node , T key){
        if(node == null)
            return false;
            if (node.data == key)
                return true;

        //then recur on left subtree
    boolean res1 = ifNodeExist(node.left,key);

    //node found ,no need to look further
            if (res1)
                return true;

            //node is not found in left.
            //so recur on right subtree
            boolean res2 =ifNodeExist(node.right,key);

            return res2;
    }

    public static void main(String [] args){
        SizeOfBinaryTree tree =new SizeOfBinaryTree();

        //adding values to bst
        for (int i=0;i<tree.passValue.length;i++){
            tree.addToBST(tree.passValue[i]);
        }
        //printing all values of bst
        tree.traversal();
        System.out.println();
        //calculating the size of BST
        tree.calculatingSize();
        //calculating height of BST
        System.out.println("The height of the BST is:"  +tree.calculatingHeight(tree.root));

        //checking if all values are present in BST
        boolean [] flag =new boolean[tree.passValue.length];
        for (int i=0;i<tree.passValue.length;i++){
            flag[i] =tree.ifNodeExist(tree.root,tree.passValue[i]);
            System.out.println(tree.passValue[i]+  " is present   |   "  +flag[i] );
        }
    }
}

