package Algorithms;
import java.util.Scanner;
import java.util.Stack;
public class UserInputFIFOQueueWithStacks {

	    private Stack<Integer> stack1; // For enqueue operations
	    private Stack<Integer> stack2; // For dequeue operations

	    public UserInputFIFOQueueWithStacks() {
	        stack1 = new Stack<>();
	        stack2 = new Stack<>();
	    }

	    public boolean isEmpty() {
	        return stack1.isEmpty() && stack2.isEmpty();
	    }

	    public void enqueue(int data) {
	        stack1.push(data);
	        System.out.println("Enqueued: " + data);
	    }

	    public int dequeue() {
	        // Move elements from stack1 to stack2 (if not already done)
	        if (stack2.isEmpty()) {
	            while (!stack1.isEmpty()) {
	                stack2.push(stack1.pop());
	            }
	        }

	        if (stack2.isEmpty()) {
	            System.out.println("Queue underflow!");
	            return -1;
	        }

	        return stack2.pop();
	    }

	    public void displayStack1() {
	        if (stack1.isEmpty()) {
	            System.out.println("Stack 1 is empty!");
	            return;
	        }

	        System.out.print("Stack 1: ");
	        System.out.println(stack1); // Print the entire stack content
	    }

	    public void displayStack2() {
	        if (stack2.isEmpty()) {
	            System.out.println("Stack 2 is empty!");
	            return;
	        }

	        System.out.print("Stack 2: ");
	        System.out.println(stack2); // Print the entire stack content
	    }

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        UserInputFIFOQueueWithStacks queue = new UserInputFIFOQueueWithStacks();

	        int choice, data;

	        do {
	            System.out.println("\n1. Enqueue");
	            System.out.println("2. Dequeue");
	            System.out.println("3. Display Stack 1");
	            System.out.println("4. Display Stack 2");
	            System.out.println("5. Exit");
	            System.out.print("Enter your choice: ");
	            choice = scanner.nextInt();

	            switch (choice) {
	                case 1:
	                    System.out.print("Enter data to enqueue: ");
	                    data = scanner.nextInt();
	                    queue.enqueue(data);
	                    break;
	                case 2:
	                    data = queue.dequeue();
	                    if (data != -1) {
	                        System.out.println("Dequeued: " + data);
	                    }
	                    break;
	                case 3:
	                    queue.displayStack1();
	                    break;
	                case 4:
	                    queue.displayStack2();
	                    break;
	                case 5:
	                    System.out.println("Exiting...");
	                    break;
	                default:
	                    System.out.println("Invalid choice!");
	            }
	        } while (choice != 5);
	    }
	}
