import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int width = 0; 
        int height = 0; 
        
        for(int[] arr : sizes) {
            width = Math.max(width, Math.max(arr[0], arr[1])); 
            height = Math.max(height, Math.min(arr[0], arr[1]));
        }
        
        return width*height;
    }
}