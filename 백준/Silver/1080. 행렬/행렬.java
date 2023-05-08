import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        int[][] A = new int[row][col];
        int[][] B = new int[row][col]; 
        
        // A 행렬 채우기
        for(int i=0; i < row; i++) {
            String s = sc.next();           
            for(int j=0; j < col; j++) {
                A[i][j] = s.charAt(j) - '0';
            }
        }
        // B 행렬 채우기
        for(int i=0; i < row; i++) {
            String s = sc.next(); 
            for(int j=0; j < col; j++) {
                B[i][j] = s.charAt(j) - '0';
            }
        }
        // 뒤집기
        int cnt = 0; 
        for(int i=0; i < row - 2; i++) {
            for(int j=0; j < col - 2; j++) {
                if(A[i][j] != B[i][j]) {                    // 3*3씩
                    for(int r = i; r < i + 3; r++) {
                        for(int c = j; c < j + 3; c++) {
                            A[r][c] = A[r][c] == 0 ? 1 : 0;
                        }
                    }
                    cnt ++;
                }
            }
        }
        // 두 행렬 같은지 비교
        for(int i=0; i < row; i++) {
            for(int j=0; j < col; j++) {
                if(A[i][j] != B[i][j]) {
                    cnt = -1;
                    break;
                }
            }
        }
        System.out.println(cnt);
    }
}