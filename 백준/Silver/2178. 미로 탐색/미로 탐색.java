import java.util.*;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    
    static int N, M;
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt(); 
        
        map = new int[N][M];
        visited = new boolean[N][M]; 
        
        for(int i=0; i<N; i++) {
            String s = sc.next();
            for(int j=0; j<M; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }
        bfs(0, 0);
        System.out.println(map[N-1][M-1]);
    }
    
    public static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>(); 
        visited[x][y] = true; 
        q.offer(new int[]{x, y}); 
        
        while(!q.isEmpty()) {
            int[] temp = q.poll(); 
            
            for(int i=0; i<4; i++) {
                int nx = temp[0] + dx[i];
                int ny = temp[1] + dy[i]; 
                
                if (nx>=0 && ny>=0 && nx<N && ny<M) {
                    if (map[nx][ny] == 1 && !visited[nx][ny]) {
                        q.offer(new int[]{nx, ny});
                        visited[nx][ny] = true;
                        map[nx][ny] = map[temp[0]][temp[1]] + 1;
                    }
                }
            }
        }
    }
}