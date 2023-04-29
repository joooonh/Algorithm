import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();                   // 사람수 N명
        Integer[] plan = new Integer[N];        // 주려고 했던 팁 (내림차순 정렬하려고 Integer로 받음)
        int[] order = new int[N];
        for(int i=0; i<N; i++) {
            plan[i] = sc.nextInt();             // 주려고 했던 팁 배열 채움
            order[i] = i;                       // 순서-1 
        }
        
        Arrays.sort(plan, Collections.reverseOrder());  // 주려고 했던 팁 내림차순 정렬
        
        long tip = 0;                           // (N-1)이 100,000이고, tip의 최대값도 100,000이기 때문에 long 선언
        for(int i=0; i<N; i++) {
            int minus = plan[i] - order[i];     // 주려고 했던 팁 - 순서
            if(minus > 0) {
                tip += minus;
            }
        }
        System.out.println(tip);
    }
}
