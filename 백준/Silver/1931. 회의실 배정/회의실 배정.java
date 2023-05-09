import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in); 
        int N = sc.nextInt();
        
        int[][] time = new int[N][2];
        for(int i=0; i < N; i++) {
            time[i][0] = sc.nextInt(); 
            time[i][1] = sc.nextInt();
        }
        
        // 종료시간 기준 정렬
        Arrays.sort(time, (o1, o2) -> {
            if(o1[1] == o2[1]) {
                return o1[0] - o2[0];       // 종료시간이 같을 경우 시작시간순 정렬
            }
            return o1[1] - o2[1];
        });
        
        int cnt = 0;
        int prevEndTime = 0;
        for(int i=0; i < N; i++) {
            if(prevEndTime <= time[i][0]) {
                prevEndTime = time[i][1];
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}