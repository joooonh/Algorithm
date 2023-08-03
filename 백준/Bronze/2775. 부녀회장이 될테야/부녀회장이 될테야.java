import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine());
        
        for(int tc = 0; tc < t; tc++) {
            
            int k = Integer.parseInt(bf.readLine()); 
            int n = Integer.parseInt(bf.readLine());
            
            int[][] dp = new int[k + 1][n + 1]; 
            
            for(int i=1; i<=n; i++) {
                dp[0][i] = i;
            }
            
            for(int i=1; i<=k; i++) {
                int sum = 0;
                for(int j=1; j<=n; j++) {
                    sum += dp[i - 1][j];
                    dp[i][j] = sum;
                }
            }
            
            System.out.println(dp[k][n]);
        
        }
        
    }
}