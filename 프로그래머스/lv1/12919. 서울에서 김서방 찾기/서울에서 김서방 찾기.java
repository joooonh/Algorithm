import java.util.*; 

class Solution {
    public String solution(String[] seoul) {
        int x = 0;
        
        for(int i=0; i<seoul.length; i++) {
            if (seoul[i].equals("Kim")) {
                x = i; 
                break;
            }
        }
        return new StringBuilder().append("김서방은 ").append(x).append("에 있다").toString();
    }
}