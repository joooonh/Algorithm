import java.util.*;

class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        
        for(char c : s.toCharArray()) {
            if (c == ' ') {
                sb.append(" ");
            } else if ('a' <= c && c <= 'z') {
                sb.append((char)('a' + (c + n - 'a')%26));
            } else if ('A' <= c && c <= 'Z') {
                sb.append((char)('A' + (c + n - 'A')%26));
            } 
        }
        
        return sb.toString();
    }
}