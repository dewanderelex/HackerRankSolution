import java.util.List;

public class BonAppetit {
    static void bonAppetit(List<Integer> bill, int k, int b) {
        int sum = 0;
        for (Integer i : bill){
            sum += i;
        }
        sum -= bill.get(k);
        sum /= 2;
        if (b > sum){
            System.out.println(b - sum);
        }else{
            System.out.println("Bon Appetit");
        }
    }

    public static void main (String[] args){

    }
}
