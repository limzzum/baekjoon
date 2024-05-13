import java.util.*;
import java.io.*;

public class Main{
    
    static class GasStation{
        int n;
        long price;
        public GasStation(int n, long price){
            this.n = n;
            this.price = price;
        }
    }
    
    static int N;
    static int[] sum;
    static int min;
    static long answer;
    
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    PriorityQueue<GasStation> pq = new PriorityQueue<GasStation>(Comparator.comparing(a -> a.price));
	    N = Integer.parseInt(br.readLine());
	    sum = new int[N];
	    min = N-1;
	    
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    sum[0] = 0;
	    for(int i=1; i<N; i++){
	        sum[i] = sum[i-1] + Integer.parseInt(st.nextToken());
	    }
	    
	    st = new StringTokenizer(br.readLine());
	    for(int i=0; i<N; i++){
	        pq.add(new GasStation(i, Long.parseLong(st.nextToken())));
	    }
	    
	    while(!pq.isEmpty()){
	        GasStation gasStation = pq.poll();
	        if(gasStation.n >= min){
	            continue;
	        }
	        
	        int distance = sum[min] - sum[gasStation.n];
	        answer += gasStation.price * distance;
	        min = gasStation.n;
	        
	        if(min == 0){
	            break;
	        }
	    }
	    System.out.print(answer);
	}
}
