public class ArraysFunc {

    public Object[] reverseArray(Object[] array) {
        Object[] reversed = new Object[array.length];
        for (int index = array.length - 1; index > -1; index--) {
            reversed[array.length - index - 1] = array[index];
        }
        return reversed;
    }

    public static void main(String[] args) {
        Object[] array = new Object[5];
        array[0] = "a";
        array[1] = "b";
        array[2] = "c";
        array[3] = "d";
        array[4] = "e";
        array_1 reverse = new array_1();
        Object[] reversed = reverse.reverseArray(array);
        for (int index = 0; index < reversed.length; index++) {
            System.out.println(reversed[index]);
        }
    }
}