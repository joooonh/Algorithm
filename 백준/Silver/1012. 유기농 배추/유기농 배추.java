import java.util.*;

public class Main {
    
    static int[][] map; 
    static boolean[][] visited; 
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1}; 
    
    static int M, N, K;
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for(int t=0; t<T; t++) {
            
            M = sc.nextInt();
            N = sc.nextInt();
            K = sc.nextInt();
            
            map = new int[M][N];
            visited = new boolean[M][N];
            
            for(int i=0; i<K; i++) {
                map[sc.nextInt()][sc.nextInt()] = 1;
            }
            
            int cnt = 0;
            
            for(int i=0; i<M; i++) {
                for(int j=0; j<N; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        bfs(i, j);
                        cnt ++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }
    
    public static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        
        q.offer(new int[]{x, y});
        visited[x][y] = true; 
        
        while(!q.isEmpty()) {
            int[] value = q.poll();
            
            for(int i=0; i<4; i++) {
                int nx = value[0] + dx[i];
                int ny = value[1] + dy[i]; 
                
                if (nx >= 0 && ny >= 0 && nx < M && ny < N) {
                    if (map[nx][ny] == 1 && !visited[nx][ny]) {
                        q.offer(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }
}