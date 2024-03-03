import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {

    static int[] row = {0, 0, 1, -1};
    static int[] col = {1, -1, 0, 0};
    static String[][] map;
    static Queue<Water> waters;
    static int N;
    static int M;

    static class Dochi {
        int r;
        int c;
        int time;

        public Dochi(int r, int c, int time) {
            this.r = r;
            this.c = c;
            this.time = time;
        }
    }

    static class Water {
        int r;
        int c;

        public Water(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Dochi> queue = new ArrayDeque<>();
        waters = new ArrayDeque<>();
        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        map = new String[N][M];

        for (int i = 0; i < N; i++) {
            input = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = input[j];
                if (map[i][j].equals("S")) {
                    queue.add(new Dochi(i, j, 0));
                    map[i][j] = "v";
                }
                if (map[i][j].equals("*")) {
                    waters.add(new Water(i, j));
                }
            }
        }

        while (!queue.isEmpty()) {
            flood();
            int size = queue.size();
            for (int k = 0; k < size; k++) {

                Dochi poll = queue.poll();

                for (int i = 0; i < 4; i++) {
                    int nr = poll.r + row[i];
                    int nc = poll.c + col[i];
                    if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;

                    if (map[nr][nc].equals("D")) {
                        System.out.println(poll.time + 1);
                        return;
                    }
                    if (map[nr][nc].equals(".")) {
                        map[nr][nc] = "v";
                        queue.add(new Dochi(nr, nc, poll.time + 1));
                    }

                }

            }
        }

        System.out.println("KAKTUS");

    }

    private static void flood() {
        int waterCnt = waters.size();
        for (int i=0; i<waterCnt; i++){
            Water poll = waters.poll();
            for (int j = 0; j < 4; j++) {
                int nr = poll.r + row[j];
                int nc = poll.c + col[j];
                if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
                if(map[nr][nc].equals(".") || map[nr][nc].equals("v")){
                    map[nr][nc] = "*";
                    waters.add(new Water(nr,nc));
                }

            }
        }
    }

}
