package unit2StarterCode;


import java.util.Arrays;
import java.util.Scanner;
/**
* This is a starter class for the Sorting Unit. This class will contain all of the methods that will
* sort a list using various algorithms.
* Sept 9, 2023
* @author Christina Kemp
*
*/
/**
 * The Sort class provides various sorting algorithms including Bubble Sort,
 * Insertion Sort, Selection Sort, Quick Sort, and Merge Sort. It also tracks 
 * the number of swaps, loops, and comparisons made during sorting for efficiency testing.
 */
public class Sort {

    // Counters to track the number of swaps, loops, and comparisons
    public static long swapCounter;
    public static long loopCounter;
    public static long comparisonCounter;

    /**
     * The entry point for the program to test sorting methods.
     * Prompts the user to input an array and then calls the sorting method.
     *
     * @param args Command-line 
     *      */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Get array values from the user
        System.out.print("How many numbers would you like: ");
        int n = sc.nextInt();
        int[] array = new int[n];

        System.out.println("Please enter the numbers one at a time.");
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        
        System.out.println(Arrays.toString(array)); // Prints the unsorted list
        
        // Call the bubble sort method
        bubble(array);
        
        System.out.println(Arrays.toString(array)); // Prints the sorted list
        sc.close();
    }

    /**
     * Swaps the elements at indices i and j in the given array.
     *
     * @param arr The array containing the elements to be swapped
     * @param i The first index to be swapped
     * @param j The second index to be swapped
     */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        Sort.swapCounter++; // Increment swap counter
    }

    /**
     * Sorts the given array using the Bubble Sort algorithm.
     * This algorithm repeatedly steps through the list, compares adjacent elements, 
     * and swaps them if they are in the wrong order.
     *
     * @param arr The array to be sorted
     */
    public static void bubble(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            Sort.loopCounter++; // Increment loop counter for outer loop
            for (int j = 0; j < arr.length - i - 1; j++) {
                Sort.comparisonCounter++; // Increment comparison counter
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    /**
     * Sorts the given array using the Insertion Sort algorithm.
     * The algorithm builds the sorted array one element at a time by picking 
     * elements from the unsorted portion and inserting them into the correct position.
     *
     * @param arr The array to be sorted
     */
    public static void insertion(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            Sort.loopCounter++; // Increment loop counter for outer loop
            int j = i;
            while (j > 0 && arr[j - 1] > arr[j]) {
                Sort.comparisonCounter++; // Increment comparison counter
                swap(arr, j, j - 1); // Swap elements if they are out of order
                j--;
            }
        }
    }

    /**
     * Sorts the given array using the Selection Sort algorithm.
     * The algorithm repeatedly finds the minimum element from the unsorted portion 
     * and swaps it with the first unsorted element.
     *
     * @param arr The array to be sorted
     */
    public static void selection(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            Sort.loopCounter++; // Increment loop counter for outer loop
            int temp = i;
            for (int j = i + 1; j < arr.length; j++) {
                Sort.loopCounter++; // Increment loop counter for inner loop
                if (arr[j] < arr[temp]) {
                    Sort.comparisonCounter++; // Increment comparison counter
                    temp = j;
                }
            }
            // Swap if a smaller element was found
            if (temp != i) {
                swap(arr, i, temp);
            }
        }
    }

    /**
     * Sorts the given array using the Quick Sort algorithm.
     * Quick Sort is a divide-and-conquer algorithm that recursively partitions 
     * the array into smaller subarrays and sorts them.
     *
     * @param arr The array to be sorted
     */
    public static void quick(int[] arr) {
        quick(arr, 0, arr.length - 1);
    }

    /**
     * Helper method to recursively perform Quick Sort on the array.
     *
     * @param arr The array to be sorted
     * @param start The starting index of the subarray to be sorted
     * @param end The ending index of the subarray to be sorted
     */
    private static void quick(int[] arr, int start, int end) {
        if (start < end) {
            int pivot = partition(arr, start, end);
            quick(arr, start, pivot - 1); // Recursively sort the left subarray
            quick(arr, pivot + 1, end);   // Recursively sort the right subarray
        }
    }

    /**
     * Partitions the array into two halves and returns the pivot index.
     * The pivot element is placed in the correct sorted position.
     *
     * @param arr The array to be partitioned
     * @param start The starting index of the subarray to be partitioned
     * @param end The ending index of the subarray to be partitioned
     * @return The index of the pivot element
     */
    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[(start + end) / 2];  // Select the middle element as pivot
        swap(arr, (start + end) / 2, end);   // Move the pivot to the end
        int i = start - 1;

        for (int j = start; j < end; j++) {
            Sort.loopCounter++; // Increment loop counter
            if (arr[j] <= pivot) {
                Sort.comparisonCounter++; // Increment comparison counter
                i++;
                swap(arr, i, j); // Swap if the element is less than or equal to the pivot
            }
        }
        swap(arr, i + 1, end); // Move the pivot to its correct position
        return i + 1;
    }

    /**
     * Sorts the given array using the Merge Sort algorithm.
     * Merge Sort is a divide-and-conquer algorithm that recursively splits the 
     * array into smaller parts, sorts them, and merges them back together.
     *
     * @param arr The array to be sorted
     */
    public static void merge(int[] arr) {
        merge(arr, 0, arr.length - 1);
    }

    /**
     * Helper method to recursively perform Merge Sort on the array.
     *
     * @param arr The array to be sorted
     * @param start The starting index of the subarray to be sorted
     * @param end The ending index of the subarray to be sorted
     */
    private static void merge(int[] arr, int start, int end) {
        if (start < end) {
            int mid = start + (end - start) / 2;
            merge(arr, start, mid);       // Recursively sort the left half
            merge(arr, mid + 1, end);     // Recursively sort the right half
            merging(arr, start, mid, end); // Merge the two sorted halves
        }
    }

    /**
     * Merges two sorted subarrays into one sorted array.
     *
     * @param arr The array to be merged
     * @param start The starting index of the subarray
     * @param mid The middle index where the array is split
     * @param end The ending index of the subarray
     */
    private static void merging(int[] arr, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int i = start, j = mid + 1, k = 0;

        // Merge the two halves into the temp array
        while (i <= mid && j <= end) {
            Sort.comparisonCounter++; // Increment comparison counter
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        // Copy the remaining elements of the left half
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        // Copy the remaining elements of the right half
        while (j <= end) {
            temp[k++] = arr[j++];
        }

        // Copy the sorted elements back into the original array
        for (k = 0; k < temp.length; k++) {
            Sort.loopCounter++; // Increment loop counter
            arr[start + k] = temp[k];
        }
    }
}
