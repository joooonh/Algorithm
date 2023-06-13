import java.util.*;

public class Main {
    static int[][] map;
    static boolean[] visited;
    
    static int N, M, V;
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        V = sc.nextInt();
        
        map = new int[N + 1][N + 1]; 
        
        for (int i=0; i<M; i++) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            
            map[r][c] = map[c][r] = 1;
        }
        
        visited = new boolean[N + 1];
        dfs(V);
        
        System.out.println();
        
        visited = new boolean[N + 1];
        bfs(V);
    
    }
    
    public static void dfs(int start) { // 노선의 꼬리의 꼬리
        visited[start] = true; 
        System.out.print(start + " "); 
        
        for (int i=1; i<=N; i++) {
            if (map[start][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }
    
    public static void bfs(int start) { // 한 노선에 연결된 것 
        Queue<Integer> q = new LinkedList<>(); 
        q.offer(start); 
        visited[start] = true;
        
        while (!q.isEmpty()) {
            int value = q.poll();
            System.out.print(value + " ");
            
            for(int i=1; i<=N; i++) {
                if (map[value][i] == 1 && !visited[i]) {
                    q.offer(i);
                    visited[i] = true; 
                }
            }
        }
    }
}