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



class Result {

    /*
     * Complete the 'countMatches' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING_ARRAY grid1
     *  2. STRING_ARRAY grid2
     */

    static int[] getIndexUp(int[][] arr, int i, int j){
        int r = i;
        if (i != 0){
            r = i - 1;
        }
        return new int[]{r, j};
    }

    static int[] getIndexDown(int[][] arr, int i, int j){
        int r = i;
        if (i != arr.length - 1){
            r = i + 1;
        }
        return new int[]{r, j};
    }

    static int[] getIndexLeft(int[][] arr, int i, int j){
        int c = j;
        if (j != 0){
            c = j - 1;
        }
        return new int[]{i, c};
    }

    static int[] getIndexRight(int[][] arr, int i, int j){
        int c = j;
        if (j != arr[0].length - 1){
            c = j + 1;
        }
        return new int[]{i, c};
    }

    static int bfs (int[][] arr1, int[][] arr2){
        int match = 0;
        boolean[][] visited = new boolean[arr1.length][arr1[0].length];
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[0].length; j++) {
                if (bfs(arr1, arr2, i, j, visited) && visited[i][j]) {
                    match++;
                }
            }
        }
        return match;
    }

    static boolean bfs (int[][] arr1, int[][] arr2, int i, int j, boolean[][] visited){

        int[] index = {i, j};

        boolean found = false;
        boolean exact = true;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(index);
        int indexRow, indexCol;
        while (!queue.isEmpty()){
            indexRow = queue.peek()[0];
            indexCol = queue.peek()[1];
            queue.remove();
            if (!visited[indexRow][indexCol]){
                if (arr1[indexRow][indexCol] != arr2[indexRow][indexCol]){
                    exact = false;
                } else if(arr1[indexRow][indexCol] == 1 && arr2[indexRow][indexCol] == 1) {
                    visited[indexRow][indexCol] = true;
                    found = true;
                    //add adjacent
                    queue.add(getIndexUp(arr1, indexRow, indexCol));
                    queue.add(getIndexDown(arr1, indexRow, indexCol));
                    queue.add(getIndexLeft(arr1, indexRow, indexCol));
                    queue.add(getIndexRight(arr1, indexRow, indexCol));
                }
            }
        }
        return found && exact;

    }

    public static int countMatches(List<String> grid1, List<String> grid2) {
        // Write your code here

        int[][] arr1 = new int[grid1.size()][grid1.get(0).length()];
        int[][] arr2 = new int[grid2.size()][grid2.get(0).length()];

        for(int i = 0; i < grid1.size(); i++){
            String[] c = grid1.get(i).split("");
            for (int j = 0; j < c.length; j++){
                arr1[i][j] = Integer.parseInt(c[j]);
            }
        }

        for (int i = 0; i < grid2.size(); i++) {
            String[] c = grid2.get(i).split("");
            for (int j = 0; j < c.length; j++) {
                arr2[i][j] = Integer.parseInt(c[j]);
            }
        }
        return bfs(arr1, arr2);
    }
}

public class Problem1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int grid1Count = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> grid1 = IntStream.range(0, grid1Count).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .collect(toList());

        int grid2Count = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> grid2 = IntStream.range(0, grid2Count).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .collect(toList());

        int result = Result.countMatches(grid1, grid2);
        System.out.println(result);

        bufferedReader.close();
    }
}
