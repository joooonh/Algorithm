import java.util.*;

public class Main {
    
    static int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dy = {2, 1, -1, -2, -2, -1, 1, 2}; 
    
    static int[][] map;
    static boolean[][] visited;
    
    static int I;
    static int sx, sy, ex, ey;
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        for(int t=0; t<T; t++) {
            
            I = sc.nextInt();
            map = new int[I][I];
            visited = new boolean[I][I];
            
            sx = sc.nextInt();
            sy = sc.nextInt();
            ex = sc.nextInt();
            ey = sc.nextInt();
            
            if (!visited[sx][sy]) {
                bfs();
            }
            System.out.println(map[ex][ey]);
        }
    }
    
    public static void bfs() {
        Queue<int[]> q = new LinkedList<>(); 
        q.offer(new int[]{sx, sy});
        visited[sx][sy] = true; 
        
        while(!q.isEmpty()) {
            int[] temp = q.poll();
            int tempX = temp[0];
            int tempY = temp[1]; 
            
            for(int i=0; i<8; i++) {
                int nx = tempX + dx[i];
                int ny = tempY + dy[i]; 
                
                if (nx >= 0 && ny >= 0 && nx < I && ny < I) {
                    if (!visited[nx][ny]) {
                        q.offer(new int[]{nx, ny}); 
                        visited[nx][ny] = true;
                        map[nx][ny] = map[tempX][tempY] + 1; 
                    }
                }
            }
        }
    }
}