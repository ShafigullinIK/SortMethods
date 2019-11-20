package SortMethods;

public class InsertSort {

    public static int[] sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int value = array[i];
            int prev = i - 1;
            while (prev >= 0 && value < array[prev]) {
                array[prev + 1] = array[prev];
                prev--;
            }
            array[prev + 1] = value;
        }
        return array;
    }
}
