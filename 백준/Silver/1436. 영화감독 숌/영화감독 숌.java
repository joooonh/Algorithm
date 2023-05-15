import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int i = 666;
        int cnt = 0;
        
        while(true) {
            if(Integer.toString(i).contains("666"))
                cnt++;
            if(cnt == n)
                break;
            i++;
        }
        System.out.println(i);
    }
}