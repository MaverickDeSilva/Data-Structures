package Algorithms;

import java.util.Scanner;

public class QuickSortUsingRecursion {

    // Method to partition the array on the basis of pivot element
    int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = (low - 1); // Index of smaller element

        for (int j = low; j < high; j++) {
            // If current element is smaller than or equal to pivot
            if (arr[j] <= pivot) {
                i++;

                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    // Method to sort array using Quick Sort recursively
    void sort(int arr[], int low, int high) {
        if (low < high) {
            // Partition the array and get the pivot index
            int pi = partition(arr, low, high);

            // Recursively sort elements before and after partition
            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }

    // Utility function to print the array
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        // Taking user input for array size
        System.out.println("Enter the number of elements in the array:");
        int n = scanner.nextInt();
        int arr[] = new int[n];

        // Taking user input for array elements
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        QuickSortUsingRecursion ob = new QuickSortUsingRecursion();
        ob.sort(arr, 0, arr.length - 1);

        System.out.println("Sorted array:");
        printArray(arr);

        scanner.close();
    }
}

