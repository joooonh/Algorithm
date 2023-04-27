import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();               // 스크린 칸
        int m = sc.nextInt();               // 바구니가 차지하는 칸
        int j = sc.nextInt();               // 떨어지는 사과 개수
        
        int move = 0;                       // 이동거리
        int left = 0;                       // 바구니 왼쪽
        int right = left + m - 1;           // 바구니 오른쪽
        
        for(int i=0; i<j; i++) {
            int apple = sc.nextInt() - 1;   // 사과 위치
            if(apple < left) {              // 사과가 바구니보다 왼쪽에 있을 때
                move += left - apple;       // 이동거리 = 바구니의 왼쪽 - 사과
                left = apple;               // 바구니 위치 이동
                right = left + m - 1;
            } else if(apple > right) {
                move += apple - right;
                right = apple;
                left = right - m + 1;
            }
        }
        System.out.println(move);
    }
}