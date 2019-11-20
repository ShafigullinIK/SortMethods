import java.util.Arrays;
import java.util.Random;

import AnotherSortMethods.*;
import SearchMethods.QuickSearch;
import SortMethods.*;
import Tester.*;

public class Main {

    public static void main(String[] args) {
        checkSortMethods(25_000_000);
    }

    public static void checkSortMethods(int n) {
        int[] array = genArray(n);
        int[] array2 = Arrays.copyOf(array, array.length);
        int[] array3 = Arrays.copyOf(array, array.length);
        int[] array4 = Arrays.copyOf(array, array.length);
        int[] array5 = Arrays.copyOf(array, array.length);
        int stat = 159834;

        //Передача функции в качестве параметра
        Tester.testSort(array2, RadixSort::radixSort, "RadixSort");
        Tester.testSort(array, MergeSort::mergeSort, "MergeSort");
        Tester.testSort(array3, HeapSort::heapSort, "HeapSort");
        Tester.testSort(array4, QuickSort::sort, "QuickSort");

        System.out.println(array3[stat]);
        long start = System.currentTimeMillis();
        int result = QuickSearch.quickSearch(array4,
                0, array5.length,
                stat);
        long finish = System.currentTimeMillis();
        System.out.println("Время поиска искомого числа с QuickSearch =  " + (finish - start));
        System.out.println(result);

    }


    public static int[] genArray(int n) {
        Random r = new Random();
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = r.nextInt(10_000_000);
        }
        return result;
    }

}
