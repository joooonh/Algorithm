import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); 
        int[] honeys = new int[N];      // 꿀의 양
        long[] toRightTotal = new long[N];  // 0~오른쪽으로 누적합
        long[] toLeftTotal = new long[N];   // 끝~왼쪽으로 누적합
        long temp = 0;
        long max = 0;
        
        for(int i=0; i<N; i++) {
            honeys[i] = sc.nextInt();
            
            temp += honeys[i];
            toRightTotal[i] = temp;        // 누적합 채우기
        }
        temp = 0; 
        for(int i=N-1; i>=0; i--) {
            temp += honeys[i]; 
            toLeftTotal[i] = temp;         // 누적합 채우기
        }
        
        long honeyTotal = toRightTotal[N-1];    // 전체 꿀의 양
        long bee1, bee2;
        
        // case1) 벌1: 맨 왼쪽, 벌통: 맨 오른쪽, 벌2: 선택
        for(int i=1; i<N-1; i++) {                          // 맨 왼, 맨 오 제외하고 벌2의 위치
            bee1 = honeyTotal - (honeys[0] + honeys[i]);    // 벌1: 전체 - (벌1 + 벌2)
            bee2 = honeyTotal - toRightTotal[i];            // 벌2: 전체 - (0 ~ 벌2까지의 누적합)
            
            max = Math.max(max, bee1 + bee2);
        }
        
        // case2) 벌1: 맨 왼쪽, 벌2: 맨 오른쪽, 벌통: 선택 
        for(int i=1; i<N-1; i++) {
            bee1 = toRightTotal[i] - honeys[0];             // 벌1: (0 ~ 벌통까지의 누적합) - 벌1
            bee2 = toLeftTotal[i] - honeys[N-1];            // 벌2: (끝 ~ 벌통까지의 누적합) - 벌2
            
            max = Math.max(max, bee1 + bee2);
        }
        
        // case3) 벌1: 맨 오른쪽, 벌통: 맨 왼쪽, 벌2: 선택
        for(int i=N-2; i>=0; i--) {
            bee1 = honeyTotal - (honeys[N-1] + honeys[i]);  // 벌1: 전체 - (벌1 + 벌2)
            bee2 = honeyTotal - toLeftTotal[i];             // 벌2: 전체 - (끝 ~ 벌2까지의 누적합) 
            
            max = Math.max(max, bee1 + bee2);
        }
        
        System.out.println(max);
    
    }
}