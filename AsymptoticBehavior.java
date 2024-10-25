/**
 * Author:      Jack Pender, Emma Holt
 * Date:        October 2024
 * Class:       APCSA
 * Description: Creates 2 arrays, one random and one pre-sorted,
 *              then sorts the random array and searched for a target
 *              in an array. Finds the time it takes for each
 *              process and the time for the whole main method
 *              to execute.
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class AsymptoticBehavior {
    private static int target;
    private static double localTimeMillis;


    public static void main(String[] a) throws FileNotFoundException {
        long   startTime  = System.nanoTime();
        int[]  randArr    = generateRandomArray();
        long   endTime    = System.nanoTime();
        long   totalTime  = endTime - startTime;
        System.out.println("Generating random array: " + totalTime);

        startTime        = System.nanoTime();
        int[]  sortedArr = generateSortedArray();
        endTime          = System.nanoTime();
        totalTime        = endTime - startTime;
        System.out.println("Generating sorted array: " +  totalTime);

        startTime = System.nanoTime();
        sortArray(randArr);
        endTime   = System.nanoTime();
        totalTime = endTime - startTime;
        System.out.println("Sorting random array: " + totalTime);

        getTarget();
        startTime       = System.nanoTime();
        boolean inArray = binarySearch(randArr, target);
        endTime         = System.nanoTime();
        totalTime       = endTime - startTime;
        System.out.println("Searching for target: " + totalTime);
        System.out.println("Target in array is " + inArray);
    }

    /**
     * Generates an array with 500000 indexes with random integers in
     * each index
     * @return
     */
    public static int[] generateRandomArray() {
        Random random = new Random();
        int[]  intArr = new int[100000];

        for(int i = 0; i < 100000; i++) {
            int randInt = random.nextInt(100000);
            intArr[i] = randInt;
        }
        return intArr;
    }

    /**
     * Generates an array with 500000 indexes with increasing integers
     * in each index
     * @return
     */
    public static int[] generateSortedArray() {
        int[] intArr = new int[100000];

        for(int i = 0; i < 100000; i++) {
            intArr[i] = i;
        }

        return intArr;
    }

    /**
     * Sorts an array via bubble sort
     * @param arr
     */
    public static void sortArray(int[] arr) {
        int n = arr.length;
        int temp = 0;
        for(int i = 0; i < n; i++){
            for(int j = 1; j < (n - i); j++){
                if(arr[j-1] > arr[j]){
                    temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    /**
     * Finds a target integer from a text file
     * @throws FileNotFoundException
     */
    public static void getTarget() throws FileNotFoundException {
        FileReader reader;
        String fileInputName = "data.txt";
        Scanner scan = null;

        scan = new Scanner(new BufferedReader(new FileReader(fileInputName)));
        int int1 = scan.nextInt();

        target = int1;
    }

    /**
     * Performs a binary search (cutting a selection in half
     * until the target is found (or where it should be)
     * @param arr
     * @param target
     * @return
     */
    public static boolean binarySearch(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target)
                return true;

            if (arr[mid] < target)
                low = mid + 1;

            else
                high = mid - 1;
        }

        return false;
    }
}

/**
 * 1.
 *
 * i. What "n" did you choose for the problem and what is O(n)? 
 *    n = 10000 
 *    O(n) for random: O(n) = n
 *    O(n) for pre-sorted: O(n) = n
 *
 * ii. What was the time the generateArray() method took to run? 
 *    t1 = 779600 for random
 *    t1 = 98200 for pre-sorted
 *
 * iv. What was the time the constructor took to run? 
 *    t2 = 3295000 for random
 *    t2 = 820600 for pre-sorted
 *
 * v. What is t2 / t1 and how does it relate to O(n)? 
 *    t2 / t1 = 4.22 for random 
 *    t2 / t1 = 8.35 for pre-sorted
 *    This fits with O(n) as O(n) is linear
 *    which is same as the increase between t2 and t1
 *
 *
 * 2.
 *
 * i. What "n" did you choose for the problem and what is O(n)? 
 *    n = 10000
 *    O(n) = O(n^2)
 *
 * ii. What was the time the sort took to run? 
 *    t1 = 99209800
 *
 * iv. What was the time the sort took to run? 
 *    t2 = 11728709200
 *
 * v. What is t2 / t1 and how does it relate to O(n)? 
 *    t2 / t1 = 118.23 
 *    The near 100 quotient between t2 and t1
 *    demonstrates a quadratic increase (since 10^2
 *    is 100) which correlates to O(n) = n^2.
 *
 * 3.
 *
 * i. What "n" did you choose for the problem and what is O(n)? 
 *    n = 10000
 *    O(n) = O(log n)
 *
 * ii. What was the time the search took to run? 
 *    t1 = 2600
 *
 * iv. What was the time the search took to run? 
 *    t2 = 2400
 *
 * v. What is t2 / t1 and how does it relate to O(n)? 
 *    t2 / t1 = 0.92, which is consistent with O(log n)
 *    since O(log n) is faster than linear, which is 
 *    why the quotient is less than 1.
 *
 * Did the time correspond with Big-O calculations? 
 * Constructor? Yes 
 * Sorting? Yes 
 * Searching? Yes
 *
 * Clarify discrepancies:
 * Sorting was slower than expected due to the fact that
 * bubble sort is O(n^2) which is a slower process and
 * is more likely to take longer.
 */
