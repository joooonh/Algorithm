import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int count = 0;
        
        if(n%2 != 0 && n/5 == 0) {          // 5원, 2원으로 만들 수 없는 수는 -1 반환
            count = -1;
        } else if((n%5)%2 == 0) {           // 5원으로 나눈 나머지가 2의 배수이면
            count += n/5;                   // 5원의 개수는 n/5
            count += (n%5)/2;               // 2원의 개수는 n%5/2
        } else if((n%5)%2 != 0) {
            count += n/5 - 1;
            count += (n%5 + 5)/2;
        }
        System.out.println(count);
    }
}