import java.io.*;
import java.util.*;

public class Main{
    static int answer = Integer.MAX_VALUE;
    static int[] row = {0, 1, 0, -1};
    static int[] col = {-1, 0, 1, 0};
    static int N ;
    static int M;
    static int[][] map;
    static int[][] moved;
    static int[][] commands;
    static boolean[] used = new boolean[6];

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        int K  = Integer.parseInt(input[2]);

        map = new int[N][M];
        moved = new int[N][M];
        for(int i=0; i<N; i++){
            String [] line = br.readLine().split(" ");
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(line[j]);
            }
        }
        commands = new int[K][3];
        for(int i=0; i<K; i++) {
            String[] command = br.readLine().split(" ");
            int r = Integer.parseInt(command[0])-1;
            int c = Integer.parseInt(command[1])-1;
            int diff = Integer.parseInt(command[2]);
            commands[i] = new int[] {r,c,diff};

            //rotation(r-diff, c + diff, r+diff, c-diff);
        }
        dfs(new LinkedList<>());

        System.out.println(answer);
    }
    private static void dfs(List<Integer> com) {
    	if(com.size() == commands.length) {
    		for(int i=0; i<map.length; i++) {
    			for(int j= 0; j<map[i].length; j++) {
    				moved[i][j] = map[i][j];
    			}
    		}
    		for(int c: com) {
    			int r = commands[c][0];
    			int col = commands[c][1];
    			int diff = commands[c][2];
    			rotation(r-diff, col + diff, r+diff, col-diff);
    		}

    		 for(int[] m: moved ) {
    	        	int sum = 0;
    	        	for(int d: m) {
    	        		sum += d;
    	        	}
    	        	if(sum<answer) {
    	        		answer = sum;
    	        	}
    	        }
    		 return;
    	}
    	for(int i= 0; i<commands.length; i++) {
    		if(!used[i]) {
    			used[i] = true;
    			com.add(i);
    			dfs(com);
    			used[i] = false;
    			com.remove(com.size()-1);
    		}
    	}
    }
    private static void rotation(int startR, int startC, int endR, int endC) {
        Queue<Integer> qp = new ArrayDeque<>();
        int cnt = (Math.min(startC- endC, endR-startR)) /2;
        int maxR = endR;
        int maxC = startC;
        int mstartR = startR;
        int mstartC = startC;
        
        int minR = startR;
        int minC = endC;
       
        for(int i=0; i<cnt ; i++){
            int idx = 0;
           
            while(true){
                qp.add(moved[startR][startC]);
                startR = startR + row[idx];
                startC = startC + col[idx];
                if((startR == minR && startC == maxC) || (startR == maxR && startC == maxC) || (startR == maxR && startC == minC) || (startR ==minR && startC == minC)){
                    idx +=1;
                }
                if(idx==4){
                    break;
                }
            }
            qp.add(qp.poll());
            
            idx = 0;
            while(!qp.isEmpty()){
            	moved[mstartR][mstartC] = qp.poll();
                mstartR = mstartR + row[idx];
                mstartC = mstartC + col[idx];
                if((mstartR == minR && mstartC == maxC) || (mstartR == maxR && mstartC == maxC) || (mstartR == maxR && mstartC == minC) || (mstartR ==minR && mstartC == minC)){
                    idx+=1;
                }
            }
            startR+=1;
            startC -=1;
            mstartR += 1;
            mstartC -=1;
            maxR -=1;
            maxC -=1;
            minR += 1;
            minC += 1;
        }
    }
}