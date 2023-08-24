class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        
        int gcd = gcd(n, m);
        int lcm = lcm(gcd, n, m); 
        
        answer[0] = gcd;
        answer[1] = lcm;
        
        return answer;
    }
    
    private int gcd(int n, int m) {
        if (m == 0) 
            return n;
        else {
            return gcd(m, n%m);
        }
    }
    
    private int lcm(int gcd, int n, int m) {
        return (n*m)/gcd;
    }
}