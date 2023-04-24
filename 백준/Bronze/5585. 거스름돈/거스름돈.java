import java.util.*;

public class Main {
    public static void main(String args[]) {
        
        List<Integer> list = Arrays.asList(500, 100, 50, 10, 5, 1);
        
        Scanner sc = new Scanner(System.in);
        int price = sc.nextInt();
        
        int balance = 1000 - price;
        int cnt = 0;
        
        for(int i=0; i < list.size(); i++) {
            cnt += balance/list.get(i);
            balance %= list.get(i);
        }
        
        System.out.println(cnt);
        
    }
}