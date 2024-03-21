import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Main{
    
    static int[][] map;
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    PriorityQueue<Integer> queue = new PriorityQueue();
	    StringTokenizer st;
	    int N = Integer.parseInt(br.readLine());
	    
	    map = new int[N][N];
	    
	    for(int i=0; i<N; i++){
	        st = new StringTokenizer(br.readLine());
	        for(int j=0; j<N; j++){
	            map[i][j] = Integer.parseInt(st.nextToken());
	        }
	    }
	    
	    for(int i=0; i<N; i++){
	        queue.add(map[N-1][i]);
	    }

	    for(int i=0; i<N; i++){
	        for(int j=N-2; j>=0; j--){
	            if(map[j][i] > queue.peek()){
	               queue.poll();
	               queue.add(map[j][i]);
	            }else{
	                break;
	            }
	        }
	    }
	    
	    System.out.println(queue.peek());
	}
}
