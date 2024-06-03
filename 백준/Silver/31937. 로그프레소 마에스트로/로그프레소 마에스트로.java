import java.util.*;
import java.io.*;

public class Main{
    
    static class Send{
        int time;
        int from;
        int to;
        public Send(int time, int from, int to){
            this.time = time;
            this.from = from;
            this.to = to;
        }
    }
    
    static int N, M, K;
    static Set<Integer> virused = new HashSet<>();
    static List<Send> sends = new ArrayList<>();
    static boolean[] isVirused;
    
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    K = Integer.parseInt(st.nextToken());
	    
	    st = new StringTokenizer(br.readLine());
	    for(int i=0; i<K; i++){
	        virused.add(Integer.parseInt(st.nextToken()));
	    }
	    
	    for(int i=0; i<M; i++){
	        st = new StringTokenizer(br.readLine());
	        sends.add(new Send(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
	    }
	    
	    sends.sort(Comparator.comparing(a -> a.time));
	    for(int computer : virused){
	        isVirused = new boolean[N+1];
            isVirused[computer] = true;
	        if(isStartComputer(computer)){
	            System.out.print(computer);
	            return;
	        }
	    }
	    
	}
	private static boolean isStartComputer(int computer){
	    int cnt = 1;
	    for(Send send : sends){
	        if(isVirused[send.from]){
	            if(!virused.contains(send.to)){
	                return false;
	            }
	            
	            if(!isVirused[send.to]){
	                cnt += 1;
	                isVirused[send.to] = true;
	            }
	        }
	    }
	    return virused.size() == cnt;
	}

}
