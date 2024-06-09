package Algorithms;
import java.util.LinkedList;
import java.util.Scanner;

	public class Steque<T> {
	    private LinkedList<T> list;

	    public Steque() {
	        list = new LinkedList<>();
	    }

	    public void push(T item) {
	        list.addFirst(item);
	    }

	    public void enqueue(T item) {
	        list.addLast(item);
	    }

	    public T pop() {
	        if (isEmpty()) {
	            throw new RuntimeException("Steque is empty");
	        }
	        return list.removeFirst();
	    }

	    public boolean isEmpty() {
	        return list.isEmpty();
	    }

	    public void printSteque() {
	        System.out.println("Steque: " + list);
	    }

	    public static void main(String[] args) {
	        Steque<Integer> steque = new Steque<>();
	        Scanner scanner = new Scanner(System.in);
	        String command;
	        int value;

	        System.out.println("Enter commands: push <value>, enqueue <value>, pop, print, or exit");

	        while (true) {
	            command = scanner.next();

	            switch (command) {
	                case "push":
	                    value = scanner.nextInt();
	                    steque.push(value);
	                    break;
	                case "enqueue":
	                    value = scanner.nextInt();
	                    steque.enqueue(value);
	                    break;
	                case "pop":
	                    try {
	                        System.out.println("Popped: " + steque.pop());
	                    } catch (RuntimeException e) {
	                        System.out.println(e.getMessage());
	                    }
	                    break;
	                case "print":
	                    steque.printSteque();
	                    break;
	                case "exit":
	                    scanner.close();
	                    return;
	                default:
	                    System.out.println("Invalid command");
	            }
	        }
	    }
	}
