class Solution {
    public String solution(String[] seoul) {
        String answer = "김서방은 ";
        int x = 0;
        
        for(int i=0; i<seoul.length; i++) {
            if (seoul[i].equals("Kim"))
                x = i;
        }
        return answer + x + "에 있다";
    }
}