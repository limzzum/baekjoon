import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Pos {

        int r;
        int c;

        public Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int N;
    static int M;
    static int[][] map;
    static boolean[][] isVisited;
    static int totalCnt;
    static int[] selected;
    static List<Pos> virus = new ArrayList<>();
    static Queue<Pos> queue = new ArrayDeque<>();
    static final int[] row = {0, -1, 0, 1};
    static final int[] col = {-1, 0, 1, 0};
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        selected = new int[M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    virus.add(new Pos(i, j));
                } else if (map[i][j] == 0) {
                    totalCnt += 1;
                }
            }
        }

        if(totalCnt == 0){
            System.out.println(0);
            return;
        }

        comb(0, 0);
        if (answer == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }
        System.out.println(answer);

    }

    private static void comb(int start, int n) {
        if (n == M) {
            isVisited = new boolean[N][N];
            spreadVirus();
            return;
        }

        for (int i = start; i < virus.size(); i++) {
            selected[n] = i;
            comb(i + 1, n + 1);
        }
    }

    private static void spreadVirus() {
        for (int i : selected) {
            Pos pos = virus.get(i);
            isVisited[pos.r][pos.c] = true;
            queue.add(pos);
        }

        int day = 0;
        int cnt = 0;
        int size = queue.size();
        while (size != 0) {
            day += 1;
            for (int i = 0; i < size; i++) {
                Pos poll = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int nr = poll.r + row[j];
                    int nc = poll.c + col[j];

                    if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
                        continue;
                    }
                    if (map[nr][nc] == 1 || isVisited[nr][nc]) {
                        continue;
                    }
                    isVisited[nr][nc] = true;
                    queue.add(new Pos(nr, nc));
                    if(map[nr][nc] == 0){
                        cnt += 1;
                    }

                }

            }
            if (cnt == totalCnt) {
                answer = Math.min(answer, day);
                queue.clear();
                break;
            }
            size = queue.size();
        }

    }

}
