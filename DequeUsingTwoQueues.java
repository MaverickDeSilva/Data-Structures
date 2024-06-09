package Algorithms;
import java.util.LinkedList;
import java.util.Queue;

public class DequeUsingTwoQueues {
	    private Queue<Integer> queue1;
	    private Queue<Integer> queue2;

	    public DequeUsingTwoQueues() {
	        queue1 = new LinkedList<>();
	        queue2 = new LinkedList<>();
	    }

	    // Add an element to the front of the deque
	    public void addFront(int element) {
	        queue1.add(element);
	        while (!queue2.isEmpty()) {
	            queue1.add(queue2.poll());
	        }
	        Queue<Integer> temp = queue1;
	        queue1 = queue2;
	        queue2 = temp;
	    }

	    // Add an element to the rear of the deque
	    public void addRear(int element) {
	        queue2.add(element);
	    }

	    // Remove an element from the front of the deque
	    public int removeFront() {
	        if (queue2.isEmpty()) {
	            throw new IllegalStateException("Deque is empty");
	        }
	        return queue2.poll();
	    }

	    // Remove an element from the rear of the deque
	    public int removeRear() {
	        if (queue2.isEmpty()) {
	            throw new IllegalStateException("Deque is empty");
	        }
	        while (queue2.size() > 1) {
	            queue1.add(queue2.poll());
	        }
	        int removedElement = queue2.poll();
	        Queue<Integer> temp = queue1;
	        queue1 = queue2;
	        queue2 = temp;
	        return removedElement;
	    }

	    // Check if the deque is empty
	    public boolean isEmpty() {
	        return queue2.isEmpty();
	    }

	    // Get the size of the deque
	    public int size() {
	        return queue2.size();
	    }

	    public static void main(String[] args) {
	        DequeUsingTwoQueues deque = new DequeUsingTwoQueues();
	        deque.addFront(1);
	        deque.addRear(2);
	        deque.addFront(3);
	        deque.addRear(4);

	        System.out.println("Removed from front: " + deque.removeFront()); // Output: 3
	        System.out.println("Removed from rear: " + deque.removeRear()); // Output: 4
	        System.out.println("Removed from front: " + deque.removeFront()); // Output: 1
	        System.out.println("Removed from rear: " + deque.removeRear()); // Output: 2
	    }
	}

