import java.util.*;

public class Main {
    
    static int cnt = 0;
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in); 
        int n = sc.nextInt(); 
        
        // 재귀호출
        System.out.print(fib(n));
        
        cnt = 0;
        
        // 동적 프로그래밍
        System.out.print(" " + fibonacci(n));
        
    }
    
    public static int fib(int n) {
        cnt++;
        
        if (n == 1 || n == 2) {
            return 1;
        } 
        
        return fib(n - 1) + fib(n - 2);
    }
    
    public static int fibonacci(int n) {
        int[] f = new int[41];
        f[1] = 1; 
        f[2] = 1;
        
        for(int i=3; i<=n; i++) {
            cnt++;
            f[i] = f[i - 1] + f[i - 2];
        }
        
        return cnt;
    }
}