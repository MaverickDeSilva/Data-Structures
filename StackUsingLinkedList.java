package Algorithms;

import java.util.EmptyStackException;

public class StackUsingLinkedList<T> {

	    private Node<T> head;
	    private int size;

	    public StackUsingLinkedList() {
	        head = null;
	        size = 0;
	    }

	    // Node class to store data and reference to next node
	    private static class Node<T> {
	        private T data;
	        private Node<T> next;

	        public Node(T data) {
	            this.data = data;
	            this.next = null;
	        }
	    }

	    // Pushes an element onto the stack
	    public void push(T data) {
	        Node<T> newNode = new Node<>(data);
	        newNode.next = head;
	        head = newNode;
	        size++;
	    }

	    // Pops (removes) the top element from the stack
	    public T pop() {
	        if (isEmpty()) {
	            throw new EmptyStackException();
	        }
	        Node<T> temp = head;
	        head = head.next;
	        size--;
	        return temp.data;
	    }

	    // Peeks (returns) the top element without removing it
	    public T peek() {
	        if (isEmpty()) {
	            throw new EmptyStackException();
	        }
	        return head.data;
	    }

	    // Checks if the stack is empty
	    public boolean isEmpty() {
	        return size == 0;
	    }

	    // Returns the size of the stack
	    public int size() {
	        return size;
	    }
	}
