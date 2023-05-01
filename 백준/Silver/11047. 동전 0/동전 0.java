import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in); 
        int N = sc.nextInt();
        int K = sc.nextInt();
        Integer[] A = new Integer[N];
        for(int i=0; i<N; i++) {
            A[i] = sc.nextInt();
        }
        
        Arrays.sort(A, Collections.reverseOrder());
        
        int cnt = 0;
        for(int i=0; i<N; i++) {
            cnt += K/A[i];
            K %= A[i];
        }
        System.out.println(cnt);
    }
}