import java.util.*;
import java.io.*;

public class Main{
    
    static int N;
 
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int a;
        int b;
        StringBuilder sb = new StringBuilder();
        while((a = Integer.parseInt(st.nextToken())) != 0){
            b = Integer.parseInt(st.nextToken());
            sb.append(a+b).append("\n");
            st = new StringTokenizer(br.readLine());
        }
        
        System.out.print(sb);
	}
}
