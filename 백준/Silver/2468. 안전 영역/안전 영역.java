import java.util.*;

public class Main {
    static int[][] map; 
    static boolean[][] visited; 
    
    static int[] dirX = {-1, 1, 0, 0}; 
    static int[] dirY = {0, 0, -1, 1};
    
    static int N; 
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];
        
        int max_dept = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                map[i][j] = sc.nextInt();
                if (max_dept < map[i][j])
                    max_dept = map[i][j];
            }
        }
        
        int max = 0;
        
        for(int height = 0; height <= max_dept; height++) {
            visited = new boolean[N][N];
            int cnt = 0;
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if (map[i][j] > height && !visited[i][j]) {
                        dfs(i, j, height);
                        cnt++;
                    }
                }
            }
            max = Math.max(max, cnt);
        }
        System.out.println(max);
    }
    
    public static void dfs(int x, int y, int height) {
        visited[x][y] = true; 
        
        for(int i=0; i<4; i++) {
            int nowX = x + dirX[i];
            int nowY = y + dirY[i];
            
            if (nowX >= 0 && nowY >= 0 && nowX < N && nowY < N) {
                if (map[nowX][nowY] > height && !visited[nowX][nowY])
                    dfs(nowX, nowY, height);
            }
        }
    }
}