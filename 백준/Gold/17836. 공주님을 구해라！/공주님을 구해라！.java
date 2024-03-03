import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int [] row = {0, -1, 0, 1};
    static int [] col = {-1, 0, 1, 0};
    static int [][] map;
    static class Yongsa{
        int r,c;
        int time;

        boolean hasGum;
        public Yongsa(int r, int c, int time,  boolean hasGum){
            this.r = r;
            this.c = c;
            this.time = time;
            this.hasGum = hasGum;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Yongsa> queue = new ArrayDeque<>();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        queue.add(new Yongsa(0,0, 0, false));
        map[0][0] = 4;
        while (!queue.isEmpty()){
            Yongsa poll = queue.poll();
            poll.time += 1;
            for (int i=0; i<4; i++){
                int nr = poll.r + row[i];
                int nc = poll.c + col[i];

                if(nr == N-1 && nc == M-1){
                    System.out.println(poll.time);
                    return;
                }
                if(poll.time >= T){
                    continue;
                }
                if(poll.time>T){
                    System.out.println("Fail");
                    return;
                }
                if(nr<0 || nr>=N || nc<0 || nc>=M || map[nr][nc] == 4 || (map[nr][nc] == 3 && !poll.hasGum) ){
                    continue;
                }
                if(map[nr][nc]==1 && !poll.hasGum){
                    continue;
                }
                if(map[nr][nc]==2){
                    queue.add(new Yongsa(nr,nc, poll.time, true));
                }else{
                    queue.add(new Yongsa(nr,nc, poll.time, poll.hasGum));
                }
                if(poll.hasGum){
                    map[nr][nc] = 4;
                }else{
                    map[nr][nc] = 3;
                }

            }
        }
        System.out.println("Fail");


    }
}
