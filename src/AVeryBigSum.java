public class AVeryBigSum {
    static long aVeryBigSum(int n, long[] ar) {
        long returnVal = 0;
        for (int x = 0; x < ar.length; x++){
            returnVal += ar[x];
        }
        return returnVal;
    }

    public static void main (String[] args){

    }
}
