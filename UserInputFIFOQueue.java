package Algorithms;
import java.util.Scanner;
public class UserInputFIFOQueue{

    private static final int MAX_SIZE = 100; // Maximum size of the queue
    private int[] queue;
    private int front, rear;

    public UserInputFIFOQueue() {
        queue = new int[MAX_SIZE];
        front = rear = -1; // Initialize both to -1 for empty queue
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {
        return rear == MAX_SIZE - 1;
    }

    public void enqueue(int data) {
        if (isFull()) {
            System.out.println("Queue overflow!");
            return;
        }

        // Since the queue is initially empty, set front to 0 for the first element
        if (front == -1) {
            front = 0;
        }

        rear++;
        queue[rear] = data;
        System.out.println("Enqueued: " + data);
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue underflow!");
            return -1;
        }

        int data = queue[front];

        if (front == rear) { // Only element in the queue
            front = rear = -1;
        } else {
            front++;
        }

        return data;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }

        System.out.print("Queue: ");
        for (int i = front; i <= rear; i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserInputFIFOQueue queue = new UserInputFIFOQueue();

        int choice, data;

        do {
            System.out.println("\n1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Display");
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
                    queue.display();
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

