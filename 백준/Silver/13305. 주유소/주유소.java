import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] km = new int[N - 1];
        int[] oil = new int[N]; 
        
        for(int i=0; i<km.length; i++) {
            km[i] = sc.nextInt();
        }
        for(int i=0; i<oil.length; i++) {
            oil[i] = sc.nextInt();
        }
        
        long price = 0;
        long min = oil[0];
        for(int i=0; i<km.length; i++) {
            if(oil[i] < min)
                min = oil[i];
            price += km[i] * min;
        }
        System.out.println(price);
    }
}
