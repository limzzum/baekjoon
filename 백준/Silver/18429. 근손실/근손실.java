import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	  static int N;
	  static int K;
	  static int answer;
	  static int[] kits;
	  static boolean[] visited;
	  public static void main(String [] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        String[] input = br.readLine().split(" ");
	        N = Integer.parseInt(input[0]);
	        K = Integer.parseInt(input[1]);
	        String [] line = br.readLine().split(" ");
	        kits = new int[N];
	        visited = new boolean[N];
	        for(int i=0; i<N; i++) {
	        	kits[i] = Integer.parseInt(line[i]);
	        }
	        
	        dfs(500, 0);
	        System.out.println(answer);
	  
	  }
	  private static void dfs(int sum,int cnt) {
		  if(cnt == N) {
			  answer +=1;
			  return;
		  }
		  sum -= K;	
		  for(int i=0; i<N; i++) {
			  	 
			  if(!visited[i] && sum+kits[i]>=500) {
				  visited[i] = true;
				  dfs(sum+kits[i], cnt+1);
				  visited[i] = false;
			  }
			  
		  }
	  }
}
