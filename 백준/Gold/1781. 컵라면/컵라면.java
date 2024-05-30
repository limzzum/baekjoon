import java.util.*;
import java.io.*;

public class Main{
    
    static class Problem{
        int presentCnt;
        int deadLine;
        public Problem(int deadLine, int presentCnt){
            this.presentCnt = presentCnt;
            this.deadLine = deadLine;
        }
    }
    static int N;
    static boolean[] isSelected;
    static Queue<Problem> pq = new PriorityQueue<>(Comparator.comparing(a-> -a.presentCnt));
    
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        isSelected = new boolean[N+1];
        
        StringTokenizer st;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            pq.add(new Problem(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        
        int answer = 0;
        while(!pq.isEmpty()){
            Problem problem = pq.poll();
            if(isPossible(problem.deadLine)){
                answer += problem.presentCnt;
            }
        }
        
        System.out.print(answer);
        
	}
	
	private static boolean isPossible(int deadLine){
	    for(int i= deadLine; i>=1; i--){
	        if(!isSelected[i]){
	            return isSelected[i] = true;
	        }
	    }
	    return false;
	}
}
