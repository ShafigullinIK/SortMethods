package SortMethods;

public class BubbleSort {
    public static int[] sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    Util.swap(array, i, j);
                }
            }
        }
        return array;
    }
}
