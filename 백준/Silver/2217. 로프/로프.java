import java.util.*; 

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        
        for(int i=0; i<N; i++) {
            arr[i] = sc.nextInt();
        }
        
        Arrays.sort(arr);
        
        int max = 0;
        if(N == 1) {
            max = arr[0];
        } else {
            for(int i=0; i<N; i++) {
                int weight = arr[i] * (N-i);  // i번째로 작은 로프부터 사용하는 경우의 최대 중량
                max = Math.max(max, weight);
            }
        }
        
        System.out.println(max); 
    }
}