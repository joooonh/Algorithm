class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int tLength = t.length();   
        int pLength = p.length();  
        long pNum = Long.parseLong(p);
        
        for(int i=0; i<=tLength - pLength; i++) {
            long num = Long.parseLong(t.substring(i, i + pLength));
            if (num <= pNum) answer ++;
        }
        
        return answer;
    }
}