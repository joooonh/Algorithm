class Solution {
    public String solution(String s) {
        String answer = "";
        int length = s.length();
        
        if (length % 2 != 0) {
            answer += s.charAt(length/2);
        } else {
            answer += String.valueOf(s.charAt(length/2 - 1)) + String.valueOf(s.charAt(length/2));
        } 
        return answer;
    }
}