import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] P = new int[N];
        for(int i=0; i<N; i++) {
            P[i] = sc.nextInt();
        }
        
        Arrays.sort(P);
        
        int sum = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<=i; j++) {
                sum += P[j];
            }
        }
        System.out.println(sum);
    }
}