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
                if (!visited[i][j]) {
                    dfs(i, j);
                    cntA++;
                }
            }
        }
        
        // 적록색약 o
        visited = new boolean[N][N];
        
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if (map[i][j] == 'G')
                    map[i][j] = 'R';
            }
         }
        
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if (!visited[i][j]) {
                    dfs(i, j);
                    cntB++;
                } 
            }
        }
        System.out.println(cntA + " " + cntB); 
    
    }
    
    public static void dfs(int x, int y) {
        visited[x][y] = true;
        char temp = map[x][y];
        
        for(int i=0; i<4; i++) {
            int nx = x + dx[i]; 
            int ny = y + dy[i];
            
            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                if (map[nx][ny] == temp && !visited[nx][ny]) {
                    dfs(nx, ny);
                } 
            }
        }
    }
}