package Tester;

import SearchMethods.QuickSearch;

import java.util.Arrays;
import java.util.Random;

public class Tester {

    private int[] mainArray;

    public Tester(int countOfItems, int maxInt) {
        mainArray = genArray(countOfItems, maxInt);
    }

    public Tester(int countOfItems) {
        this(countOfItems, Integer.MAX_VALUE);
    }

    public void testSort(IRadixSortMethod f, String title) {
        int[] array = Arrays.copyOf(mainArray, mainArray.length);
        long start = System.currentTimeMillis();
        array = f.sort(array, 8);
        long finish = System.currentTimeMillis();
        System.out.printf("%d items. Time for %s = %d ms\n", array.length, title, (finish - start));
    }

    public void testSort(ISortMethodWithReturn f, String title) {
        int[] array = Arrays.copyOf(mainArray, mainArray.length);
        long start = System.currentTimeMillis();
        array = f.sort(array);
        long finish = System.currentTimeMillis();
        System.out.printf("%d items. Time for %s = %d ms\n", array.length, title, (finish - start));
    }

    public void testSort(ISortMethodWithoutReturn f, String title) {
        int[] array = Arrays.copyOf(mainArray, mainArray.length);
        long start = System.currentTimeMillis();
        f.sort(array);
        long finish = System.currentTimeMillis();
        System.out.printf("%d items. Time for %s = %d ms\n", array.length, title, (finish - start));
    }

    public void testSearch(int goal, IQuickSearch f, String title) {
        int stat = goal;
        int[] array = Arrays.copyOf(mainArray, mainArray.length);
        long start = System.currentTimeMillis();
        int result = f.quickSearch(array, 0, array.length, stat);
        long finish = System.currentTimeMillis();
        System.out.println("Время поиска искомого числа с QuickSearch =  " + (finish - start));
    }

    public int[] genArray(int countOfItems, int maxInt) {
        Random r = new Random();
        int[] result = new int[countOfItems];
        for (int i = 0; i < countOfItems; i++) {
            result[i] = r.nextInt(maxInt);
        }
        return result;
    }
}
