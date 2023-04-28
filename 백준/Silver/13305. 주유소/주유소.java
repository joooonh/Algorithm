import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        int[] road = new int[N - 1];    // 도로 길이
        int[] oil = new int[N];         // 기름값
        
        for(int i=0; i<road.length; i++) {
            road[i] = sc.nextInt();
        }
        for(int i=0; i<oil.length; i++) {
            oil[i] = sc.nextInt();
        }
        
        int price = road[0]*oil[0];   // 처음 도시는 다음 거리만큼 무조건 넣어야 함
        
        for(int i=0; i<road.length - 1; i++) {
            price += oil[i]*road[i + 1] < oil[i + 1]*road[i + 1] ? oil[i]*road[i + 1] : oil[i + 1]*road[i + 1]; 
        }
        
        System.out.println(price);
    }
}