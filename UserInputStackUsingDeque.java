package Algorithms;

	import java.util.Deque;
	import java.util.LinkedList;
	import java.util.Scanner;

	public class UserInputStackUsingDeque {

	    private Deque<Integer> mainDeque;
	    private Deque<Integer> tempDeque;

	    public UserInputStackUsingDeque() {
	        mainDeque = new LinkedList<>();
	        tempDeque = new LinkedList<>();
	    }

	    public boolean isEmpty() {
	        return mainDeque.isEmpty();
	    }

	    public void push() {
	        Scanner sc = new Scanner(System.in);
	        System.out.print("Enter element to push: ");
	        int element = sc.nextInt();

	        // Move elements from mainDeque to tempDeque (reversing order)
	        while (!mainDeque.isEmpty()) {
	            tempDeque.offerFirst(mainDeque.pollLast());
	        }

	        // Add new element to mainDeque (becomes the new top)
	        mainDeque.offerFirst(element);
	        System.out.println(element + " pushed to stack");

	        // Move elements back from tempDeque to mainDeque (preserving order)
	        while (!tempDeque.isEmpty()) {
	            mainDeque.offerLast(tempDeque.pollFirst());
	        }
	    }

	    public int pop() {
	        if (isEmpty()) {
	            System.out.println("Stack Underflow!");
	            return -1;
	        }

	        int popped = mainDeque.pollFirst();
	        System.out.println(popped + " popped from stack");
	        return popped;
	    }

	    public void display() {
	        if (isEmpty()) {
	            System.out.println("Stack is empty!");
	            return;
	        }

	        System.out.print("Stack elements: ");
	        // Create a temporary deque to avoid modifying the main stack
	        Deque<Integer> temp = new LinkedList<>(mainDeque);
	        while (!temp.isEmpty()) {
	            System.out.print(temp.pollFirst() + " ");
	        }
	        System.out.println();
	    }

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        System.out.print("Enter stack size (ignored for Deque): ");
	        sc.nextInt(); // Size ignored for Deque

	        UserInputStackUsingDeque stack = new UserInputStackUsingDeque();

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