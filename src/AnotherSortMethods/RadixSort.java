package AnotherSortMethods;

public class RadixSort {
    public static int[] radixSort(int[] array, int d){
        int[] b = new int[array.length];
        for (int j = 0; j < d; j++) {
            int[] c = new int[10];
            b = new int[array.length];
            for (int i = 0; i < array.length; i++) {
                c[getRadix(array[i], j)]++;
            }
            for (int i = 1; i < c.length; i++) {
                c[i] += c[i - 1];
            }
            for (int i = array.length-1; i >=0 ; i--) {
                b[c[getRadix(array[i],j)] - 1] = array[i];
                c[getRadix(array[i],j)]--;
            }
            array = b;
        }
        return b;
    }

    public static int getRadix(int number, int index){
        for (int i = 0; i < index; i++) {
            number /= 10;
        }
        return number % 10;
    }
}
