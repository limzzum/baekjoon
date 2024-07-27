import java.util.*;
import java.io.*;

public class Main{
    
    static class Container{
        int robot;
        int available;
        
        public Container(int available){
            this.available = available;
        }
        public void removeRobot(){
            robot -= 1;
        }
        public void removeRobot(int cnt){
            robot -= cnt;
        }

        public boolean addRobot(){
            if(robot >= 1 || available == 0){
                return false;
            }
            robot += 1;
            available -= 1;
            if(available == 0){
                zeroCnt += 1;
            }
            return true;
        }
        
        public void up(){
            if(available == 0){
                return;
            }
            robot += 1;
            available -= 1;
            if(available == 0){
                zeroCnt += 1;
            }
        }
        
        public void clear(){
            robot = 0;
        }
    }
    static int N, K;
    static List<Container> containers = new ArrayList<>();
    static int zeroCnt;
    static int start;

	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N*2; i++){
            containers.add(new Container(Integer.parseInt(st.nextToken())));
        }
        
        int level = 0;
        while(zeroCnt < K){
            level += 1;
            rotate();
            move();
            containers.get(start).up();
        }
        System.out.print(level);
        
	}
	
	private static void rotate(){
	    start = (start + 2*N - 1) % (2*N);
	    containers.get((start + N -1)% (2*N)).clear();
	}
	
	private static void move(){
	    int frontIdx = (start + N-2) % (N*2);
	    int backIdx = (frontIdx + 1) % (N*2);
	    int cnt = Math.min(containers.get(frontIdx).robot, containers.get(backIdx).available);
	       if(cnt != 0){
	           containers.get(frontIdx).removeRobot(cnt);
	           containers.get(backIdx).available -= cnt;
	           if(containers.get(backIdx).available == 0){
	               zeroCnt += 1;
	           }
	       }
	           
	    for(int i= N-3; i>=0; i--){
	       frontIdx = (start + i) % (N*2);
	       backIdx = (frontIdx + 1) % (N*2);
	       if(containers.get(frontIdx).robot >= 1 && containers.get(backIdx).addRobot()){
	           containers.get(frontIdx).removeRobot();
	       }
	    }
	}
}
