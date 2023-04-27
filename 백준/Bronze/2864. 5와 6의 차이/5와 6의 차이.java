import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        String B = sc.next();
        String minA = A, minB = B, maxA = A, maxB = B;
        
        for(int i=0; i<A.length(); i++) {
            if(A.charAt(i) == '5' || A.charAt(i) == '6') {
                minA = A.replaceAll("6", "5");
                maxA = A.replaceAll("5", "6");
            }
        }
        for(int i=0; i<B.length(); i++) {
            if(B.charAt(i) == '5' || B.charAt(i) == '6') {
                minB = B.replaceAll("6", "5");
                maxB = B.replaceAll("5", "6");
            }
        }
        int min = Integer.parseInt(minA) + Integer.parseInt(minB);
        int max = Integer.parseInt(maxA) + Integer.parseInt(maxB);
        System.out.println(min + " " + max);
    }
}