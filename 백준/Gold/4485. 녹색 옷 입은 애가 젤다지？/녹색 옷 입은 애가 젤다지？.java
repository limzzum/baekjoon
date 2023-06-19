import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[][] dp;
    static int[][] map;
    static int[] row = {0, -1, 0, 1};
    static int[] col = {-1, 0, 1, 0};

    static class Pos{
        int r, c;
        int loss;
        public Pos(int r, int c, int loss){
            this.r = r;
            this.c = c;
            this.loss = loss;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        Queue<Pos> pq = new PriorityQueue<>(new Comparator<Pos>() {
            @Override
            public int compare(Pos o1, Pos o2) {
                return Integer.compare(o1.loss,o2.loss);
            }
        });

        int idx = 1;
        while (true){
            N = Integer.parseInt(br.readLine());
            if(N==0){
                break;
            }
            dp = new int[N][N];
            map = new int[N][N];

            for (int i = 0; i < N; i++) {
                Arrays.fill(dp[i],Integer.MAX_VALUE);
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            pq.add(new Pos(0,0,map[0][0]));
            while (!pq.isEmpty()){
                Pos poll = pq.poll();
                int nr, nc;
                for (int i = 0; i < 4; i++) {
                    nr = poll.r + row[i];
                    nc = poll.c + col[i];
                    if(isIn(nr,nc)){
                        if(nr == N-1 && nc == N-1){
                            dp[nr][nc] = Math.min(dp[nr][nc],poll.loss+map[nr][nc]);
                            continue;
                        }

                        if(dp[nr][nc]<= poll.loss+ map[nr][nc]){
                            continue;
                        }
                        dp[nr][nc] = poll.loss + map[nr][nc];
                        if(dp[nr][nc]<dp[N-1][N-1]){
                            pq.add(new Pos(nr, nc, dp[nr][nc]));
                        }

                    }
                }
            }
            sb.append("Problem ").append(idx).append(": ").append(dp[N-1][N-1]).append("\n");
            idx += 1;
        }
        System.out.println(sb);

    }

    private static boolean isIn(int r, int c){
        if(r<0 || r>=N || c<0 || c>=N){
            return false;
        }
        return true;
    }
}
