import java.util.*;
import java.io.*;

public class Main
{
    static int N, M, K;
    static int[][] map;
    static int[] count;
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    K = Integer.parseInt(st.nextToken());
	    map = new int[N][M];
	    count = new int[N];
	    for(int i=0; i<N; i++){
	        st = new StringTokenizer(br.readLine());
	        for(int j=0; j<M; j++){
	            map[i][j] = Integer.parseInt(st.nextToken());
	        }
	    }
	    
	    for(int i=0; i<M; i++){
	        for(int j=0; j<N; j++){
	            count[j] += map[j][i];
	            if(count[j] >= K){
	                System.out.print((j+1) +" "+(i+1));
	                return;
	            }
	        }
	    }

	}
}
