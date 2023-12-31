import java.io.*;

public class Main {

    static int R, C;
    static int [] row = {0, -1, 0, 1};
    static int [] col = {-1, 0, 1, 0};
    static char[][] map;
    static boolean[] isVisited = new boolean[30];
    static int answer = 0;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String [] input = br.readLine().split(" ");
        R = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);
        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }


        dfs(0,0,1);
        System.out.println(answer);


    }

    private static void dfs(int r, int c, int cnt){
        int index = map[r][c] - 'A';

        isVisited[index] = true;
        for (int i = 0; i < 4; i++) {
            int nr = r + row[i];
            int nc = c + col[i];
            if(nr < 0 || nr >= R || nc < 0 || nc >= C){
                answer = Math.max(answer, cnt);
                continue;
            }
            int nIndex = map[nr][nc] - 'A';
            if(isVisited[nIndex]){
                answer = Math.max(answer, cnt);
                continue;
            }

            dfs(nr, nc, cnt+1);
        }
        isVisited[index] = false;


    }
}
