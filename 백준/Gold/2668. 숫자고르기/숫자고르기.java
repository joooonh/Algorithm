import java.util.*;

public class Main {
    
    static int[] num; 
    static boolean[] visited; 
    
    static int N;
    static int target;
    
    static List<Integer> list;
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); 
        num = new int[N + 1];
        visited = new boolean[N + 1]; 
        list = new ArrayList<Integer>();
        
        for(int i=1; i<=N; i++) {
            num[i] = sc.nextInt();
        }
        
        for(int i=1; i<=N; i++) {
            visited[i] = true;  // 무한재귀 방지 -> 첫번째 방문처리 
            target = i;         // 사이클의 시작, 끝 점
            dfs(i);             // 사이클 찾기
            visited[i] = false; // 다음 숫자 dfs를 위해 초기화
        }
        
        Collections.sort(list);
        
        System.out.println(list.size());
        
        for(int ans : list)
            System.out.println(ans);
        
    }
    
    public static void dfs(int i) {
        if (!visited[num[i]]) {         // 방문한 적이 없어야 함
            visited[num[i]] = true;     // 방문처리
            dfs(num[i]);
            visited[num[i]] = false;    // 다음 dfs를 위해 초기화
        }
        
        if (num[i] == target)           // 사이클 완성 -> 리스트에 추가
            list.add(target);
    }
}