import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[] loss = new long[N];
        for(int i=0; i<N; i++) {
            loss[i] = sc.nextLong();
        }
        
        Arrays.sort(loss); 
        
        long max = 0;
        
        if(N%2 == 0) {
            for(int i=0; i<N/2; i++) {
                long sum = loss[i] + loss[N - 1 - i];
                if(max < sum)
                    max = sum;
            }
        } else {
            max = loss[N - 1];
            for(int i=0; i<N/2; i++) {
                long sum = loss[i] + loss[N - 2 - i];
                if(max < sum)
                    max = sum;
            }
        }
        System.out.println(max);
    }
}