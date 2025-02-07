import java.util.*;
import java.io.*;

public class Main{
    
    private static int N;

	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        sb.append(2*N -1).append("\n");
        for(int i=0; i<N-1; i++){
            sb.append(N*i+i+1).append(" ").append(N*i+i+N).append(" ")
                .append(i+1).append(" ").append(1).append("\n");
        }
        
        for(int i=0; i<N-1; i++){
            sb.append(N*(i+1) + 1 + i).append(" ").append(N*(i+1) + 1 + i).append(" ")
                .append(N).append(" ").append(i+2).append("\n");
        }
        
        sb.append(N*N).append(" ").append(N*N).append(" ")
            .append(N).append(" ").append(1);
            
        System.out.print(sb);
	}
	
}
