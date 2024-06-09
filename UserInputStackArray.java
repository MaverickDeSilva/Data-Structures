package Algorithms;
import java.util.Scanner;

	public class UserInputStackArray {

	    private int[] arr;
	    private int top;
	    private final int maxSize;

	    public UserInputStackArray(int size) {
	        this.maxSize = size;
	        arr = new int[maxSize];
	        top = -1;
	    }

	    public boolean isEmpty() {
	        return top < 0;
	    }

	    public boolean isFull() {
	        return top == maxSize - 1;
	    }

	    public void push() {
	        if (isFull()) {
	            System.out.println("Stack Overflow!");
	            return;
	        }

	        Scanner sc = new Scanner(System.in);
	        System.out.print("Enter element to push: ");
	        int element = sc.nextInt();
	        arr[++top] = element;
	        System.out.println(element + " pushed to stack");
	    }

	    public int pop() {
	        if (isEmpty()) {
	            System.out.println("Stack Underflow!");
	            return -1;
	        }

	        int popped = arr[top--];
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
	            System.out.print(arr[i] + " ");
	        }
	        System.out.println();
	    }

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        System.out.print("Enter stack size: ");
	        int size = sc.nextInt();

	        UserInputStackArray stack = new UserInputStackArray(size);

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
