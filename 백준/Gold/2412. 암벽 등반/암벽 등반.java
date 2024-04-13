import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Main{
    
    static class Pos{
        int x;
        int y;
        int cnt;
        public Pos(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    static Map<Integer, Map<Integer, Boolean>> map = new HashMap();
    static Queue<Pos> queue = new ArrayDeque();
    static final int[] dx = {-2, -1, 0, 1, 2};
    
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    int N = Integer.parseInt(st.nextToken());
	    int T = Integer.parseInt(st.nextToken());
	    
	    for(int i=0; i<N; i++){
	        st = new StringTokenizer(br.readLine());
	        int x = Integer.parseInt(st.nextToken());
	        int y = Integer.parseInt(st.nextToken());
	        map.putIfAbsent(x, new HashMap());
            map.get(x).put(y, true);
	    }
	    
	    queue.add(new Pos(0, 0, 0));
	    
	    while(!queue.isEmpty()){
	        Pos pos = queue.poll();
	        if(pos.y == T){
	            System.out.println(pos.cnt);
	            return;
	        }
	        for(int i=0; i<5; i++){
	            Map<Integer, Boolean> heights = map.get(pos.x + dx[i]);
	            if(heights == null){
	                continue;
	            }
	            for(int j=0; j<5; j++){
	                if(heights.get(pos.y + dx[j]) != null){
	                    queue.add(new Pos(pos.x + dx[i], pos.y + dx[j], pos.cnt + 1));
	                    heights.put(pos.y + dx[j], null);
	                }
	            }
	        }
	    }
	    System.out.println(-1);
	}
}
