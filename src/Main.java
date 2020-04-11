import AnotherSortMethods.*;
import SearchMethods.QuickSearch;
import SortMethods.*;
import Tester.*;

public class Main {

    public static void main(String[] args) {
        bigOExamples(BubbleSort::sort, "BubbleSort", 200_000);
        bigOExamples(HeapSort::heapSort, "HeapSort", 40_000_000);
    }

    public static void bigOExamples(ISortMethodWithoutReturn f, String methodName, int countOfItems) {
        Tester tester = new Tester(countOfItems);
        tester.testSort(f, methodName);
        tester = new Tester(countOfItems / 2);
        tester.testSort(f, methodName);
        tester = new Tester(countOfItems / 10);
        tester.testSort(f, methodName);

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
