class Solution {
    public int solution(String s) {
        int answer = 0; 
        boolean sign = true;
        
        for(int i=0; i<s.length(); i++) {
            if (s.charAt(i) == '-')
                sign = false;
            else if (s.charAt(i) != '+')
                answer = answer*10 + (s.charAt(i) - '0');
        }
        
        return sign == false ? -1*answer : answer;
    }
}