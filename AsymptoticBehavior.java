import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class AsymptoticBehavior {
    private static int target;
    private static double localTimeMillis;


    public static void main(String[] a) throws FileNotFoundException {
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
    }

    /**
     * Creates an array with 100000 indexes with random integers in
     * each index
     * @return
     */
    public static int[] generateRandomArray() {
        double currentTimeMillis = System.currentTimeMillis();
        Random random = new Random();
        int[]  intArr = new int[100000];

        for(int i = 0; i < 100000; i++) {
            int randInt = random.nextInt(10000);
            intArr[i] = randInt;
        }

        double newTimeMillis = System.currentTimeMillis();
        localTimeMillis = newTimeMillis - currentTimeMillis;
        return intArr;
    }

    /**
     * Generatese an array with 100000 indexes with increasing integers
     * in each index
     * @return
     */
    public static int[] generateSortedArray() {
        double currentTimeMillis = System.currentTimeMillis();
        int[] intArr = new int[100000];

        for(int i = 0; i < 100000; i++) {
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
                    //swap elements
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

            // Check if x is present at mid
            if (arr[mid] == target)
                return true;

            // If x greater, ignore left half
            if (arr[mid] < target)
                low = mid + 1;

            // If x is smaller, ignore right half
            else
                high = mid - 1;
        }

        double newTimeMillis = System.currentTimeMillis();
        localTimeMillis -= newTimeMillis;
        return false;
    }
}
