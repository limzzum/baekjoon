import java.util.*;
import java.io.*;

public class Main {
    static int N, K;
    static Map<Integer, Integer> ices = new HashMap<>();
    
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		int G, X;
		for(int i=0; i<N; i++){
		    st = new StringTokenizer(br.readLine());
		    G = Integer.parseInt(st.nextToken());
		    X = Integer.parseInt(st.nextToken());
		    ices.put(X, G);
		}
		
		long[] sum = new long[1_000_000];
		sum[0] = ices.getOrDefault(0, 0);
		long answer = sum[0];
		for(int i=1; i<= sum.length-1; i++){
		    sum[i] = sum[i-1] + ices.getOrDefault(i,0);
		    if(i > K * 2 + 1){
		        answer = Math.max(answer, sum[i] - sum[i-(K*2 + 1)]);
		    }else {
		        answer = Math.max(answer, sum[i]);
		    }
		}
		System.out.print(answer);
	}
}
