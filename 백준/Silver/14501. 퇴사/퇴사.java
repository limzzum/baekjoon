import java.util.*;
import java.io.*;

public class Main{
    
    static class Node{
        int T;
        int P;
        public Node(int T, int P){
            this.T = T;
            this.P = P;
        }
    }
    static int N;
    static List<Node> nodes = new ArrayList<>();
    static int answer;

	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    N = Integer.parseInt(br.readLine());
	    StringTokenizer st;
	    for(int i=0; i<N; i++){
	        st = new StringTokenizer(br.readLine());
	        nodes.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
	    }
	    dfs(0, 0);
	    System.out.print(answer);
	}
	
	private static void dfs(int start, int sum){
	    if(start <= N){
	        answer = Math.max(answer, sum);
	    }
	    if(start>= N){
	        return;
	    }

	    dfs(start + 1, sum);
	    dfs(start + nodes.get(start).T, sum + nodes.get(start).P);
	}	
	
}
