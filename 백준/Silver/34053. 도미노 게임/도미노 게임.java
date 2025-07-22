import java.io.*;
import java.util.*;

public class Main{
    static int N, M;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		long sum = 0;
		int min = Integer.MAX_VALUE;
		
		int n;
		for(int i=0; i<N; i++){
		    st = new StringTokenizer(br.readLine());
		    for(int j=0; j<M; j++){
		        n = Integer.parseInt(st.nextToken());
		        min = Math.min(min, n);
		        sum += n;
		    }
		}
		if(min == 0){
		    System.out.println(sum);
		    return;
		}
		System.out.println(sum-min);
	}
}
