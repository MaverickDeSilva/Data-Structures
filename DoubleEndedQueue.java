package Algorithms;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Scanner;

public class DoubleEndedQueue<T> {

    private Queue<T> frontQueue;
    private Queue<T> backQueue;

    public DoubleEndedQueue() {
        frontQueue = new LinkedList<>();
        backQueue = new LinkedList<>();
    }

    public void addFirst(T element) {
        frontQueue.add(element);
    }

    public void addLast(T element) {
        backQueue.add(element);
    }

    public T removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty");
        }
        if (backQueue.isEmpty()) {
            // Move all elements from frontQueue to backQueue for efficient removal from front
            while (!frontQueue.isEmpty()) {
                backQueue.add(frontQueue.poll());
            }
        }
        return backQueue.poll();
    }

    public T removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty");
        }
        if (frontQueue.isEmpty()) {
            // Move all elements from backQueue to frontQueue for efficient removal from back
            while (!backQueue.isEmpty()) {
                frontQueue.add(backQueue.poll());
            }
        }
        return frontQueue.poll();
    }

    public T peekFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty");
        }
        if (backQueue.isEmpty()) {
            // Move all elements from frontQueue to backQueue for efficient peeking from front
            while (!frontQueue.isEmpty()) {
                backQueue.add(frontQueue.poll());
            }
        }
        return backQueue.peek();
    }

    public T peekLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty");
        }
        if (frontQueue.isEmpty()) {
            // Move all elements from backQueue to frontQueue for efficient peeking from back
            while (!backQueue.isEmpty()) {
                frontQueue.add(backQueue.poll());
            }
        }
        return frontQueue.peek();
    }

    public boolean isEmpty() {
        return frontQueue.isEmpty() && backQueue.isEmpty();
    }

    public void displayQueues() {
        System.out.println("Front Queue: " + frontQueue);
        System.out.println("Back Queue: " + backQueue);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DoubleEndedQueue<Integer> deque = new DoubleEndedQueue<>();

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Add First");
            System.out.println("2. Add Last");
            System.out.println("3. Remove First");
            System.out.println("4. Remove Last");
            System.out.println("5. Peek First");
            System.out.println("6. Peek Last");
            System.out.println("7. Display Queues");
            System.out.println("8. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter element to add first:");
                    int element = scanner.nextInt();
                    deque.addFirst(element);
                    break;
                case 2:
                    System.out.println("Enter element to add last:");
                    element = scanner.nextInt();
                    deque.addLast(element);
                    break;
                case 3:
                    try {
                        element = deque.removeFirst();
                        System.out.println("Removed element: " + element);
                    } catch (NoSuchElementException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    try {
                        element = deque.removeLast();
                        System.out.println("Removed element: " + element);
                    } catch (NoSuchElementException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    try {
                        element = deque.peekFirst();
                        System.out.println("First element: " + element);
                    } catch (NoSuchElementException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 6:
                    try {
                        element = deque.peekLast();
                        System.out.println("Last element: " + element);
                    } catch (NoSuchElementException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 7:
                    deque.displayQueues();
                    break;
                case 8:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}


