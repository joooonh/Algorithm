import java.util.*;

public class Main {
    
    // 상하좌우
    public static int[] dirX = {0, 0, -1, 1};
    public static int[] dirY = {-1, 1, 0, 0};
    
    // 배추밭, 방문여부 배열
    public static int[][] map;
    public static boolean[][] visit;
    
    // 가로, 세로, 배추개수 변수
    public static int M, N, K;
    // 상하좌우로 이동한 x, y
    public static int nowX, nowY;
    // 배추흰지렁이 마리 수 
    public static int cnt;
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        // 테스트케이스 
        int T = sc.nextInt();
        for(int i=0; i < T; i++) {
            // 배추밭 가로, 세로, 배추개수 
            M = sc.nextInt();
            N = sc.nextInt();
            K = sc.nextInt();
            
            map = new int[M][N]; 
            visit = new boolean[M][N];
            
            // 배추밭 생성
            for(int j=0; j < K; j++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                map[x][y] = 1;
            }
            
            // 처음부터 돌면서 1이면서 방문 안한 곳 -> 방문
            cnt = 0;
            for(int j=0; j < M; j++) {
                for(int k=0; k < N; k++) {
                    if(map[j][k] == 1 && !visit[j][k]) {
                        dfs(j, k);
                        cnt++;
                    }
                }
            }
            
            System.out.println(cnt);
        }
    }
    
    // 상하좌우 돌기
    public static void dfs(int x, int y) {
        visit[x][y] = true;
        
        for(int i=0; i < 4; i++) {
            nowX = x + dirX[i];
            nowY = y + dirY[i];
            
            // 범위 확인
            if(nowX >= 0 && nowY >= 0 && nowX < M && nowY < N) {
                if(map[nowX][nowY] == 1 && !visit[nowX][nowY]) {
                    dfs(nowX, nowY); 
                }
            }
        }
        
    }
}