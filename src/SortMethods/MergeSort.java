package SortMethods;

public class MergeSort {

    public static int[] mergeSort(int[] array) {
        if (array.length == 1) {
            return array;
        }
        int middleIndex = array.length / 2;
        int[] left = new int[middleIndex];
        int[] right = new int[array.length - middleIndex];
        for (int i = 0; i < array.length; i++) {
            if (i < middleIndex) {
                left[i] = array[i];
            } else {
                right[i - middleIndex] = array[i];
            }
        }
        left = mergeSort(left);
        right = mergeSort(right);
        return merge(left, right);

    }
    // вспомогательный метод для сортировки слиянием
    public static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int lIndex = 0;
        int rIndex = 0;
        int index = 0;
        while (lIndex < left.length && rIndex < right.length) {
            if (left[lIndex] <= right[rIndex]) {
                result[index] = left[lIndex];
                index++;
                lIndex++;
            } else {
                result[index] = right[rIndex];
                index++;
                rIndex++;
            }
        }
        for (int i = lIndex; i < left.length; i++) {
            result[index] = left[i];
            index++;
        }
        for (int i = rIndex; i < right.length; i++) {
            result[index] = right[i];
            index++;
        }
        return result;
    }
}
