import java.util.*;
import java.io.*;

public class Main{
    
    private static int N, M;
    private static int answer;

	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N-M; i++){
            sb.append(i).append(" ").append(i+1).append("\n");
        }
        
        for(int i=0; i<M-1; i++){
            sb.append(N-M).append(" ").append(N-1-i).append("\n");
        }
        
        System.out.print(sb);
	}
}
