import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        long A = sc.nextLong();
        long B = sc.nextLong();
        
        long cnt = 1;
        
        while(true) {
            if(B % 2 == 0) {
                B /= 2;
                cnt++;
            } else if(B % 10 == 1) {
                B /= 10;
                cnt++;
            } else {
                cnt = -1; 
                break;
            }
            
            if(B == A) {
                break;
            } else if(B < A) {
                cnt = -1;
                break;
            }
        }
        System.out.println(cnt);
    }
}