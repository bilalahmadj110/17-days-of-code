import java.util.Arrays;
import java.util.HashSet;

public class ArraysFunc {

    // Reverse the array
    public Object[] reverseArray(Object[] array) {
        Object[] reversed = new Object[array.length];
        for (int index = array.length - 1; index > -1; index--) {
            reversed[array.length - index - 1] = array[index];
        }
        return reversed;
    }

    // Find the maximum and minimum element in an array
    public int[] maxMin(int array[]) {
        int min = array[0];
        int max = array[0];
        for (int item: array) {
            if (item < min) {
                min = item;
            }
            if (item > max) {
                max = item;
            }
        }
        return new int[]{max, min};
    }

    // Given an array which consists of only 0, 1 and 2. Sort the array without using any sorting algo
    public int[] sort012(int[] array) {
        int zeros = 0;
        int ones = 0;
        int twos = 0;
        for (int item: array) {
            if (item == 0)
                zeros++;
            else if (item == 1)
                ones++;
            else
                twos++;
        }
        int[] sorted = new int[array.length];
        int i, j, k;
        for (i = 0; i < zeros; i++)
            sorted[i] = 0;
        for (j = i; j < ones + i; j++)
            sorted[j] = 1;
        for (k = j; k < twos + j; k++)
            sorted[k] = 2;
        return sorted;
    }

    public int[] kMaxMin(int array[], int k) {
        // TODO: upon sorting algorithm completion
        return null;
    }

    // Move all the negative elements to one side of the array 
    public int[] moveNegativeElem(int array[]) {
        int[] negArray = new int[array.length];
        int pos = 0;
        int neg = array.length - 1;
        for (int item: array) {
            if (item > -1)
                negArray[pos++] = item;
            else
                negArray[neg--] = item;
        }
        return negArray;
    }

    // find the union of two array
    public int[] union(int array1[], int array2[]) {
        HashSet<Integer> union = new HashSet<>();
        for (int item: array1) {
            union.add(item);
        }
        for (int item: array2) {
            union.add(item);
        }
        return union.toArray();
    }

    // Given an array, rotate the array by one position in clock-wise direction.
    public int[] rotate(int arr[]) {
        int x=arr[n-1];
        int i=0;
        for(i = n-2;i >= 0;i--){
            arr[i+1]=arr[i];
        }
        arr[0]=x;
    }

    // Kadane's Algorithm 
    long maxSubarraySum(int arr[], int n){
        long maxSum = arr[0];
        for (int i = 0; i < arr.length; i++) {
            int sum = arr[i];
            if (sum > maxSum) {
                maxSum = sum;
            }
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
        }
        return maxSum;
        
    }

    

    // Minimum number of jumps 
    public int minJumps(int[] arr, int n) {
        int steps = 0;
        int i = 0;
        while (i < n) {
            if (arr[i] == 0) {
                steps = 0;
                break;
            }
            i += arr[i];
            steps++;
        }
        return steps == 0 ? -1 : steps;
    }

    // find duplicate in an array of N+1 Integers
    public int findDuplicate(int[] nums) {
        Set<Integer> hash_Set = new HashSet<Integer>();
 
        for (int item: nums) {
            int oldSize = hash_Set.size();
            hash_Set.add(item);
            if (oldSize == hash_Set.size())
                return item;
        }
        return 0;
    }

    // 1 Merge 2 sorted arrays without using Extra space.
    public void merge(int arr1[], int arr2[], int n, int m) {
        int i = n - 1;
        int j = 0;
        while (i >= 0 && j < m){
            if (arr1[i] > arr2[j]) {
                int temp = arr1[i];
                arr1[i] = arr2[j];
                arr2[j] = temp;   
            }
            i--;
            j++;
        } 
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }

    // Merge Intervals
    public int[][] merge(int[][] intervals) {
        // https://leetcode.com/subscribe?ref=nb_npl
        intervals = sort(intervals);
        //int[][] overlap = new int[intervals.length][2];
        List<int[]> overlap = new ArrayList<>();
        int[] tempOverlap = new int[2];
        for (int i = 0; i < intervals.length; i++) {
            if (i == 0) {
                tempOverlap[1] = intervals[i][1];
                tempOverlap[0] = intervals[i][0];
                continue;
            }
            
            if (tempOverlap[1] >= intervals[i][0] && tempOverlap[0] <= intervals[i][1]) {
                int min1 = Math.min(tempOverlap[1], tempOverlap[0]);
                int min2 = Math.min(intervals[i][1], intervals[i][0]);
                int min = Math.min(min1, min2);
                
                int max1 = Math.max(tempOverlap[1], tempOverlap[0]);
                int max2 = Math.max(intervals[i][1], intervals[i][0]);
                int max = Math.max(max1, max2);
                tempOverlap[1] = max;
                tempOverlap[0] = min;
                
            } else {
                overlap.add(new int[] {tempOverlap[0], tempOverlap[1]});               
                // setting temp array to the current index int values
                tempOverlap[1] = intervals[i][1];
                tempOverlap[0] = intervals[i][0];
            }
            
        }
        overlap.add(new int[] {tempOverlap[0], tempOverlap[1]});
        int[][] overlap_ = new int[overlap.size()][2];
        for (int i = 0; i < overlap.size(); i++) {
            overlap_[i] = overlap.get(i);
        }
        // filtering the required data from overlap array
        return overlap_;
    }

    public static void main(String[] args) {
        ArraysFunc maxMin = new ArraysFunc();
        // 1.
        // Object[] array = new Object[5];
        // array[0] = "a";
        // array[1] = "b";
        // array[2] = "c";
        // array[3] = "d";
        // array[4] = "e";
        // Object[] reversed = maxMin.reverseArray(array);
        // for (int index = 0; index < reversed.length; index++) {
        //     System.out.println(reversed[index]);
        // }

        // 2.
        // test maxMin
        // int[] array = new int[]{1, 34, 54, 6, 23, 54, 7, 34, 34, 5, 35};
        // int[] maxMinResult = maxMin.maxMin(array);
        // System.out.println(maxMinResult[0]);
        // System.out.println(maxMinResult[1]);

        // 3.
        // test sort012
        // int[] array = new int[]{1, 0, 1, 2, 0, 1, 1, 2, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0};
        // int[] sorted = maxMin.sort012(array);
        // System.out.println(Arrays.toString(sorted));

        // 4.
        // test moveNegativeElem
        // int[] array = new int[]{1, 0, -1, 2, 0, -1, -1, 2, 0, 1, 1, 12, 324, -435, 54, 6 ,-6, 34, -435};
        // int[] sorted = maxMin.moveNegativeElem(array);
        // System.out.println(Arrays.toString(sorted));

        // 1 3 5 7
        // 0 2 6 8 9

        //2 6 7 8 9 9 10 10 11 12 12 12 12 13 13 13 14 15 16 16 17 18 18 19 20
        int[] arr1 = new int[] {2, 6, 7, 8, 9, 9, 10, 10, 11, 12, 12, 12, 13, 13, 13, 14, 15, 16, 16, 17, 18, 18, 19, 20};
        // 1 5 5 7 7 8 9 11 15 18 18 18 20 20
        int[] arr2 = new int[] {1, 5, 5, 7, 7, 8, 9, 11, 15, 18, 18, 18, 20, 20};
        maxMin.merger(arr1, arr2);
    }
}