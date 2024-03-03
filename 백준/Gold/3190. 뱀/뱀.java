import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int [][] map;
    static int [] row = {0, -1, 0, 1};
    static int [] col = {-1, 0, 1, 0};
    static int time = 0;

    static class Snake{
        int r;
        int c;
        int dir;
        Queue<int[]> qp = new ArrayDeque<>();
        public Snake(int r, int c, int dir){
            this.r = r;
            this.c = c;
            this.dir = dir;
            qp.add(new int[]{0,0});
        }
        public boolean move(){
            int nexR = r+row[dir];
            int nexC = c+col[dir];

            if(nexR<0 || nexR>=N || nexC<0 || nexC>=N){
//                System.out.println("벽");
                return false;
            }
            if(map[nexR][nexC]==2){
//                System.out.println("뱀");
                return false;
            }


            if(map[nexR][nexC] == 0 && !qp.isEmpty()){
                int[] poll = qp.poll();
                map[poll[0]][poll[1]] = 0;
            }
            r = nexR;
            c = nexC;
            map[nexR][nexC] = 2;
            qp.add(new int[]{nexR,nexC});
            return true;
        }

    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        int K = Integer.parseInt(br.readLine());
        for(int i=0; i<K; i++){
            String[] line = br.readLine().split(" ");
            int r = Integer.parseInt(line[0])-1;
            int c = Integer.parseInt(line[1])-1;
            map[r][c] = 1;
        }

        int L = Integer.parseInt(br.readLine());
        Snake snake = new Snake(0,0,2);
        for (int i=0; i<L; i++){
            String [] line = br.readLine().split(" ");
            int T = Integer.parseInt(line[0]);
            int a = time;

            for(int j=a; j<T; j++){

                time+=1;
                if(!snake.move()){
                    System.out.println(time);
                    return;
                }

            }
            if(line[1].equals("L")){

                snake.dir = (snake.dir+3)%4;
            }else{

                snake.dir = (snake.dir+5)%4;
            }

        }

        time+=1;
        while (snake.move()){
            time+=1;
        }
        System.out.println(time);
    }
}
