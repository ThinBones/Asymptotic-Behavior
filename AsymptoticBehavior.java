import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class AsymptoticBehavior {
    private static int target;
    double currentTimeMillis = System.currentTimeMillis();

    public static void main(String[] a) throws FileNotFoundException {
        int[] randArr   = generateRandomArray();
        int[] sortedArr = generateSortedArray();

//        for(int i = 0; i < 100001; i++) {
//            System.out.println(sortedArr[i]);
//        }
    }

    public static int[] generateRandomArray() {
        Random random = new Random();
        int[]  intArr = new int[100000];

        for(int i = 0; i < 100000; i++) {
            int randInt = random.nextInt(10000);
            intArr[i] = randInt;
        }

        return intArr;
    }

    public static int[] generateSortedArray() {
        int[] intArr = new int[100000];

        for(int i = 0; i < 100000; i++) {
            intArr[i] = i;
        }

        return intArr;
    }

    public static void sortArray(int[] arr) {
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
    }

    public static void getTarget() throws FileNotFoundException {
        FileReader reader;
        String fileInputName = "data.txt";
        Scanner scan = null;

        scan = new Scanner(new BufferedReader(new FileReader(fileInputName)));
        int int1 = scan.nextInt();

        target = int1;
    }

    public static boolean binarySearch(int[] arr) {
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

        // If we reach here, then element was
        // not present
        return false;
    }
}
