import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        
        s = s.replaceAll("XXXX", "AAAA"); 
        s = s.replaceAll("XX", "BB");
        if(s.contains("X"))
            s = "-1";
        
        System.out.println(s);
    }
}