package Greedy;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class SherlockMinimax {
    // Complete the sherlockAndMinimax function below.
    static int sherlockAndMinimax(int[] arr, int p, int q) {
        List<Integer> list = new LinkedList<>();
        for (int i : arr){
            list.add(i);
        }
        Map<Integer, Integer> min = new HashMap<>();
        while(p <= q){
            int lala = p;
            List<Integer> temp = list;
            temp = temp.stream().filter(zero -> zero != 0).collect(Collectors.toList());
            Integer s = temp
                    .stream()
                    .map(object -> Math.abs(object - lala))
                    .min(Comparator.comparing(Integer::valueOf))
                    .get();
            min.put(p, s);
            p += s;
        }
        int max = min
                .values()
                .stream()
                .max(Comparator.comparing(Integer::valueOf))
                .get();
        for (Map.Entry<Integer, Integer> entry : min.entrySet()){
            return entry.getValue() == max ? entry.getKey() : -1;
        }
        return -1;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        System.out.println(sherlockAndMinimax(new int[]{38, 50, 60, 30, 48}, 23,69));



//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int n = scanner.nextInt();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        int[] arr = new int[n];
//
//        String[] arrItems = scanner.nextLine().split(" ");
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        for (int i = 0; i < n; i++) {
//            int arrItem = Integer.parseInt(arrItems[i]);
//            arr[i] = arrItem;
//        }
//
//        String[] pq = scanner.nextLine().split(" ");
//
//        int p = Integer.parseInt(pq[0]);
//
//        int q = Integer.parseInt(pq[1]);
//
//        int result = sherlockAndMinimax(arr, p, q);
//
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();
//
//        scanner.close();
    }
}
