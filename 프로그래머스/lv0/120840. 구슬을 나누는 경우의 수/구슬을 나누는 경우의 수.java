class Solution {
    public int solution(int balls, int share) {
        
        long ans = 1;
        int rest = 1;
        
        for(int i = share + 1; i <= balls; i++) {
            ans *= i;
            ans /= rest;
            rest ++;
        }
        
        return (int)ans;
    }
}