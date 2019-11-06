import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        checkSortMethods(50_000_000);
//        int[] array = genArray(100);
//        array = AnotherSortMethods.radixSort(array, 9);
//        System.out.println(Arrays.toString(array));
    }

    public static void checkSortMethods(int n) {
        int[] array = genArray(n);
        int[] array2 = Arrays.copyOf(array, array.length);
        int[] array3 = Arrays.copyOf(array, array.length);
        int[] arrayR = Arrays.copyOf(array, array.length);
//        int[] array4 = new int[n];
//        for (int i = 0; i < n; i++) {
//            array4[i] = n - i;
//        }
//        int[] array5 = Arrays.copyOf(array4, array4.length);
//        int[] array6 = Arrays.copyOf(array4, array4.length);

        testHeapSort(array);
        testMergeSort(array2);
        testQuickSort(array3);
        testRadixSort(arrayR);

    }

    public static void testHeapSort(int[] array) {
        long start = System.currentTimeMillis();
        heapSort(array);
        long finish = System.currentTimeMillis();
        System.out.println("heapSort = " + (finish - start));
    }

    public static void testMergeSort(int[] array) {
        long start = System.currentTimeMillis();
        mergeSort(array);
        long finish = System.currentTimeMillis();
        System.out.println("mergeSort = " + (finish - start));
    }

    public static void testQuickSort(int[] array) {
        long start = System.currentTimeMillis();
        quickSort(array, 0, array.length);
        long finish = System.currentTimeMillis();
        System.out.println("quikSort = " + (finish - start));
    }

    public static void testRadixSort(int[] array) {
        long start = System.currentTimeMillis();
        array = AnotherSortMethods.radixSort(array, 1);
        long finish = System.currentTimeMillis();
        System.out.println("radixSort = " + (finish - start));
    }

    public static int[] genArray(int n) {
        Random r = new Random();
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = r.nextInt(10);
        }
        return result;
    }


    // Сортировка Пузырьком.
    public static int[] bubbleSort(int[] array) { //n = array.length
        for (int i = 0; i < array.length - 1; i++) {       // c1 n-1
            for (int j = i + 1; j < array.length; j++) {   // c2 (n-i-1)(n-1)
                if (array[i] > array[j]) {                   // c3 (n-i-1)(n-1)
                    int c = array[i];                      // c4 0<=ti<=(n-i-1)(n-1)
                    array[i] = array[j];                   // c5 0<=ti<=(n-i-1)(n-1)
                    array[j] = c;                          // c6 0<=ti<=(n-i-1)(n-1)
                }
            }                                       //  A n^2 + B n + C
        }
        return array;
    }


    //Сортировка выбором
    public static int[] choiseSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {     //c1 n-1
            int minIdex = i;                           //c2 n-1
            for (int j = i + 1; j < array.length; j++) { //c3 (n-1)(n-i-1)
                if (array[j] < array[minIdex]) {         //c4 (n-1)(n-i-1)
                    minIdex = j;                       //c5 0<=Ti<=(n-1)(n-i-1)
                }
            }
            if (i != minIdex) {                            //c6  n-1
                int temp = array[i];                   //c7  0<=Ti<=(n-1)
                array[i] = array[minIdex];             //c8  0<=Ti<=(n-1)
                array[minIdex] = temp;                 //c9  0<=Ti<=(n-1)
            }
        }                                          //  A n^2 + B n + C
        return array;
    }


    // Сортировка вставками
    public static int[] insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {            //c1 n-1
//            int j = i;
//            while(j>0 && array[j-1] > array[j]){
//                int temp = array[j-1];
//                array[j-1] = array[j];
//                array[j] = temp;
//                j--;
//            }
            // ____________//
            int value = array[i];                          //c2 n-1
            int prev = i - 1;                                //c3 n-1
            while (prev >= 0 && value < array[prev]) {         //c4 n-1
                array[prev + 1] = array[prev];               //c5 (n-1)T, где 0<=T<=i
                prev--;                                    //c6 (n-1)T, где 0<=T<=i
            }
            array[prev + 1] = value;                         //c7 (n-1)
        }                                         //  A n^2 + B n + C
        return array;
    }


    // Сортировка слиянием
    public static int[] mergeSort(int[] array) {
        if (array.length == 1) {                    // c1  2n-1
            return array;
        }
        int middleIndex = array.length / 2;         // c2 n-1
        int[] left = new int[middleIndex];          // c3 n-1
        int[] right = new int[array.length - middleIndex]; // c4 n-1
        for (int i = 0; i < array.length; i++) {    // c5 (n-1)n
            if (i < middleIndex) {                  // c6
                left[i] = array[i];                 //
            } else {
                right[i - middleIndex] = array[i];  //
            }
        }
        left = mergeSort(left);                     //
        right = mergeSort(right);                   //
        return merge(left, right);                  //

    }
    // вспомогательный методя для сортировки слиянием
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


    // вспомогательные методы для пирамидальной сортировки
    private static int left(int i) {
        return 2 * i + 1;
    }

    private static int right(int i) {
        return 2 * (i + 1);
    }
    //метод для обмена местами двух объектов в массиве, используется в разных сортировках
    private static void swap(int[] arr, int i1,
                             int i2) {
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }
    // Пирамидальная сортировка
    public static void heapSort(int[] array) {
        int heapSize = array.length;
        createHeap(array, heapSize);
        while (heapSize > 0) {
            swap(array, 0, heapSize - 1);
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
            swap(arr, index, large);
            maxHeapify(large, arr, heapSize);
        }
    }


    //Быстрая сортировка
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
        swap(array, q - 1, t);
        int x = array[q - 1];
        int j = p - 1;
        for (int i = p; i < q - 1; i++) {
            if (array[i] < x) {
                j++;
                swap(array, i, j);
            }
        }
        swap(array, j + 1, q - 1);
        return j + 1;
    }
}
