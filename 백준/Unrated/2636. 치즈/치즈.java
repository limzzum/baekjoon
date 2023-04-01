import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    static int N;
    static int M;
    static int[][] map;
    static int[] row = {0, -1, 0 , 1};
    static int[] col = {-1, 0, 1, 0};
    static int cheeseCnt;
    static boolean [][] visited;

    static class Pos{
        int r, c;
        public Pos(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Pos> queue = new ArrayDeque<>();
        String [] line = br.readLine().split(" ");

        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);

        map = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(input[j]);
                if(map[i][j] == 1){
                    cheeseCnt +=1;
                }
            }
        }

        int hour = 0;
        int preCnt = cheeseCnt;
        while (cheeseCnt>0) {
            visited = new boolean[N][M];
            queue.add(new Pos(hour,hour));
            preCnt = cheeseCnt;
            while (!queue.isEmpty()) {
                Pos poll = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int nr = poll.r + row[i];
                    int nc = poll.c + col[i];
                    if (nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc]) {
                        visited[nr][nc] = true;
                        if (map[nr][nc] == 1) {
                            map[nr][nc] = 0;
                            cheeseCnt -= 1;
                        } else {
                            queue.add(new Pos(nr, nc));
                        }
                    }
                }
            }
            hour+=1;
        }

        System.out.println(hour);
        System.out.println(preCnt);

    }
}
