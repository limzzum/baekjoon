import java.util.*;
import java.io.*;

public class Main{
    
    static int[][] map;
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    int N = Integer.parseInt(br.readLine());
	    
	    map = new int[N][N];
	    
	    for(int i=0; i<N; i++){
	        st = new StringTokenizer(br.readLine());
	        for(int j=0; j<N; j++){
	            map[i][j] = Integer.parseInt(st.nextToken());
	        }
	    }
	    
	    List<Integer> nums = new ArrayList();
	    for(int i=0; i<N; i++){
	        nums.add(map[N-1][i]);
	    }
	    Collections.sort(nums);
	    
	    for(int i=0; i<N; i++){
	        for(int j=N-2; j>=0; j--){
	            if(map[j][i] > nums.get(0)){
	                nums.set(0, map[j][i]);
	                Collections.sort(nums);
	            }else{
	                break;
	            }
	        }
	    }
	    
	    System.out.println(nums.get(0));
	}
}
