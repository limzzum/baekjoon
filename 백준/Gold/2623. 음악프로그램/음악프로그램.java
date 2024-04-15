import java.util.*;
import java.io.*;

public class Main{
    
    static int N, M;
    static int[] frontCnt;
    static List<List<Integer>> outList = new ArrayList();
    static StringBuilder sb = new StringBuilder();
    
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    frontCnt = new int[N];

	    for(int i=0; i<N; i++){
	        outList.add(new ArrayList());
	    }
	    
	    int cnt;
	    int pre;
	    int num;
	    for(int i=0; i<M; i++){
	        st = new StringTokenizer(br.readLine());
	        cnt = Integer.parseInt(st.nextToken());
	        pre = Integer.parseInt(st.nextToken()) - 1;
	        
	        for(int j=1; j<cnt; j++){
	            num = Integer.parseInt(st.nextToken()) -1;
	            frontCnt[num] += 1;
	            outList.get(pre).add(num);
	            pre = num;
	        }
	    }
	    
	    int totalCnt = 0;
	    while(true){
	        cnt = 0;
	        for(int i=0; i<N; i++){
	            if(frontCnt[i] == 0){
	                cnt += 1;
	                totalCnt += 1;
	                order(i);
	                if(totalCnt == N){
	                    System.out.println(sb);
                        return;
	                }
	            }
	        }
	        if(cnt == 0){
	            System.out.println(0);
	            return;
	        }
	    }
	}
	
	private static void order(int n){
        sb.append(n+1).append("\n");
        for(int i=0; i<outList.get(n).size(); i++){
            frontCnt[outList.get(n).get(i)] -= 1;
        }
        frontCnt[n] = -1;
	}
}
