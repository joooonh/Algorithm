import java.util.*;

public class Main {
    public static void main(String args[]) {
      Scanner sc = new Scanner(System.in);
      int multitap = sc.nextInt();          // 멀티탭 구멍 수
      int K = sc.nextInt();                 // 총 사용횟수
      int[] order = new int[K];
      for(int i=0; i<K; i++) {
          order[i] = sc.nextInt();          // 전기용품 번호, 사용 순서 담는 배열
      }
      
      boolean[] use = new boolean[101];     // 0~100까지 전기용품 번호중 현재 꽂혀있는 번호 담는 배열
      int put = 0;                          // 꽂혀있는 개수
      int ans = 0; 
      for(int i=0; i<K; i++) {
          int temp = order[i];              // 순서가 i번째인 전기용품 번호를 temp에 담음
          
          if(!use[temp]) {                  // 전기용품이 꽂혀있지 않을 때
              if(put < multitap) {          // 꽂은 개수보다 멀티탭 구멍이 더 많을 때(넉넉할 때)
                  use[temp] = true;         // 꽂는다
                  put ++;                   
              } else {                      // 멀티탭이 넉넉하지 않을 때
                  ArrayList<Integer> list = new ArrayList<>();  // 현재 꽂혀있는 콘센트가 나중에 사용되는지 확인하는 리스트?
                  for(int j=i; j<K; j++) {
                      if(use[order[j]] && !list.contains(order[j])) {   // 이미 꽂혀있고, 리스트에 없으면 
                          list.add(order[j]);                           // 나중에 사용될지도 모르니 리스트에 추가
                      }
                  }
                  if(list.size() != multitap) {  // 일부가 나중에 사용될 때
                      for(int j=0; j<use.length; j++) {
                          if(use[j] && !list.contains(j)) { // 지금 꽂혀있는데, 나중에 사용되지 않으면 제거
                              use[j] = false;
                              break;
                          }
                      }
                  } else {                      // 일부가 아니라 모두 나중에 사용될 때
                      int remove = list.get(list.size() - 1);   // 가장 마지막에 사용될 용품을 제거 
                      use[remove] = false;
                  }
                  
                  use[temp] = true;         // 새로운 용품을 현재 콘센트에 꽂음
                  ans ++;                   // 교체 회수 계산
                  
              }
          }
          
      }
      
      System.out.println(ans);
      
    }
}