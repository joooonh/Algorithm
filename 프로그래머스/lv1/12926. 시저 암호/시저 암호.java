import java.util.*;

class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        char[] small = new char[26];
        char[] capital = new char[26]; 
        
        for(int i=0; i<26; i++) {
            small[i] = (char) (i + 97);
            capital[i] = (char) (i + 65);
        }
        
        for(char c : s.toCharArray()) {
            if (97 <= c && c <= 122) {
                for(int i=0; i<small.length; i++) {
                    if (c == small[i])
                        sb.append(small[(i + n)%26]);
                }
            } else if (65 <= c && c <= 90) {
                for(int i=0; i<capital.length; i++) {
                    if (c == capital[i])
                        sb.append(capital[(i + n)%26]);
                }
            } else {
                sb.append(" ");
            }
        }
        
        return sb.toString();
    }
}