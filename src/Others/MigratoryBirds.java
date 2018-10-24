import java.util.Collections;
import java.util.List;

public class MigratoryBirds {
    static int countNum(List<Integer> list, int num){
        int count = 0;
        for (int i = 0; i < list.size(); i++){
            if (list.get(i) == num){
                count ++;
            }
        }
        return count;
    }

    // Complete the migratoryBirds function below.
    static int migratoryBirds(List<Integer> arr) {
        Collections.sort(arr, Collections.reverseOrder());
        int maxCount = 0;
        int value = 0;
        for (int i = 0; i < arr.size(); i++){
            if (countNum(arr, arr.get(i)) >= maxCount){
                maxCount = countNum(arr, arr.get(i));
                value = arr.get(i);
            }
        }
        return value;
    }

    public static void main (String[] args){
        //test cases
    }
}
