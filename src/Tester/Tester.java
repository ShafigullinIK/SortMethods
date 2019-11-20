package Tester;

public class Tester {
    public static void testSort(int[] array, IRadixSortMethod f, String title) {
        long start = System.currentTimeMillis();
        array = f.sort(array, 8);
        long finish = System.currentTimeMillis();
        System.out.println("Time for " + title + " = " + (finish - start));
    }

    public static void testSort(int[] array, ISortMethodWithReturn f, String title) {
        long start = System.currentTimeMillis();
        array = f.sort(array);
        long finish = System.currentTimeMillis();
        System.out.println("Time for " + title + " = " + (finish - start));
    }

    public static void testSort(int[] array, ISotrMethodWithoutReturn f, String title) {
        long start = System.currentTimeMillis();
        f.sort(array);
        long finish = System.currentTimeMillis();
        System.out.println("Time for " + title + " = " + (finish - start));
    }
}
