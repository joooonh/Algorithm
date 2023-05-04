import java.util.*;
import java.io.*;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int answer = 0;
		List<String> bList = new ArrayList<>();
		List<String> rList = new ArrayList<>();
		
		String line = bf.readLine();
		StringTokenizer st = new StringTokenizer(line, "R");
		
		while(st.hasMoreTokens()) {
		    bList.add(st.nextToken());
		}
		
		st = new StringTokenizer(line, "B");
		
		while(st.hasMoreTokens()) {
		    rList.add(st.nextToken());
		}
		
		if(rList.size() >= bList.size()) {
		    answer = bList.size() + 1;
		} else {
		    answer = rList.size() + 1;
		}
		
		System.out.println(answer);
	}
}