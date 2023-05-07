import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();            // 3
        long[] answerArr = new long[testcase];
        
        for(int i=0; i < testcase; i++) {
            int days = sc.nextInt();            // 3
            long[] stock = new long[days];
            long max = 0;
            long benefit = 0;
            
            for(int j=0; j < days; j++) {
                stock[j] = sc.nextInt();        // 10 7 6
            }
            for(int n = days - 1; n >= 0; n--) {
                if(max < stock[n]) {
                    max = stock[n];
                } else {
                    benefit += max - stock[n];
                }
            }
            answerArr[i] = benefit;
        }
        for(long answer : answerArr) {
            System.out.println(answer);
        }
    }
}