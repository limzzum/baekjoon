import java.util.*;
import java.io.*;

public class Main{
    
    static int N, M;
    static char[][] origin;
    static char[][] reversed;

    
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	    StringTokenizer st = new StringTokenizer(br.readLine());
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    origin = new char[N][M];
	    reversed = new char[N][M];
	    
	    for(int i=0; i<N; i++){
	        origin[i] = br.readLine().toCharArray();
	    }
	    
	    StringBuilder sb = new StringBuilder();
	    for(int i=0; i<N; i++){
	        for(int j=0; j<M; j++){
	            reversed[i][M-j-1] = origin[i][j];
	        }
	        sb.append(String.valueOf(reversed[i])).append("\n");
	    }

        System.out.print(sb);
	}
}
