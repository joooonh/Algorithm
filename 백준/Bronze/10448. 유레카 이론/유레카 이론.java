import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in); 
        int T = sc.nextInt();
        int[] testcase = new int[T];        // 테스트케이스 배열
        int[] ans = new int[T];
        int[] tri = new int[45];            // 삼각수 배열
        
        for(int i=0; i < tri.length; i++) {
            tri[i] = i*(i + 1) / 2;
        }
        
        for(int i=0; i < T; i++) {
            testcase[i] = sc.nextInt();
        
            for(int j=1; j < tri.length; j++) {
                for(int n=1; n < tri.length; n++) {
                    for(int m=1; m < tri.length; m++) {
                        
                        if((tri[j] + tri[n] + tri[m]) == testcase[i]) {
                            ans[i] = 1;
                            break;
                        } 
                    }
                }
            }
        }
        
        for(int n : ans) {
            System.out.println(n);
        }
    }
}