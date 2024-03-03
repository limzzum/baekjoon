import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static int answer;

    static enum DIR {

        ROW(0, 1),
        COL(1, 0),
        DIA(1, 1);
        private int r;
        private int c;

        DIR(int r, int c, DIR next) {
            this.r = r;
            this.c = c;
        }

        DIR(int r, int c) {
            this.r = r;
            this.c = c;
        }

        public int getR() {
            return this.r;
        }

        public int getC() {
            return this.c;
        }
    }

    static class Pipe {
        int r;
        int c;
        DIR dir;

        public Pipe(int r, int c, DIR dir) {
            this.r = r;
            this.c = c;
            this.dir = dir;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Pipe> queue = new ArrayDeque<>();

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(line[j]);
            }
        }

        queue.add(new Pipe(0, 1, DIR.ROW));

        while (!queue.isEmpty()) {
            Pipe poll = queue.poll();
            if (poll.dir.equals(DIR.ROW)) {
                int nexR = poll.r + DIR.ROW.r;
                int nexC = poll.c + DIR.ROW.c;

                if (isIn(nexR, nexC, false)) {
                    if (nexR == N - 1 && nexC == N - 1) {
                        answer += 1;
                    } else {
                        queue.add(new Pipe(nexR, nexC, DIR.ROW));
                    }
                }

                nexR = poll.r + DIR.DIA.r;
                nexC = poll.c + DIR.DIA.c;

                if (isIn(nexR, nexC, true)) {
                    if (nexR == N - 1 && nexC == N - 1) {
                        answer += 1;
                    } else {
                        queue.add(new Pipe(nexR, nexC, DIR.DIA));
                    }
                }
            } else if (poll.dir.equals(DIR.COL)) {
                int nexR = poll.r + DIR.COL.r;
                int nexC = poll.c + DIR.COL.c;

                if (isIn(nexR, nexC, false)) {
                    if (nexR == N - 1 && nexC == N - 1) {
                        answer += 1;
                    } else {
                        queue.add(new Pipe(nexR, nexC, DIR.COL));
                    }
                }

                nexR = poll.r + DIR.DIA.r;
                nexC = poll.c + DIR.DIA.c;

                if (isIn(nexR, nexC, true)) {
                    if (nexR == N - 1 && nexC == N - 1) {
                        answer += 1;
                    } else {
                        queue.add(new Pipe(nexR, nexC, DIR.DIA));
                    }
                }
            } else {
                int nexR = poll.r + DIR.ROW.r;
                int nexC = poll.c + DIR.ROW.c;

                if (isIn(nexR, nexC, false)) {
                    if (nexR == N - 1 && nexC == N - 1) {
                        answer += 1;
                    } else {
                        queue.add(new Pipe(nexR, nexC, DIR.ROW));
                    }
                }

                nexR = poll.r + DIR.COL.r;
                nexC = poll.c + DIR.COL.c;

                if (isIn(nexR, nexC, false)) {
                    if (nexR == N - 1 && nexC == N - 1) {
                        answer += 1;
                    } else {
                        queue.add(new Pipe(nexR, nexC, DIR.COL));
                    }
                }

                nexR = poll.r + DIR.DIA.r;
                nexC = poll.c + DIR.DIA.c;

                if (isIn(nexR, nexC, true)) {
                    if (nexR == N - 1 && nexC == N - 1) {
                        answer += 1;
                    } else {
                        queue.add(new Pipe(nexR, nexC, DIR.DIA));
                    }
                }
            }


        }

        System.out.println(answer);


    }

    private static boolean isIn(int r, int c, boolean doubleCheck) {
        if (r >= 0 && r < N && c >= 0 && c < N) {
            if (map[r][c] == 0) {
                if (doubleCheck && !(map[r - 1][c] == 0 && map[r][c - 1] == 0)) {
                    return false;
                }
                return true;
            }

        }
        return false;
    }
}
