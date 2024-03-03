import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {
    static int N;
    static int M;
    static int D;
    static int [] row = { 0, -1, 0};
    static int [] col = {-1, 0, 1};
    static int [][] map;
    static int [][] copyMap;
    static int answer;
    static class protecter{
        int r;
        int c;
        int count;
        public protecter(int r, int c, int distance){
            this.r = r;
            this.c = c;
            this.count = distance;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        D = Integer.parseInt(input[2]);

        map = new int[N][M];
        int enemy = 0;
        int minRow = 15;
        for (int i=0; i<N; i++){
            String [] line = br.readLine().split(" ");
            for (int j=0;j<M; j++){
                if(line[j].equals("1")){
                    map[i][j] = 1;
                    enemy +=1;
                    minRow = Math.min(minRow, i);
                }
            }
        }

        for(int i=0; i<M; i++){
            for (int j=i+1; j<M; j++){
                for(int k= j+1; k<M; k++){
                    int count = 0;
                    copyMap = new int[N][M];
                    for(int r = 0; r<N; r++){
                        for (int c = 0; c<M; c++){
                            copyMap[r][c] = map[r][c];
                        }
                    }
                    for(int h = N; h>minRow; h--){


                        int [] enemy1 = findEnemy(h, i,h);
                        int [] enemy2 = findEnemy(h, j,h);
                        int [] enemy3 = findEnemy(h, k, h);
                        if(enemy1 != null){
                            copyMap[enemy1[0]][enemy1[1]] = 0;
                            count +=1;
                        }
                        if(enemy2 != null){
                            if(copyMap[enemy2[0]][enemy2[1]] != 0){
                                count +=1;
                            }
                            copyMap[enemy2[0]][enemy2[1]] = 0;
                        }

                        if(enemy3 != null){
                            if(copyMap[enemy3[0]][enemy3[1]] != 0){
                                count +=1;
                            }
                            copyMap[enemy3[0]][enemy3[1]] = 0;
                        }
                        if(h>=0 && h<N){
                            //System.out.println(" i 번 째 : "+i + Arrays.toString(copyMap[h]));
                        }

                    }
                    answer = Math.max(answer, count);


                }
            }
        }

        System.out.println(answer);


    }
    private static int[] findEnemy(int r, int c , int curH ){
        Queue<protecter> qp = new ArrayDeque<>();
        qp.add(new protecter(r,c,0));
        while(!qp.isEmpty()){
            protecter poll = qp.poll();
            int R = poll.r;
            int C = poll.c;

            for (int i=0; i<3; i++){
                int nexR = R + row[i];
                int nexC = C + col[i];
                if(nexR>=0 && nexR<N && nexC>=0 && nexC<M && nexR!=curH){
                    if(copyMap[nexR][nexC]== 1){
                        return new int[]{nexR,nexC};
                    }else if(poll.count+1 <= D-1) {
                        qp.add(new protecter(nexR, nexC, poll.count+1));
                    }
                }
            }


        }
        return null;
    }


}
