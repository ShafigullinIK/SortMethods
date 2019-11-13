public class Tester {
	static void testSort(int[] array, Function f, String title) {
		long start = System.currentTimeMillis();
		array = f.sort(array, 1);
		long finish = System.currentTimeMillis();
		System.out.println("Time for " + title + " = " + (finish - start));
	}
}
