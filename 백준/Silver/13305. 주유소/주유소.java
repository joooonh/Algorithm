import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        int[] road = new int[N - 1];        // 도로 길이
        int[] oil = new int[N];             // 기름값
        
        for(int i=0; i<road.length; i++) {
            road[i] = sc.nextInt();
        }
        for(int i=0; i<oil.length; i++) {
            oil[i] = sc.nextInt();
        }
        
        int price = 0;
        int min = oil[0];                   // 처음 기름값이니까 얘가 최소값
        for(int i=0; i<road.length; i++) {
            if(oil[i] < min)
                min = oil[i];
            price += (min*road[i]);         // 기름의 최소값 * 도로길이
        }
        
        System.out.println(price);
    }
}