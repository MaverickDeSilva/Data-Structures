package Algorithms;

import java.util.ArrayList;
import java.util.Scanner;

	public class UserInputStackUsingCollections {

	    private ArrayList<Integer> stack;
	    private int top;

	    public UserInputStackUsingCollections() {
	        stack = new ArrayList<>();
	        top = -1;
	    }

	    public boolean isEmpty() {
	        return top < 0;
	    }

	    public void push() {
	        Scanner sc = new Scanner(System.in);
	        System.out.print("Enter element to push: ");
	        int element = sc.nextInt();
	        stack.add(element);
	        top++;
	        System.out.println(element + " pushed to stack");
	    }

	    public int pop() {
	        if (isEmpty()) {
	            System.out.println("Stack Underflow!");
	            return -1;
	        }

	        int popped = stack.remove(top);
	        top--;
	        System.out.println(popped + " popped from stack");
	        return popped;
	    }

	    public void display() {
	        if (isEmpty()) {
	            System.out.println("Stack is empty!");
	            return;
	        }

	        System.out.print("Stack elements: ");
	        for (int i = top; i >= 0; i--) {
	            System.out.print(stack.get(i) + " ");
	        }
	        System.out.println();
	    }

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        System.out.print("Enter stack size : ");
	        sc.nextInt(); // Size ignored for ArrayList

	        UserInputStackUsingCollections stack = new UserInputStackUsingCollections();

	        int choice;
	        do {
	            System.out.println("\n1. Push");
	            System.out.println("2. Pop");
	            System.out.println("3. Display");
	            System.out.println("4. Exit");
	            System.out.print("Enter your choice: ");
	            choice = sc.nextInt();

	            switch (choice) {
	                case 1:
	                    stack.push();
	                    break;
	                case 2:
	                    stack.pop();
	                    break;
	                case 3:
	                    stack.display();
	                    break;
	                case 4:
	                    System.out.println("Exiting...");
	                    break;
	                default:
	                    System.out.println("Invalid choice!");
	            }
	        } while (choice != 4);
	    }
}