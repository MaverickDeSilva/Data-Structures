package Algorithms;
import java.util.LinkedList;
import java.util.Scanner;
public class UserInputFIFOQueueWithLinkList {


	    private LinkedList<Integer> queue;

	    public UserInputFIFOQueueWithLinkList() {
	        queue = new LinkedList<>();
	    }

	    public boolean isEmpty() {
	        return queue.isEmpty();
	    }

	    public void enqueue(int data) {
	        queue.addLast(data); // Add element to the end for FIFO behavior
	        System.out.println("Enqueued: " + data);
	    }

	    public int dequeue() {
	        if (isEmpty()) {
	            System.out.println("Queue underflow!");
	            return -1;
	        }

	        return queue.removeFirst(); // Remove element from the front for FIFO behavior
	    }

	    // Method to check if the queue is empty and iterate through elements (informational)
	    public void displayQueue() {
	        if (isEmpty()) {
	            System.out.println("Queue is empty!");
	            return;
	        }

	        System.out.print("Queue: ");
	        for (Integer element : queue) {
	            System.out.print(element + " ");
	        }
	        System.out.println();
	    }

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        UserInputFIFOQueueWithLinkList queue = new UserInputFIFOQueueWithLinkList();

	        int choice, data;

	        do {
	            System.out.println("\n1. Enqueue");
	            System.out.println("2. Dequeue");
	            System.out.println("3. Display Queue (informational)");
	            System.out.println("4. Exit");
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
	                    queue.displayQueue();
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
