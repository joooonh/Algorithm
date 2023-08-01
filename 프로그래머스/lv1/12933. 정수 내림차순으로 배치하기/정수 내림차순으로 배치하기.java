import java.util.*; 

class Solution {
    public long solution(long n) {
        String s = Long.toString(n);        // "118372"
        int[] arr = new int[s.length()];    
        int max = 0; 
        
        for(int i=0; i<s.length(); i++) {
            arr[i] = s.charAt(i) - '0';     // [1,1,8,3,7,2]
            max = Math.max(max, arr[i]);
        }
        
        for(int i=0; i<arr.length-1; i++) {
            for(int j=i+1; j<arr.length; j++) {
                if (arr[i] < arr[j]) {
                    int temp = arr[i]; 
                    arr[i] = arr[j];
                    arr[j] = temp;          // [8,7,3,2,1,1]
                }
            }
        }
        
        String arrToStr = "";
        for(int i=0; i<arr.length; i++) {
            arrToStr += arr[i];
        }

        return Long.parseLong(arrToStr);

    }
}