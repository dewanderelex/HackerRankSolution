package DynamicProgramming;

import java.io.*;
import java.util.*;

public class Problemmaxsubarray {

    static int max (int i, int j){
        return i > j ? i : j;
    }

    static int subArray (int[] arr){
        int maxSoFar = arr[0];
        int currentMax = arr[0];
        for (int i = 1; i < arr.length; i++){
            currentMax = max (arr[i], currentMax + arr[i]);
            maxSoFar = max (maxSoFar, currentMax);
        }
        return maxSoFar;
    }

    static int subSequence (int[] arr){
        int maxSoFar = 0;

        maxSoFar = 0;
        boolean added = false;
        for (int i = 0; i < arr.length; i++){
            if (maxSoFar < maxSoFar + arr[i]){
                maxSoFar += arr[i];
                added = true;
            }
        }

        if (!added){
            maxSoFar = Integer.MIN_VALUE;
            for (int i = 0; i < arr.length; i++){
                maxSoFar = max (maxSoFar, arr[i]);
            }
        }

        return maxSoFar;
    }

    // Complete the maxSubarray function below.
    static int[] maxSubarray(int[] arr) {
        int[] arr1 = {subArray(arr), subSequence(arr)};
        return arr1;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] arr = new int[n];

            String[] arrItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }

            int[] result = maxSubarray(arr);

            for (int i = 0; i < result.length; i++) {
                bufferedWriter.write(String.valueOf(result[i]));

                if (i != result.length - 1) {
                    bufferedWriter.write(" ");
                }
            }

            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
