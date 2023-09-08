package search;

/**
 * Write a description of class Binary here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Binary
{

    /**
     * Returns the index of the target value, or -1 if not found
     */
    public static int search(int[] arr, int target) {
        // Your algorithm goes here!
        // Note... I know that the standard Java Arrays class has a method called
        // binarySearch.  If you use it for testing, but you need to implement the algorithm
        // to get the point!
        boolean foundTarget = false;
        int left = 0;
        int right = arr.length;
        int middle = arr.length/2;
        while (!foundTarget) {
            if (arr[middle] == target) {
                return middle;
            } else if (arr[middle] > target) {
                right = middle;
                middle = right/2;
            } else if (arr[middle] < target) {
                left = middle;
                middle = (left+right)/2;
            } 
            if (left == right) {
                return -1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {53,85,93,25,39,27,42,5,24,45,33,51,5,80,4,7,91,
                31,66,71,32,19,79,58,61,82,89,63,7,4,50,10,48,24,75,19,22,
                73,54,51,25,33,20,52,79,97,70,54,63,49};

        // Remember that a binary search requires a sorted array!
        // You can use one of your sorting methods here.
        for (int i = 1; i < arr.length; i++) {
            boolean isLess = true;
            int a = i;
            while(isLess) {
                if (a == 0 || arr[a] >= arr[a-1]) {
                    isLess = false;
                } else {
                    int arrNumber = arr[a-1];
                    arr[a-1] = arr[a];
                    arr[a] = arrNumber;

                    a--;    
                }
            }
        }

        ////////////////////////////////////////////////////////////
        // Do not change anything below this line!!
        ////////////////////////////////////////////////////////////
        boolean isSorted = true;
        for (int i=0; i<arr.length-1 && isSorted; i++) {
            if (arr[i] > arr[i+1]) {
                isSorted = false;
            }
        }
        printResult("Is sorted?", isSorted);
        printResult(82, search(arr, 82) == 44); // Find index in unsorted or sorted array
        printResult(49, search(arr, 49) == 24);
        printResult(-4, search(arr, -4) == -1);
    }

    public static void printResult(int target, boolean result) {
        System.out.println("Search for "+target+": "+((result) ? "CORRECT" : "INCORRECT"));
    }

    public static void printResult(String target, boolean result) {
        System.out.println(target+": "+((result) ? "CORRECT" : "INCORRECT"));
    }

}
