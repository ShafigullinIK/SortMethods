import java.util.Arrays;

public class AnotherSortMethods {

    public static void main(String[] args) {
        int[] array = {8, 2, 4, 9, 5, 7, 6, 2, 11, 7};
        array = radixSort(array, 2);
        System.out.println(Arrays.toString(array));
//        System.out.println(getRadix(123456, 10));
    }

    public static int[] countSort(int[] array) {
        int[] c = new int[12];
        int[] b = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            c[array[i]]++;
        }
        for (int i = 1; i < c.length; i++) {
            c[i] += c[i - 1];
        }
        for (int i = array.length-1; i >=0 ; i--) {
            b[c[array[i]] - 1] = array[i];
            c[array[i]]--;
        }
        return b;
    }

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
        /*int divider = (int) Math.pow(10, index);
        int temp = number / divider;
        return temp % 10;*/

        // Поскольку функция Math.pow() крайне медлительна,
        // ее лучше не использовать для возведения
        // целых чисел в целую степень.
        for (int i = 0; i < index; i++) {
            number /= 10;
        }
        return number % 10;
    }

}
