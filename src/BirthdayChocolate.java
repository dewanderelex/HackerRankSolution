import java.util.List;

public class BirthdayChocolate {
	static int birthday(List<Integer> s, int d, int m) {
        int ways = 0;
        int sum = 0;
        //Find if there is a way to break the chocolate at all
        if(m <= s.size())
            for(int i = 0; i < m; i++)
                sum += s.get(i);
        if(sum == d) ways++;
        ///////////////////////////////////////////////////////

        //Check other possible ways to break it by using a sliding window
        for(int i = 0; i < s.size()-m; i++)
        {
            sum = sum - s.get(i) + s.get(i+m);
            if(sum == d) ways++;
        }
        return ways;
    }

    public static void main (String[] args){
	    //test cases
    }
}

