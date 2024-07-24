import java.util.*;
import java.io.*;

public class Main{
    
    static int N, M;
    static List<Integer>[] smaller;
    static List<Integer>[] bigger;
    static boolean[] isVisited;
    
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        smaller = new ArrayList[N+1];
        bigger = new ArrayList[N+1];
        
        for(int i=1; i<=N; i++){
            smaller[i] = new ArrayList<>();
            bigger[i] = new ArrayList<>();
        }
        StringTokenizer st;
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            smaller[a].add(b);
            bigger[b].add(a);
        }
    
        int cnt;
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++){
            cnt = 0;
            for(int j=1; j<=N; j++){
                if(i==j){
                    continue;
                }
                isVisited = new boolean[N+1];

                if(!isSmaller(i,j) && !isBigger(i,j)){
                    cnt += 1;
                }
            }
            sb.append(cnt).append("\n");
        }
        
        System.out.print(sb);
	}
	
	private static boolean isSmaller(int target, int num){
	    isVisited[target] = true;
	    
	    for(int small : smaller[target]){
	        if(small == num){
	            return true;
	        }
	        if(!isVisited[small] && isSmaller(small, num)){
	            return true;
	        }
	    }
	    
	    return false;
	}
	
	private static boolean isBigger(int target, int num){
	    isVisited[target] = true;
	    
	    for(int big : bigger[target]){
	        if(big == num){
	            return true;
	        }
	        if(!isVisited[big] && isBigger(big, num)){
	            return true;
	        }
	    }
	    return false;
	}

}
