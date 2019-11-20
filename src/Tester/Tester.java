package Tester;

import SearchMethods.QuickSearch;

import java.util.Arrays;
import java.util.Random;

public class Tester {

    private int[] mainArray;

    public Tester(int countOfObject, int maxInt){
        mainArray = genArray(countOfObject, maxInt);
    }

    public void testSort(IRadixSortMethod f, String title) {
        int[] array = Arrays.copyOf(mainArray, mainArray.length);
        long start = System.currentTimeMillis();
        array = f.sort(array, 8);
        long finish = System.currentTimeMillis();
        System.out.println("Time for " + title + " = " + (finish - start));
    }

    public void testSort(ISortMethodWithReturn f, String title) {
        int[] array = Arrays.copyOf(mainArray, mainArray.length);
        long start = System.currentTimeMillis();
        array = f.sort(array);
        long finish = System.currentTimeMillis();
        System.out.println("Time for " + title + " = " + (finish - start));
    }

    public void testSort(ISortMethodWithoutReturn f, String title) {
        int[] array = Arrays.copyOf(mainArray, mainArray.length);
        long start = System.currentTimeMillis();
        f.sort(array);
        long finish = System.currentTimeMillis();
        System.out.println("Time for " + title + " = " + (finish - start));
    }

    public void testSearch(int goal, IQuickSearch f, String title){
        int stat = goal;
        int[] array = Arrays.copyOf(mainArray, mainArray.length);
        long start = System.currentTimeMillis();
        int result = f.quickSearch(array, 0, array.length, stat);
        long finish = System.currentTimeMillis();
        System.out.println("Время поиска искомого числа с QuickSearch =  " + (finish - start));
    }

    public int[] genArray(int countOfObjects, int maxInt) {
        Random r = new Random();
        int[] result = new int[countOfObjects];
        for (int i = 0; i < countOfObjects; i++) {
            result[i] = r.nextInt(maxInt);
        }
        return result;
    }
}
