import java.util.*; 

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int[] height = new int[9];
        int[] arr = new int[7];
        int sum = 0;
        
        for(int i = 0; i < height.length; i++) {          // 키 배열
            height[i] = sc.nextInt();
            sum += height[i];
        }
        
        for(int i = 0; i < 8; i++) {
            for(int j = i + 1; j < 9; j++) {
                if(sum - (height[i] + height[j]) == 100) {
                    height[i] = 0; 
                    height[j] = 0;
                    
                    Arrays.sort(height);
                    for(int n = 2; n < 9; n++) {
                        System.out.println(height[n]);
                    }
                    return;
                }
            }
        }
    }
}