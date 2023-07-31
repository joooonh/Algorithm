class Solution {
    boolean solution(String s) {
        boolean answer = true;

        s = s.toLowerCase();
        int pCnt = 0;
        int yCnt = 0;
        
        for(int i=0; i < s.length(); i++) {
            if (s.charAt(i) == 'p') pCnt++;
            else if (s.charAt(i) == 'y') yCnt++;
        }
        
        if (pCnt != yCnt) answer = false;

        return answer;
    }
}