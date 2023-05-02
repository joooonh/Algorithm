import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        String s = sc.next();
        
        char[] list = s.toCharArray();              // 문자열을 char 배열로
        boolean[] ate = new boolean[list.length];   // 먹었는지 확인하는 배열
        
        int maxCnt = 0;
        
        for(int i=0; i<list.length; i++) {
            if(list[i] == 'P') {
                int startIndex = Math.max(0, i-K);
                int endIndex = Math.min(N-1, i+K);
                for(int j=startIndex; j<=endIndex; j++) {
                    if(list[j] == 'H' && !ate[j]) {
                        ate[j] = true;
                        maxCnt ++;
                        break;
                    }
                }
            }
        }
        
        System.out.println(maxCnt);
        
    }
}