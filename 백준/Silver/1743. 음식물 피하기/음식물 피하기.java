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
        int K = sc.nextInt();           // 5
        
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