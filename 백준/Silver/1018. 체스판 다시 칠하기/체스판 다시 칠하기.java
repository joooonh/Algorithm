// 방법 1
import java.util.*;

public class Main {
    
    public static boolean[][] board;
    public static int min = 64;                 // 8*8
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();                   // N행
        int M = sc.nextInt();                   // M열
        
        board = new boolean[N][M];
        for(int i=0; i < N; i++) {              // 주어진 보드 값을 boolean[][]에 채우기
            String s = sc.next();
            for(int j=0; j < M; j++) {
                if(s.charAt(j) == 'W')
                    board[i][j] = true;
                else
                    board[i][j] = false;
            }
        }
        
        // 8*8로 자르기
        int N_row = N - 7;
        int M_col = M - 7;
        
        for(int i=0; i < N_row; i++) {
            for(int j=0; j < M_col; j++) {
                find(i,j);                      // 최솟값 찾기
            }
        }
        
        System.out.println(min);
    }
    
    public static void find(int x, int y) {
        int x_end = x + 8;
        int y_end = y + 8;
        int cnt = 0;
        boolean first = board[x][y];            // 각 경우의 첫번째 값
        
        for(int i=x; i < x_end; i++) {
            for(int j=y; j < y_end; j++) {
                if(board[i][j] != first)        // 번갈아가는지 체크
                    cnt++;                      // 바뀐 문자와 다음 문자가 다르면 -> 연속 -> 카운트(바꿈)
                first = !first;
            }
            first = !first;                     // 행도 번갈아가는지 체크
        }
        
        cnt = Math.min(cnt, 64 - cnt);          // 첫번째 값이 반대일 때랑 둘중에 더 작은 카운트
        
        min = Math.min(cnt, min);
    }
}

// 방법 2 
import java.util.*;

public class Main {
    
    public static char[][] standard1 = new char[][] {
        {'W', 'B', 'W', 'B','W', 'B','W', 'B'},
        {'B', 'W', 'B', 'W','B', 'W','B', 'W'},
        {'W', 'B', 'W', 'B','W', 'B','W', 'B'},
        {'B', 'W', 'B', 'W','B', 'W','B', 'W'},
        {'W', 'B', 'W', 'B','W', 'B','W', 'B'},
        {'B', 'W', 'B', 'W','B', 'W','B', 'W'},
        {'W', 'B', 'W', 'B','W', 'B','W', 'B'},
        {'B', 'W', 'B', 'W','B', 'W','B', 'W'}
    };
    
    public static char[][] standard2 = new char[][] {
        {'B', 'W', 'B', 'W','B', 'W','B', 'W'},
        {'W', 'B', 'W', 'B','W', 'B','W', 'B'},
        {'B', 'W', 'B', 'W','B', 'W','B', 'W'},
        {'W', 'B', 'W', 'B','W', 'B','W', 'B'},
        {'B', 'W', 'B', 'W','B', 'W','B', 'W'},
        {'W', 'B', 'W', 'B','W', 'B','W', 'B'},
        {'B', 'W', 'B', 'W','B', 'W','B', 'W'},
        {'W', 'B', 'W', 'B','W', 'B','W', 'B'}
    };

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();                           // N행
        int M = sc.nextInt();                           // M열
        char[][] board = new char[N][M];
        int min = 64;
        int cnt1 = 0, cnt2 = 0;
        
        for(int i=0; i < N; i++) {
            board[i] = sc.next().toCharArray();         // 주어진 보드
        }
        
        for(int i = 0; i < N - 7; i++) {
            for(int j = 0; j < M - 7; j++) {
                
                for(int n = i, a = 0; n < i + 8; n++, a++) {
                    for(int m = j, b = 0; m < j + 8; m++, b++) {
                        if(standard1[a][b] != board[n][m])
                            cnt1++;
                        if(standard2[a][b] != board[n][m])
                            cnt2++;
                    }
                }
                min = Math.min(min, Math.min(cnt1, cnt2));
                cnt1 = 0; cnt2 = 0;
            }
        }
        System.out.println(min);
    }
    
}
