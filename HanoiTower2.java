package Algorithms;
import java.util.Scanner;


	public class HanoiTower2 {
		
	    public static void solveHanoi(int n, char source, char auxiliary, char destination) {
	        if (n == 1) {
	            System.out.println("Move disk 1 from rod " + source + " to rod " + destination);
	            return;
	        }

	        solveHanoi(n - 1, source, destination, auxiliary);
	        
	        System.out.println("Move disk " + n + " from rod " + source + " to rod " + destination);
	        

	        solveHanoi(n - 1, auxiliary, source, destination);
	    }

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        

	        System.out.print("Enter the number of disks: ");
	        int n = scanner.nextInt();

	        solveHanoi(n, 'A', 'B', 'C');
	        
	        scanner.close();
	    }
	}
