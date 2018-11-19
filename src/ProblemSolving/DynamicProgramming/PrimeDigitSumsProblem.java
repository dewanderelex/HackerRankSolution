package ProblemSolving.DynamicProgramming;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class primeDigitSumsProblem {

    /*
     * Complete the primeDigitSums function below.
     */

    static final HashMap<Integer, Boolean> prime = new HashMap<>();

    static void setPrime (){
        for (int i = 2; i < 46; i++){
            prime.put(i, true);
            for (int j = 2; j < i / 2; j++){
                if (i % j == 0){
                    prime.put(i, false);
                }
            }
        }
    }

    static int primeDigitSums(int n) {
        /*
         * Write your code here.
         */

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        setPrime();
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(scanner.nextLine().trim());

        for (int qItr = 0; qItr < q; qItr++) {
            int n = Integer.parseInt(scanner.nextLine().trim());

            int result = primeDigitSums(n);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();
    }
}
