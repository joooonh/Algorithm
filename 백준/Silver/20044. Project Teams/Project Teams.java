import java.util.*;

public class Main {
    public static void main(String args[]) {
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      
      int[] codingAbility = new int[2*n];
      
      for(int i=0; i<codingAbility.length; i++) {
          codingAbility[i] = sc.nextInt();
      }
      
      Arrays.sort(codingAbility);
      
      int min = Integer.MAX_VALUE;
      for(int i=0; i<codingAbility.length/2; i++) {
          int sum = codingAbility[i] + codingAbility[codingAbility.length - i - 1];
          if(sum < min)
            min = sum;
      }

      System.out.println(min);
    }
}