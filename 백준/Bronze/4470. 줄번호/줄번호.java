import java.util.*;
import java.io.*;

public class Main{
    
    static int N, M;
    static List<Integer> snackes = new ArrayList<>();
    static int answer;
    
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++){
            sb.append(i).append(". ").append(br.readLine()).append("\n");
        }
        
        System.out.print(sb);
	}
}
