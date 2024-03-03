import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int N;
    static int M;
    static int[] row = { -1, -1, 0, 1, 1, 1, 0, -1};
    static int[] col = {0, 1, 1, 1, 0, -1, -1, -1};
    static FireBall[][] map;
    static int[][] countFireBall;

    static class Shark{
        Queue<FireBall> fireBalls;
        public Shark(){
            fireBalls = new LinkedList<>();
        }
        public void addFireBalls(FireBall fireBall){
            fireBalls.add(fireBall);
        }
        public void moveFireBall() {
            for (int i=0; i<N; i++){
                for (int j=0; j<N; j++){
                    if(countFireBall[i][j]== 1){
                        fireBalls.add(map[i][j]);
                        map[i][j] = null;
                    }else if(countFireBall[i][j] >1){
                        int m = map[i][j].m / 5;
                        int s = map[i][j].s / countFireBall[i][j];
                        if(m !=0){
                            if(map[i][j].d == 0 || map[i][j].d == countFireBall[i][j]){

                                fireBalls.add(new FireBall(i, j, m, s, 0));
                                fireBalls.add(new FireBall(i, j, m, s, 2));
                                fireBalls.add(new FireBall(i, j, m, s, 4));
                                fireBalls.add(new FireBall(i, j, m, s, 6));
                            }else{
                                fireBalls.add(new FireBall(i, j, m, s, 1));
                                fireBalls.add(new FireBall(i, j, m, s, 3));
                                fireBalls.add(new FireBall(i, j, m, s, 5));
                                fireBalls.add(new FireBall(i, j, m, s, 7));
                            }
                        }
                        map[i][j] = null;
                    }
                    countFireBall[i][j] = 0;
                }
            }

            while (!fireBalls.isEmpty()){
                FireBall fireBall = fireBalls.poll();
                // countFireBall[fireBall.r][fireBall.c]-=1;
                int dist = fireBall.s % N;
                fireBall.r = (fireBall.r + row[fireBall.d]* dist) % N;
                fireBall.c = (fireBall.c + col[fireBall.d]* dist) % N;
                if(fireBall.r<0){
                    fireBall.r += N;
                }
                if(fireBall.c<0){
                    fireBall.c += N;
                }
                if(countFireBall[fireBall.r][fireBall.c]>0){
                    FireBall ball = map[fireBall.r][fireBall.c];
                    ball.m += fireBall.m;
                    ball.s += fireBall.s;
                    if(countFireBall[fireBall.r][fireBall.c] == 1){
                        ball.d = ball.d % 2 + fireBall.d % 2;
                    }else{
                        ball.d += fireBall.d % 2;
                    }

                }else{
                    map[fireBall.r][fireBall.c] = fireBall;
                }
                countFireBall[fireBall.r][fireBall.c] +=1;
            }
        }
    }
    static class FireBall{
        int r;
        int c;

        @Override
        public String toString() {
            return "FireBall{" +
                    "r=" + r +
                    ", c=" + c +
                    ", m=" + m +
                    ", s=" + s +
                    ", d=" + d +
                    '}';
        }

        int m, s, d;

        public FireBall(int r, int c, int m, int s, int d){
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        int K = Integer.parseInt(input[2]);

        map = new FireBall[N][N];
        countFireBall = new int[N][N];

        Shark shark = new Shark();
        for(int i=0; i<M; i++){
            String[] line = br.readLine().split(" ");
            int r = Integer.parseInt(line[0])-1;
            int c = Integer.parseInt(line[1])-1;
            int m = Integer.parseInt(line[2]);
            int s = Integer.parseInt(line[3]);
            int d = Integer.parseInt(line[4]);
            FireBall fireBall = new FireBall(r,c,m,s,d);
            map[r][c] = fireBall;
            countFireBall[r][c] =1;
        }
        for (int i=0; i<K; i++){
            shark.moveFireBall();
        }

        int sum = 0;
        for(int i=0; i<N; i++){
            for (int j=0; j<N; j++){
                if(countFireBall[i][j] == 1){
                    sum += map[i][j].m;
                }else if(countFireBall[i][j] >1) {
                    sum += (map[i][j].m / 5) * 4;
                }
            }
        }
        System.out.println(sum);
    }
}