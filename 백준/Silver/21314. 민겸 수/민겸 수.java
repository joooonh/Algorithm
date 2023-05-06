import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        
        int mCnt = 0; 
        StringBuilder sbMax = new StringBuilder();
        StringBuilder sbMin = new StringBuilder();
        
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == 'M') {
                mCnt++;
            } else {                // 'K'일 때 
                if(mCnt > 0) {
                    sbMax.append(5).append("0".repeat(mCnt));
                    sbMin.append(1).append("0".repeat(mCnt - 1)).append(5);
                    mCnt = 0;
                } else {            // 'M'이 없을 때
                    sbMax.append(5);
                    sbMin.append(5);
                }
            }
        }
        if(mCnt > 0) {
            sbMax.append("1".repeat(mCnt));
            sbMin.append("1").append("0".repeat(mCnt - 1));
        }
        System.out.println(sbMax.toString());
        System.out.println(sbMin.toString());
    }
}