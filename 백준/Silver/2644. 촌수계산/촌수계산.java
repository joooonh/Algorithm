import java.util.*;

public class Main {
    
    static int[][] map;
    static int[] cnt; 
    
    static int n, m;
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();               // 인원수
        map = new int[n + 1][n + 1];    // n명 양방향 간선 연결
        cnt = new int[n + 1];           // 방문처리 + 카운트
        
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        
        m = sc.nextInt();
        for(int i=0; i<m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            
            map[x][y] = map[y][x] = 1;  // 간선 연결 (부모자식)
        }
        
        bfs(num1, num2);
        
        System.out.println(cnt[num2] == 0 ? -1 : cnt[num2]);
    }
    
    public static void bfs(int start, int end) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(start);
        
        while(!q.isEmpty()) {
            int temp = q.poll(); 
            if (temp == end) break;
            for(int i=1; i<=n; i++) {
                if (map[temp][i] == 1 && cnt[i] == 0) {
                    cnt[i] = cnt[temp] + 1;     // 방문처리 + 카운트
                    q.add(i);
                }
            }
        }
    }
}