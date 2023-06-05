import java.util.*;

public class Main {
    
    static char[][] map;
    static boolean[][] visited;
    
    static int N;
    
    static int[] dx = {-1, 1, 0, 0}; 
    static int[] dy = {0, 0, -1, 1};
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        
        map = new char[N][N];
        visited = new boolean[N][N];
        
        for(int i=0; i<N; i++) {
            String s = sc.next();  
            for(int j=0; j<s.length(); j++) {
                map[i][j] = s.charAt(j);
            }
        }
        
        int cntA = 0;
        int cntB = 0;
        
        // 적록색약 x
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if (map[i][j] == 'R' && !visited[i][j]) {
                    dfsR(i, j);
                    cntA++;
                } else if (map[i][j] == 'G' && !visited[i][j]) {
                    dfsG(i, j);
                    cntA++;
                } else if (map[i][j] == 'B' && !visited[i][j]) {
                    dfsB(i, j); 
                    cntA++;
                }
            }
        }
        
        visited = new boolean[N][N];
        // 적록색약 o
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if ((map[i][j] == 'R' || map[i][j] == 'G') && !visited[i][j]) {
                    dfs(i, j);
                    cntB++;
                } else if (map[i][j] == 'B' && !visited[i][j]) {
                    dfsB(i, j); 
                    cntB++;
                }
            }
        }
        System.out.println(cntA + " " + cntB); 
    
    }
    
    public static void dfsR(int x, int y) {
        visited[x][y] = true;
        
        for(int i=0; i<4; i++) {
            int nx = x + dx[i]; 
            int ny = y + dy[i];
            
            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                if (map[nx][ny] == 'R' && !visited[nx][ny]) {
                    dfsR(nx, ny);
                } 
            }
        }
    }
    public static void dfsG(int x, int y) {
        visited[x][y] = true;
        
        for(int i=0; i<4; i++) {
            int nx = x + dx[i]; 
            int ny = y + dy[i];
            
            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                if (map[nx][ny] == 'G' && !visited[nx][ny]) {
                    dfsG(nx, ny);
                } 
            }
        }
    }
    public static void dfsB(int x, int y) {
        visited[x][y] = true;
        
        for(int i=0; i<4; i++) {
            int nx = x + dx[i]; 
            int ny = y + dy[i];
            
            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                if (map[nx][ny] == 'B' && !visited[nx][ny]) {
                    dfsB(nx, ny);
                } 
            }
        }
    }
    public static void dfs(int x, int y) {
        visited[x][y] = true;
        
        for(int i=0; i<4; i++) {
            int nx = x + dx[i]; 
            int ny = y + dy[i];
            
            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                if ((map[nx][ny] == 'R' || map[nx][ny] == 'G') && !visited[nx][ny]) {
                    dfs(nx, ny);
                } 
            }
        }
    }
}