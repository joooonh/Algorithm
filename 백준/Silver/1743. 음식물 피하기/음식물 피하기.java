// dfs
import java.util.*; 

public class Main {
    
    static int[] dirX = {-1, 1, 0, 0};
    static int[] dirY = {0, 0, -1, 1}; 
    static int[][] arr;
    static boolean[][] visited; 
    static int sum = 0; static int max = 0;
    static int N; static int M;
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in); 
        N = sc.nextInt();           // 3
        M = sc.nextInt();           // 4
        int K = sc.nextInt();       // 5
        
        arr = new int[N][M];
        visited = new boolean[N][M]; 
        
        for(int i=0; i < K; i++) {
            int r = sc.nextInt() - 1;
            int c = sc.nextInt() - 1;
            arr[r][c] = 1;
        }
        
        for(int i=0; i < N; i++) {
            for(int j=0; j < M; j++) {
                if (arr[i][j] == 1 && !visited[i][j]) {
                    dfs(i, j);
                    max = Math.max(sum, max);
                    sum = 0;
                }
            }
        }
        System.out.println(max); 
    }
    
    public static void dfs(int x, int y) {
        visited[x][y] = true;
        sum ++;
        
        for(int i=0; i < 4; i++) {
            int newX = x + dirX[i]; 
            int newY = y + dirY[i];
            
            if (newX >= 0 && newY >= 0 && newX < N && newY < M ) {
                if (arr[newX][newY] == 1 && !visited[newX][newY]) {
                    dfs(newX, newY);
                }
            }
        }
    }
}

// bfs 
import java.util.*;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    static int[][] map;
    static boolean[][] visited;
    
    static int N, M, cnt;
    static int max = 0;
    
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt(); 
        map = new int[N][M];
        visited = new boolean[N][M];
        
        int K = sc.nextInt(); 
        for(int i = 0; i < K; i++) {
            int r = sc.nextInt(); 
            int c = sc.nextInt();
            map[r-1][c-1] = 1;
        }
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    cnt = 0; 
                    bfs(i, j);
                    max = Math.max(max, cnt);
                }
            }
        }
        System.out.println(max);
    }
    
    public static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true; 
        
        while(!q.isEmpty()) {
            int[] temp = q.poll(); 
            cnt++; 
            
            for(int i = 0; i < 4; i++) {
                int nx = temp[0] + dx[i]; 
                int ny = temp[1] + dy[i]; 
                
                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (map[nx][ny] == 1 && !visited[nx][ny]) {
                        q.offer(new int[]{nx, ny}); 
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }
}
