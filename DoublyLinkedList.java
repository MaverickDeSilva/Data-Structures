package Algorithms;

	public class DoublyLinkedList<T> {

	    private Node<T> head;
	    private Node<T> tail;

	    public DoublyLinkedList() {
	        head = null;
	        tail = null;
	    }

	    // Node class to store data and references to previous and next nodes
	    private static class Node<T> {
	        private T data;
	        private Node<T> prev;
	        private Node<T> next;

	        public Node(T data) {
	            this.data = data;
	            this.prev = null;
	            this.next = null;
	        }
	    }

	    // Adds a new element to the end of the list
	    public void append(T data) {
	        Node<T> newNode = new Node<>(data);
	        if (isEmpty()) {
	            head = tail = newNode;
	        } else {
	            tail.next = newNode;
	            newNode.prev = tail;
	            tail = newNode;
	        }
	    }

	    // Adds a new element to the beginning of the list
	    public void prepend(T data) {
	        Node<T> newNode = new Node<>(data);
	        if (isEmpty()) {
	            head = tail = newNode;
	        } else {
	            newNode.next = head;
	            head.prev = newNode;
	            head = newNode;
	        }
	    }

	    // Removes and returns the first element from the list
	    public T removeFirst() throws Exception {
	        if (isEmpty()) {
	            throw new Exception();
	        }
	        Node<T> temp = head;
	        if (head == tail) {
	            head = tail = null;
	        } else {
	            head = head.next;
	            head.prev = null;
	        }
	        return temp.data;
	    }

	    // Removes and returns the last element from the list
	    public T removeLast() throws Exception {
	        if (isEmpty()) {
	            throw new Exception();
	        }
	        Node<T> temp = tail;
	        if (head == tail) {
	            head = tail = null;
	        } else {
	            tail = tail.prev;
	            tail.next = null;
	        }
	        return temp.data;
	    }

	    // Checks if the list is empty
	    public boolean isEmpty() {
	        return head == null;
	    }

	    // Traverses the list and prints the data of each node
	    public void printList() {
	        Node<T> current = head;
	        while (current != null) {
	            System.out.print(current.data + " ");
	            current = current.next;
	        }
	        System.out.println();
	    }
}

