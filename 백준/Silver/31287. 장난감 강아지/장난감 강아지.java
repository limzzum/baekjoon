import java.util.*;
import java.io.*;

public class Main{
    
    static class Pos{
        
        int upDownCnt;
        int leftRightCnt;
        
        public Pos(int upDownCnt, int leftRightCnt){
            this.upDownCnt = upDownCnt;
            this.leftRightCnt = leftRightCnt;
        }
        
        @Override
        public boolean equals(Object obj){
            if(!(obj instanceof Pos)){
                return false;
            }
            
            Pos pos = (Pos) obj;
            return upDownCnt == pos.upDownCnt && leftRightCnt == pos.leftRightCnt;
        }
        
        @Override
        public int hashCode(){
            return Objects.hash(upDownCnt, leftRightCnt);
        }
    }
    
    static int N, K;
	static char[] directions;
	static int upDownCnt;
	static int leftRightCnt;
	static Set<Pos> poses = new HashSet<>();
	
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    N = Integer.parseInt(st.nextToken());
	    K = Math.min(1000, Integer.parseInt(st.nextToken()));
	    
	    directions = br.readLine().toCharArray();
	    
	    for(char direction : directions){
	        if(direction == 'U'){
	            upDownCnt += 1;
	        }else if(direction == 'D'){
	            upDownCnt -= 1;
	        }else if(direction == 'L'){
	            leftRightCnt += 1;
	        }else if(direction == 'R'){
	            leftRightCnt -= 1;
	        }
	        
	        poses.add(new Pos(upDownCnt, leftRightCnt));
	        
	        if(upDownCnt == 0 && leftRightCnt == 0){
	            System.out.print("YES");
	            return;
	        }
	    }
	    
        int upDown;
        int leftRight;
	    for(int i=1; i<K; i++){
	        upDown = upDownCnt * i;
	        leftRight = leftRightCnt * i;
	        if(poses.contains(new Pos(upDown * -1, leftRight * -1))){
	            System.out.print("YES");
	            return;
	        }
	    }

	    System.out.print("NO");
	    
	}    
}
