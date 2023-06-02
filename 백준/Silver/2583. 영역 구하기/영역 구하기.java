import java.util.*;

public class Main {
    
    static int[][] map;
    
    static int[] dirX = {-1, 1, 0, 0};
    static int[] dirY = {0, 0, -1, 1};
    
    static int cnt = 0;
    
    static int M;
    static int N;
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        M = sc.nextInt();
        N = sc.nextInt();
        int K = sc.nextInt();
        
        map = new int[M][N];
        
        for(int i=0; i < K; i++) {
            int x1 = sc.nextInt(); 
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            
            for(int a = y1; a < y2; a++) {
                for(int b = x1; b < x2; b++) {
                    map[a][b] = 1;
                }
            }
        }
        
        // 넓이를 담을 리스트
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i=0; i < M; i++) {
            for(int j=0; j < N; j++) {
                if (map[i][j] == 0) {
                    dfs(i, j);
                    list.add(cnt);
                    cnt = 0;
                }
            }
        }
        System.out.println(list.size());
        
        Collections.sort(list);
        
        for(Integer width : list) {
            System.out.print(width + " "); 
        }
        
    }
    
    public static void dfs(int x, int y) {
        map[x][y] = 1;
        cnt++;
        
        for(int i=0; i < 4; i++) {
            int nowX = x + dirX[i]; 
            int nowY = y + dirY[i];
            
            if (nowX >= 0 && nowY >= 0 && nowX < M && nowY < N) {
                if (map[nowX][nowY] == 0)
                    dfs(nowX, nowY);
            }
        }
    }
}