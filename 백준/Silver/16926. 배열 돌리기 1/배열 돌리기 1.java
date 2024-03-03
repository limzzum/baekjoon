import java.io.*;
import java.util.*;

public class Main{
    static int[] row = {0, 1, 0, -1};
    static int[] col = {1,0,-1,0};
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int R = Integer.parseInt(input[2]);

        int[][] map = new int[N][M];
        int[][] moved = new int[N][M];
        for(int i=0; i<N; i++){
            String [] line = br.readLine().split(" ");
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(line[j]);
            }
        }

        int cnt = Math.min(N, M) /2;

        int startR =0;
        int startC = 0;
        int maxR = N-1;
        int maxC = M-1;
        int mstartR = 0;
        int mstartC = 0;
        Queue<Integer> qp = new ArrayDeque<>();
        for(int i=0; i<cnt ; i++){
            int move = R % ((N-1)*2 + (M-1)*2);
            int idx = 0;
            while(true){
                qp.add(map[startR][startC]);
                startR = startR + row[idx];
                startC = startC + col[idx];
                if((startR == i && startC == maxC) || (startR == maxR && startC == maxC) || (startR == maxR && startC == i) || (startR ==i && startC == i)){
                    idx +=1;
                }
                if(idx==4){
                    break;
                }
            }
            for(int j= 0; j<move; j++){
                qp.add(qp.poll());
            }
            
            idx = 0;
           while(!qp.isEmpty()){
                moved[mstartR][mstartC] = qp.poll();
                mstartR = mstartR + row[idx];
                mstartC = mstartC + col[idx];
                if((mstartR == i && mstartC == maxC) || (mstartR == maxR && mstartC == maxC) || (mstartR == maxR && mstartC == i) || (mstartR ==i && mstartC == i)){
                    idx+=1;
                }
            }
            N -= 2;
            M -= 2;
            startR+=1;
            startC +=1;
            mstartR += 1;
            mstartC +=1;
            maxR -=1;
            maxC -=1;

        }

        for(int [] row: moved){
            for( int col : row){
                sb.append(col).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
