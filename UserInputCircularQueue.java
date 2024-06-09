package Algorithms;

import java.util.Scanner;

public class UserInputCircularQueue {
  private int capacity;
  private int[] items;
  private int head;
  private int tail;
  private int size;

  public UserInputCircularQueue(int capacity) {
    this.capacity = capacity;
    items = new int[capacity];
    head = tail = -1;
    size = 0;
  }

  // Check if the queue is full
  public boolean isFull() {
    return size == capacity;
  }

  // Check if the queue is empty
  public boolean isEmpty() {
    return size == 0;
  }

  // Enqueue an element
  public void enqueue(int element) {
    if (isFull()) {
      System.out.println("Queue overflow");
      return;
    }
    if (head == -1) {
      head = 0;
    }
    tail = (tail + 1) % capacity;
    items[tail] = element;
    size++;
  }

  // Dequeue an element
  public int dequeue() {
    if (isEmpty()) {
      System.out.println("Queue underflow");
      return -1;
    }
    int element = items[head];
    if (head == tail) {
      head = tail = -1;
    } else {
      head = (head + 1) % capacity;
    }
    size--;
    return element;
  }

  // Print the queue elements
  public void printQueue() {
    if (isEmpty()) {
      System.out.println("Queue is empty");
      return;
    }
    System.out.print("Queue: ");
    for (int i = head; i != tail; i = (i + 1) % capacity) {
      System.out.print(items[i] + " ");
    }
    System.out.println(items[tail]);
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter the queue capacity: ");
    int capacity = scanner.nextInt();
    UserInputCircularQueue queue = new UserInputCircularQueue(capacity);

    int choice;
    do {
      System.out.println("\n1. Enqueue");
      System.out.println("2. Dequeue");
      System.out.println("3. Print Queue");
      System.out.println("4. Exit");
      System.out.print("Enter your choice: ");
      choice = scanner.nextInt();

      switch (choice) {
        case 1:
          System.out.print("Enter element to enqueue: ");
          int element = scanner.nextInt();
          queue.enqueue(element);
          break;
        case 2:
          int dequeued = queue.dequeue();
          if (dequeued != -1) {
            System.out.println("Dequeued element: " + dequeued);
          }
          break;
        case 3:
          queue.printQueue();
          break;
        case 4:
          System.out.println("Exiting program");
          break;
        default:
          System.out.println("Invalid choice");
      }
    } while (choice != 4);
  }
}
