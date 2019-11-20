package SortMethods;

import java.util.Random;

public class QuickSort {

    public static void sort(int[] array){
        quickSort(array, 0, array.length);
    }

    public static void quickSort(int[] array, int left, int right) {
        if (left < right) {
            int p = partition(array, left, right);
            quickSort(array, left, p);
            quickSort(array, p + 1, right);
        }
    }
    //метод, вспомогательный для быстрой сортировки
    public static int partition(int[] array, int p, int q) {
        Random r = new Random();
        int t = r.nextInt(q - p) + p;
        Util.swap(array, q - 1, t);
        int x = array[q - 1];
        int j = p - 1;
        for (int i = p; i < q - 1; i++) {
            if (array[i] < x) {
                j++;
                Util.swap(array, i, j);
            }
        }
        Util.swap(array, j + 1, q - 1);
        return j + 1;
    }
}
