import java.util.*;

public class Main {
    static int N, M;
    static int[][] graph; 
    static boolean[] visit;
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); 
        M = sc.nextInt();
        graph = new int[N + 1][N + 1];
        visit = new boolean[N + 1];
        
        for(int i=0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            
            // 간선 연결 
            graph[a][b] = graph[b][a] = 1;
        }
        
        int answer = 0;
        for(int i=1; i <= N; i++) {
            if(visit[i] == false) {
                dfs(i);
                answer++;
            }
        }
        System.out.println(answer);
    }
    
    // 방문하지 않은 노드 중 첫번째 노드부터 연결된 노드 확인
    public static void dfs(int index) {
        if(visit[index] == true)
            return;
        else {
            visit[index] = true;
            for(int i=1; i <= N; i++) {
                if(graph[index][i] == 1) {  // 연결되어 있으면
                    dfs(i);                 // 연결된 노드 방문했는지 확인 -> dfs 
                }
            }
        }
    }
}