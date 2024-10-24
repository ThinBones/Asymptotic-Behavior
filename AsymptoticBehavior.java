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
        double currentTimeMillis = System.currentTimeMillis();
        localTimeMillis = System.currentTimeMillis();

        int[] randArr   = generateRandomArray();
        System.out.println("Generating random array: " + localTimeMillis);

        int[] sortedArr = generateSortedArray();
        System.out.println("Generating sorted array: " + localTimeMillis);

        sortArray(randArr);
        System.out.println("Sorting random array: " + localTimeMillis);

        getTarget();
        binarySearch(randArr, target);
        System.out.println("Searching for target: " + localTimeMillis);

        double newTimeMillis = System.currentTimeMillis();
        localTimeMillis = newTimeMillis - currentTimeMillis;

        System.out.println("Main method: " + localTimeMillis);
    }

    /**
     * Generates an array with 100000 indexes with random integers in
     * each index
     * @return
     */
    public static int[] generateRandomArray() {
        double currentTimeMillis = System.currentTimeMillis();
        Random random = new Random();
        int[]  intArr = new int[5000000];

        for(int i = 0; i < 5000000; i++) {
            int randInt = random.nextInt(10000);
            intArr[i] = randInt;
        }

        double newTimeMillis = System.currentTimeMillis();
        localTimeMillis = newTimeMillis - currentTimeMillis;
        return intArr;
    }

    /**
     * Generates an array with 1000000 indexes with increasing integers
     * in each index
     * @return
     */
    public static int[] generateSortedArray() {
        double currentTimeMillis = System.currentTimeMillis();
        int[] intArr = new int[5000000];

        for(int i = 0; i < 5000000; i++) {
            intArr[i] = i;
        }

        double newTimeMillis = System.currentTimeMillis();
        localTimeMillis = newTimeMillis - currentTimeMillis;
        return intArr;
    }

    /**
     * Sorts an array via bubble sort
     * @param arr
     */
    public static void sortArray(int[] arr) {
        double currentTimeMillis = System.currentTimeMillis();
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
        double newTimeMillis = System.currentTimeMillis();
        localTimeMillis = newTimeMillis - currentTimeMillis;
    }

    /**
     * Finds a target integer from a text file
     * @throws FileNotFoundException
     */
    public static void getTarget() throws FileNotFoundException {
        double currentTimeMillis = System.currentTimeMillis();
        FileReader reader;
        String fileInputName = "data.txt";
        Scanner scan = null;

        scan = new Scanner(new BufferedReader(new FileReader(fileInputName)));
        int int1 = scan.nextInt();

        double newTimeMillis = System.currentTimeMillis();
        localTimeMillis = newTimeMillis - currentTimeMillis;
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

        double newTimeMillis = System.currentTimeMillis();
        localTimeMillis -= newTimeMillis;
        return false;
    }
}

/**
 * 1.
 *     i.
 *     O(n) for random: O(n) = n
 *     O(n) for pre-sorted: O(n) = n
 *     ii.
 *     t1 random = 14.0ms
 *     t1 pre-sorted = 4.0ms
 *     iv.
 *     t2 random = 53.0ms
 *     t2 pre-sorted = 10.0ms
 *     v.
 *     t2 / t1 random =
 *     t2 / t1 pre-sorted =
 *     How does this relate to O(n) for random
 *
 *     How does this relate to O(n) for pre-sorted
 *
 * 2.
 *     i.
 *     t1 = 1172504.0ms
 *     t2 = 3.0107E7ms
 *     t2 / t1 =
 *     
 * 3.
 *     n is the same as the array being searched (100000)
 *     t1 = 10.0ms
 *     t2 = 43.0ms
 *     t2 / t1 =
 * 4.
 *     Main Method:
 *     Generate Random Array:
 *     Generate Sorted Array:
 *     Sort Random Array:
 *     Search Array:
 * 5.
 *     The main discrepency is that simulations
 *     find T(n) as opposed to O(n) which shows
 *     the real time of the simulation as opposed
 *     to the worst-case-scenario.
 */
