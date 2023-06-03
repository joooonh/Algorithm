import java.util.*;

public class Main {
    
    static int[][] map;
    static boolean[][] visited;
    
    static int[] dirX = {-1, 1, 0, 0}; 
    static int[] dirY = {0, 0, -1, 1};
    
    static int N;
    
    static int cnt = 0;
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        
        map = new int[N][N];
        visited = new boolean[N][N]; 
        
        for(int i=0; i<N; i++) {
            String s = sc.next();
            for(int j=0; j<s.length(); j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    dfs(i, j); 
                    list.add(cnt);
                    cnt = 0;
                }
            }
        }
        
        System.out.println(list.size());
        
        Collections.sort(list);
        
        for(int ans : list) {
            System.out.println(ans);
        }
    }
    
    public static void dfs(int x, int y) {
        visited[x][y] = true;
        cnt++; 
        
        for(int i=0; i<4; i++) {
            int nowX = x + dirX[i];
            int nowY = y + dirY[i]; 
            
            if (nowX >= 0 && nowY >= 0 && nowX < N && nowY < N) {
                if (map[nowX][nowY] == 1 && !visited[nowX][nowY]) {
                    dfs(nowX, nowY);
                }
            }
        }
    }
}