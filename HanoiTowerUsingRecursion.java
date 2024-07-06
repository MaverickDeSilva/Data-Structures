package Algorithms;
import java.util.Scanner;


	public class HanoiTowerUsingRecursion {

	    // Recursive function to solve Tower of Hanoi puzzle
	    public static void solveHanoi(int n, char source, char auxiliary, char destination) {
	        // Base case: if only one disk, move it from source to destination
	        if (n == 1) {
	            System.out.println("Move disk 1 from rod " + source + " to rod " + destination);
	            return;
	        }
	        
	        // Recursive case:
	        // Move n-1 disks from source to auxiliary using destination as intermediate
	        solveHanoi(n - 1, source, destination, auxiliary);
	        
	        // Move the nth disk from source to destination
	        System.out.println("Move disk " + n + " from rod " + source + " to rod " + destination);
	        
	        // Move the n-1 disks from auxiliary to destination using source as intermediate
	        solveHanoi(n - 1, auxiliary, source, destination);
	    }

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        
	        // Taking number of disks as input from the user
	        System.out.print("Enter the number of disks: ");
	        int n = scanner.nextInt();
	        
	        // Solving the Tower of Hanoi puzzle for n disks
	        solveHanoi(n, 'A', 'B', 'C');
	        
	        scanner.close();
	    }
	}
