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
        double timeMillis1 = System.currentTimeMillis();
        int[] randArr   = generateRandomArray();
        double timeMillis2 = System.currentTimeMillis();
        double timeRunning = timeMillis2 - timeMillis1;
        System.out.println("Generating random array: " + timeRunning);

        timeMillis1 = System.currentTimeMillis();
        int[] sortedArr = generateSortedArray();
        timeMillis2 = System.currentTimeMillis();
        timeRunning = timeMillis2 - timeMillis1;
        System.out.println("Generating sorted array: " +  timeRunning);

        timeMillis1 = System.currentTimeMillis();
        sortArray(randArr);
        timeMillis2 = System.currentTimeMillis();
        timeRunning = timeMillis2 - timeMillis1;
        System.out.println("Sorting random array: " + timeRunning);

        getTarget();
        timeMillis1 = System.currentTimeMillis();
        boolean inArray = binarySearch(randArr, target);
        timeMillis2 = System.currentTimeMillis();
        timeRunning = timeMillis2 - timeMillis1;
        System.out.println("Searching for target: " + timeRunning);
        System.out.println("Target in array is " + inArray);
    }

    /**
     * Generates an array with 500000 indexes with random integers in
     * each index
     * @return
     */
    public static int[] generateRandomArray() {
        Random random = new Random();
        int[]  intArr = new int[500000];

        for(int i = 0; i < 500000; i++) {
            int randInt = random.nextInt(500000);
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
        int[] intArr = new int[500000];

        for(int i = 0; i < 500000; i++) {
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
 *     i.
 *     O(n) for random: O(n) = n
 *     O(n) for pre-sorted: O(n) = n
 *     ii.
 *     t1 random =
 *     t1 pre-sorted =
 *     iv.
 *     t2 random =
 *     t2 pre-sorted =
 *     v.
 *     t2 / t1 random =
 *     t2 / t1 pre-sorted =
 *     How does this relate to O(n) for random
 *
 *     How does this relate to O(n) for pre-sorted
 *
 * 2.
 *     i.
 *     t1 =
 *     t2 =
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
 *     We found that often in practice the time it
 *     takes does not line up exactly with Big-Oh
 *     since we are finding T(n) instead of O(n).
 */
