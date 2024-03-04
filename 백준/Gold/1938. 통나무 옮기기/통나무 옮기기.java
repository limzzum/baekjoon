
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {
    static int[] row = {0, -1, 0, 1};
    static int[] col = {-1, 0, 1, 0};
    static int[] turnR = {-1, 1, 1, -1};
    static int[] turnC = {1,1, -1, -1};
    static char[][] map;
    static int N;
    static boolean[][][] visited;

    static class Pos{
        int r, c;
        boolean isGaro;
        int cnt;
        @Override
        public String toString() {
            return "Pos [r=" + r + ", c=" + c + ", isGaro=" + isGaro + ", cnt=" + cnt + "]";
        }
        public Pos(int r, int c, boolean isGaro, int cnt) {
            this.r = r;
            this.c = c;
            this.isGaro = isGaro;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Pos> queue = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        visited = new boolean[N][N][2];

        int n=1;
        Pos start = null;
        for(int i=0; i<N;i++) {
            map[i] = br.readLine().toCharArray();
            for(int j=0; j<map[i].length; j++) {
                if(map[i][j] =='B') {
                    if(n==2) {
                        if(j-1>=0 && map[i][j-1] =='B') {
                            start = new Pos(i,j,true, 0);
                        }else {
                            start = new Pos(i,j,false, 0);
                        }

                    }
                    n+=1;

                }
            }
        }

        if(start.isGaro) {
            visited[start.r][start.c][0] = true;
        }else {
            visited[start.r][start.c][1] = true;
        }
        queue.add(start);
        while(!queue.isEmpty()) {
            Pos poll = queue.poll();
            for(int i=0; i<4; i++) {
                int nr = poll.r + row[i];
                int nc = poll.c + col[i];
                if(poll.isGaro) {
                    if(nr <0 || nr >= N || nc <= 0 || nc >=N-1) {
                        continue;
                    }
                    if(visited[nr][nc][0]) {
                        continue;
                    }
                }else {
                    if(nr <= 0 || nr >= N-1 || nc < 0 || nc >=N) {
                        continue;
                    }
                    if(visited[nr][nc][1]) {
                        continue;
                    }
                }

                if(isArrive(nr, nc, poll.isGaro)) {
                    System.out.println(poll.cnt+1);
                    return;
                }
                if(poll.isGaro) {
                    visited[nr][nc][0] = true;
                }else {
                    visited[nr][nc][1] = true;
                }
                if(cango(nr, nc, poll.isGaro)) {
                    queue.add(new Pos(nr, nc, poll.isGaro, poll.cnt+1));

                }
            }

            int r = poll.r;
            int c = poll.c;
            if(poll.isGaro) {
                if(visited[r][c][1]) {
                    continue;
                }
                visited[r][c][0] = true;
            }else {
                if(visited[r][c][0]) {
                    continue;
                }
                visited[r][c][1] = true;
            }

            if(canTurn(r,c)) {
                if(isArrive(r, c, !poll.isGaro)) {
                    System.out.println(poll.cnt+1);
                    return;
                }
                if(poll.isGaro) {
                    visited[r][c][1] = true;
                }else {
                    visited[r][c][0] = true;
                }

                queue.add(new Pos(r, c, !poll.isGaro, poll.cnt+1));
            }


        }
        System.out.println(0);



    }
    private static boolean isArrive(int r, int c, boolean isGaro) {

        if(map[r][c] == 'E') {
            if(isGaro) {
                if(map[r][c-1]=='E' && map[r][c+1]=='E') {
                    return true;
                }
            }else {
                if(map[r-1][c]=='E' && map[r+1][c]=='E') {
                    return true;
                }
            }
        }

        return false;

    }

    private static boolean cango(int r, int c, boolean isGaro) {

        if(map[r][c] == '1') {
            return false;
        }

        if(isGaro) {
            if(map[r][c-1]=='1' || map[r][c+1]=='1') {
                return false;
            }
        }else {
            if(map[r-1][c]=='1' || map[r+1][c]=='1') {
                return false;
            }
        }
        return true;

    }
    private static boolean canTurn(int r, int c) {

        if(r-1 < 0 || r+1>=N || c-1<0 || c+1>=N) {
            return false;
        }

        if(map[r-1][c-1] == '1' || map[r-1][c] == '1' || map[r-1][c+1] == '1' ||
                map[r][c-1] == '1' ||map[r][c+1] == '1' ||
                map[r+1][c-1] == '1' || map[r+1][c] == '1' || map[r+1][c+1] == '1'
        ) {
            return false;
        }

        return true;

    }
}
