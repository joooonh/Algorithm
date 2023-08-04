import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in); 
        int n = sc.nextInt(); 
        
        int[] dp = new int[1001]; 
        
        // 기본값 세팅 (상근승 = 0, 창영승 = 1)
        dp[1] = 1;
        dp[2] = 0; 
        dp[3] = 1;
        
        // 1개 남았을 때, 3개 남았을 때 누가 이기는지 확인
        for(int i=4; i<=n; i++) {
            dp[i] = (dp[i - 3] == 1 && dp[i - 1] == 1) ? 0 : 1;
        }
        
        System.out.println(dp[n] == 0 ? "SK" : "CY");
        
    }
}