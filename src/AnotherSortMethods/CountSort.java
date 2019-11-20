package AnotherSortMethods;

public class CountSort {

    public static int[] countSort(int[] array) {
        int[] c = new int[12];
        int[] b = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            c[array[i]]++;
        }
        for (int i = 1; i < c.length; i++) {
            c[i] += c[i - 1];
        }
        for (int i = array.length-1; i >=0 ; i--) {
            b[c[array[i]] - 1] = array[i];
            c[array[i]]--;
        }
        return b;
    }
}
