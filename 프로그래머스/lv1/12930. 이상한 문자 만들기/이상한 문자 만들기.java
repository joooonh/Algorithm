import java.util.*;

class Solution {
    public String solution(String s) {          
        StringBuilder sb = new StringBuilder();
        
        String[] arr = s.split("");     // [t,r,y, , ,h,e,l,l,o]
        
        int index = 0;
        
        for(int i=0; i<arr.length; i++) {     
            if (arr[i].equals(" ")) {
                index = 0;
            } else if (index % 2 == 0) {
                arr[i] = arr[i].toUpperCase();
                index++;
            } else {
                arr[i] = arr[i].toLowerCase();
                index++;
            }
            sb.append(arr[i]);
        }
        
        return sb.toString();
    }
}