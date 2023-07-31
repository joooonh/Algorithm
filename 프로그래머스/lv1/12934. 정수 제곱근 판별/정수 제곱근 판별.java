class Solution {
    public long solution(long n) {
        long i = 0;
        
        while(i <= n) {
            if (i*i == n)
                return (i + 1)*(i + 1);
            i++;
        }
        return -1;
    }
}