public class Memo {

    public static void main(String[] args) {
        int n = 100;
        long[] fibArray = new long[n+1];

        System.out.println(fibRecWithArray(100, fibArray));
    }

    public static long fibRec(int n){
        if(n <= 1){
            return n;
        }
        return fibRec(n-1) + fibRec(n-2);
    }

    public static long fibRecWithArray(int n, long[] fibArray){
        if(fibArray[n] != 0){
            return fibArray[n];
        }
        if(n<=1){
            return n;
        }
        fibArray[n] = fibRecWithArray(n-1, fibArray) + fibRecWithArray(n-2, fibArray);
        return fibArray[n];
    }

}
