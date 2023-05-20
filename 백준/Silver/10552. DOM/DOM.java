import java.util.*;

public class Main {
    
    static int[] change;
    static boolean[] visited;
    static int cnt = 0;
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in); 
        int N = sc.nextInt();               // 사람 수 
        int M = sc.nextInt();               // TV 채널
        int P = sc.nextInt();               // 처음 채널
        
        change = new int[M + 1];
        visited = new boolean[M + 1]; 
        
        for(int i=0; i < N; i++) {
            int favCh = sc.nextInt();
            int hatedCh = sc.nextInt();
            
            if (change[hatedCh] == 0) {
                change[hatedCh] = favCh;    // 처음(젤 어린사람) 선호 채널로 변경하도록
            }
        }
        dfs(P);                             // 채널 변경
        System.out.println(cnt);
    }
    
    public static void dfs(int ch) {
        if (visited[ch]) {
            cnt = -1;                       // 무한반복이면 -1
        } else if (change[ch] != 0) {
            visited[ch] = true;
            cnt++;
            dfs(change[ch]);
        }
    }
}