import java.util.*;
import java.io.*;

public class Main{
    
    static int A, B, X;
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());
            sb.append(A*(X-1)+B).append("\n");
        }
        System.out.print(sb);
	}

}
