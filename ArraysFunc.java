public class ArraysFunc {

    public Object[] reverseArray(Object[] array) {
        Object[] reversed = new Object[array.length];
        for (int index = array.length - 1; index > -1; index--) {
            reversed[array.length - index - 1] = array[index];
        }
        return reversed;
    }

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
    }
}