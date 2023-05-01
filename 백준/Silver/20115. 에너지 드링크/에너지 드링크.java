import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in); 
        int N = sc.nextInt();
        Integer[] drink = new Integer[N];
        for(int i=0; i<N; i++) {
            drink[i] = sc.nextInt();
        }
        
        Arrays.sort(drink, Collections.reverseOrder());
        
        double sum = drink[0];
        for(int i=1; i<N; i++) {
            sum += drink[i]/2.0;
        }
        
        System.out.println(sum);
    }
}