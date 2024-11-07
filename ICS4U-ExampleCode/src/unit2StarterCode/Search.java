/**
*
*/
package unit2StarterCode;
import java.util.Scanner;
/**
 * 
 */
/**
 * The Search class provides methods for searching a number in an array.
 * It includes implementations for linear and binary search algorithms, 
 * as well as counters to track the number of loops and comparisons made during the search.
 */
public class Search {

    // Counter for the number of loops executed
    public static long loopCounter;

    // Counter for the number of comparisons made
    public static long comparisonCounter;

    /**
     * The main method prompts the user for input, calls the appropriate search method, 
     * and displays the result.
     * 
     * @param args Command-line arguments (not used)
     */
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

        System.out.println("What value would you like to search for?");
        int num = sc.nextInt();

        // Sort the array if needed using your Sort class (currently commented out)
        // Sort.quick(array);

        // Call the linear search method
        int index = linear(array, num);

        // Output the result of the search
        System.out.println("Your number, " + num + ", was found at index " + index);

        sc.close();
    }

    /**
     * Performs a linear search on the given array to find the target value.
     * This method counts the number of loop iterations and comparisons during the search.
     *
     * @param arr The array to search
     * @param target The value to search for
     * @return The index of the target value if found, otherwise -1
     */
    public static int linear(int[] arr, int target) {
        // Linear search through the array
        for (int i = 0; i < arr.length; i++) {
            Search.loopCounter++; // Increment the loop counter for each iteration
            if (arr[i] == target) {
                Search.comparisonCounter++; // Increment the comparison counter when a comparison occurs
                return i; // Return the index where the target is found
            }
        }
        return -1; // Return -1 if the target is not found in the array
    }

    /**
     * Performs a binary search on the given sorted array to find the target value.
     * This method counts the number of loop iterations and comparisons during the search.
     *
     * @param arr The sorted array to search
     * @param target The value to search for
     * @return The index of the target value if found, otherwise -1
     */
    public static int binary(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        // Binary search through the array
        while (low <= high) {
            Search.loopCounter++; // Increment the loop counter for each iteration
            int mid = low + (high - low) / 2;

            // Perform comparisons and adjust search range based on target comparison
            if (arr[mid] == target) {
                Search.comparisonCounter++; // Increment the comparison counter
                return mid; // Return the index where the target is found
            } else if (arr[mid] < target) {
                Search.comparisonCounter++; // Increment the comparison counter
                low = mid + 1; // Move to the right half of the array
            } else {
                high = mid - 1; // Move to the left half of the array
            }
        }

        return -1; // Return -1 if the target is not found in the array
    }
}
