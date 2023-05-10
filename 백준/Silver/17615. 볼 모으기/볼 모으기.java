import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in); 
        int N = sc.nextInt();
        String s = sc.next();
        
        int min = 0;
        int rCnt = 0, bCnt = 0;
        int cnt = 0;
        
        // 1) 각 색깔의 개수 중 더 작은 값
        for(int i=0; i<N; i++) {
            if(s.charAt(i) == 'R')
                rCnt++;
            else
                bCnt++;
        }
        if(rCnt == 0 || bCnt == 0)
            min = 0;
            
        min = Math.min(rCnt, bCnt);        
        
        // 2) 왼쪽부터 연속된 공을 해당 색의 전체개수에서 빼기
        for(int i=0; i<N; i++) {
            if(s.charAt(0) != s.charAt(i)) break;
            cnt++;
        }
        if(s.charAt(0) == 'R') 
            min = Math.min(min, rCnt - cnt); 
        else 
            min = Math.min(min, bCnt - cnt);
        // 3) 오른쪽부터 연속된 공을 해당 색의 전체개수에서 빼기
        cnt = 0;
        for(int i = N - 1; i >= 0; i--) {
            if(s.charAt(N - 1) != s.charAt(i)) break;
            cnt++;
        }
        if(s.charAt(N - 1) == 'R')
            min = Math.min(min, rCnt - cnt);
        else
            min = Math.min(min, bCnt - cnt);
            
        System.out.println(min);
    }
}