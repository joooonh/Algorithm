import java.util.*;

class Solution {
    public int solution(int n) {
        List<Integer> list = new ArrayList<>();
        int answer = 0;
        int j = 1;
        
        while(n > 0) {
            list.add(n%3);   // {0, 0, 2, 1}
            n /= 3;
        }
        
        for(int i = list.size() - 1; i >= 0; i--) {
            answer += list.get(i) * j;
            j *= 3;
        }
        
        return answer;
    }
}