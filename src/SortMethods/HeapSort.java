package SortMethods;

public class HeapSort {

    public static void heapSort(int[] array) {
        int heapSize = array.length;
        createHeap(array, heapSize);
        while (heapSize > 0) {
            Util.swap(array, 0, heapSize - 1);
            heapSize--;
            maxHeapify(0, array, heapSize);
        }
    }
    // метод, вспомогательный для пирамидальной сортировки
    public static void createHeap(int[] arr, int heapsize) {
        for (int i = heapsize / 2; i >= 0; i--) {
            maxHeapify(i, arr, heapsize);
        }
    }

    //метод, вспомогательный для пирамидальной сортировки
    public static void maxHeapify(int index,
                                  int[] arr,
                                  int heapSize) {
        int l = left(index);
        int r = right(index);
        int large = index;
        if (l < heapSize &&
                arr[index] < arr[l]) {
            large = l;
        }
        if (r < heapSize &&
                arr[large] < arr[r]) {
            large = r;
        }
        if (index != large) {
            Util.swap(arr, index, large);
            maxHeapify(large, arr, heapSize);
        }
    }

    private static int left(int i) {
        return 2 * i + 1;
    }

    private static int right(int i) {
        return 2 * (i + 1);
    }
}
