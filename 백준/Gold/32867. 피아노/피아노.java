import java.util.*;
import java.io.*;

public class Main{
    
    private static int N, K;
    private static int answer;

	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int n;
        int min = 200000;
        int max = 0;
        for(int i=0; i<N; i++){
            n = Integer.parseInt(st.nextToken());
            min = Math.min(min, n);
            max = Math.max(max, n);
            if(max - min >= K){
                answer += 1;
                min = n;
                max = n;
            }
        }
        System.out.print(answer);
	}
}
