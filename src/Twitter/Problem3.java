package Twitter;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result1 {

    /*
     * Complete the 'missingWords' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. STRING t
     */

    public static List<String> missingWords(String s, String t) {
        List<String> result = new LinkedList<>();
        String[] string = s.split(" ");
        String[] subsequence = t.split(" ");

        Queue<String> queue = new LinkedList<>();
        for (String str : subsequence){
            queue.add(str);
        }

        for (int i = 0; i < string.length; i++){
            if (!queue.isEmpty()) {
                if (!queue.peek().equals(string[i])) {
                    result.add(string[i]);
                } else {
                    queue.remove();
                }
            } else if (i < string.length) {
                result.add(string[i]);
            }
        }

        return result;
    }

}

public class Problem3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String t = bufferedReader.readLine();

        List<String> result = Result1.missingWords(s, t);

        bufferedWriter.write(
                result.stream()
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
