import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String exp = sc.nextLine();
        
        String[] splited = exp.split("-"); 
        
        int answer = 0; 
        for(int i = 0; i < splited.length; i++) {
            String[] add = splited[i].split("\\+");
            
            int sum = 0;
            for(int j = 0; j < add.length; j++) {
                sum += Integer.parseInt(add[j]);
            }
            if(i == 0)  answer += sum;
            else        answer -= sum;
            
        }
        System.out.println(answer);
    }
}