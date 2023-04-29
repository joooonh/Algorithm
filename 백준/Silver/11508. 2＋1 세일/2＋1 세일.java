import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();                               // 유제품 개수 
        Integer[] price = new Integer[N];                   // 가격 배열
        for(int i=0; i<N; i++) {
            price[i] = sc.nextInt();
        }
        
        Arrays.sort(price, Collections.reverseOrder());     // 가격배열 내림차순 정렬
        
        long sum = 0;
        for(int i=0; i<N; i++) {
            sum += price[i];                                // 가격배열 전체 합 
        }
        
        long remove = 0; 
        for(int i=2; i<N; i+=3) {
            remove += price[i];                             // 3의 배수번째 숫자들의 합
        }
        sum -= remove;                                      // 전체 - 3의 배수번째 숫자들의 합
        System.out.println(sum);
    }
}