import java.util.Arrays;
import java.util.Random;

import AnotherSortMethods.*;
import SearchMethods.QuickSearch;
import SortMethods.*;
import Tester.*;

public class Main {

    public static void main(String[] args) {
        Tester tester = new Tester(25_000_000, 99_000_000);
        checkSortMethods(tester);
    }

    public static void checkSortMethods(Tester tester) {

        int stat = 159834;

        //Передача функции в качестве параметра
        tester.testSort(RadixSort::radixSort, "RadixSort");
        tester.testSort(MergeSort::mergeSort, "MergeSort");
        tester.testSort(HeapSort::heapSort, "HeapSort");
        tester.testSort(QuickSort::sort, "QuickSort");
        tester.testSearch(stat, QuickSearch::quickSearch, "Время поиска искомого числа с QuickSearch");
    }




}
