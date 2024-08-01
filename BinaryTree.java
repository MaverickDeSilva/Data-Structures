package Algorithms;

import java.util.Scanner;

//Node class representing each node in the binary tree
class Node {
 int key;
 Node left, right;

 public Node(int item) {
     key = item;
     left = right = null;
 }
}

//BinaryTree class containing the root node and methods to manage the tree
class BinaryTree {
 Node root;

 // Constructor for the BinaryTree
 BinaryTree() {
     root = null;
 }

 // Method to insert a new key into the binary tree
 void insert(int key) {
     root = insertRec(root, key);
 }

 // Recursive method to insert a new key into the binary tree
 Node insertRec(Node root, int key) {
     // If the tree is empty, return a new node
     if (root == null) {
         root = new Node(key);
         return root;
     }

     // Otherwise, recur down the tree
     if (key < root.key)
         root.left = insertRec(root.left, key);
     else if (key > root.key)
         root.right = insertRec(root.right, key);

     // Return the unchanged root node
     return root;
 }

 // Method to perform in-order traversal of the binary tree
 void inorder() {
     inorderRec(root);
 }

 // Recursive method to perform in-order traversal of the binary tree
 void inorderRec(Node root) {
     if (root != null) {
         inorderRec(root.left);
         System.out.print(root.key + " ");
         inorderRec(root.right);
     }
 }

 public static void main(String[] args) {
     BinaryTree tree = new BinaryTree();
     Scanner scanner = new Scanner(System.in);

     // Taking user input for the number of elements
     System.out.println("Enter the number of elements in the binary tree:");
     int n = scanner.nextInt();

     // Taking user input for the elements
     System.out.println("Enter the elements of the binary tree:");
     for (int i = 0; i < n; i++) {
         int key = scanner.nextInt();
         tree.insert(key);
     }

     // Display the in-order traversal of the binary tree
     System.out.println("In-order traversal of the binary tree:");
     tree.inorder();

     scanner.close();
 }
}

