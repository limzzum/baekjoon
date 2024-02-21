import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Pos {

        int r;
        int c;
        int k;
        int dist;

        public Pos(int r, int c, int k, int dist) {
            this.r = r;
            this.c = c;
            this.k = k;
            this.dist = dist;
        }
    }

    static int N, M, K;
    static int[][] map;
    static int[][] visited;
    static final int[] row = {0, -1, 0, 1};
    static final int[] col = {-1, 0, 1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Pos> pq = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (N == 1 && M == 1) {
            System.out.println(1);
            return;
        }

        map = new int[N][M];
        visited = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        pq.add(new Pos(0, 0, K+1, 1));
        visited[0][0] = K + 1;
        while (!pq.isEmpty()) {
            Pos poll = pq.poll();
            for (int i = 0; i < 4; i++) {
                int nr = poll.r + row[i];
                int nc = poll.c + col[i];

                if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
                    continue;
                }
                if (visited[nr][nc] != 0 && visited[nr][nc] >= poll.k) {
                    continue;
                }
                if (nr == N - 1 && nc == M - 1) {
                    System.out.println(poll.dist + 1);
                    return;
                }

                if (map[nr][nc] == 0) {
                    visited[nr][nc] = poll.k;
                    pq.add(new Pos(nr, nc, poll.k, poll.dist + 1));
                } else if (map[nr][nc] == 1 && poll.k > 1) {
                    if(poll.dist % 2== 1){
                        visited[nr][nc] = poll.k;
                        pq.add(new Pos(nr, nc, poll.k - 1, poll.dist + 1));
                    }else {
                        pq.add(new Pos(poll.r, poll.c, poll.k, poll.dist + 1));
                    }
                }
            }
        }
        System.out.println(-1);

    }

}
