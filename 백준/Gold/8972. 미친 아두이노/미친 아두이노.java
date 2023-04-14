import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 이동할 방향을 입력받아서 저장.
 * 번호를 인덱스로 하여 delta 이동 배열 선언
 * map 을 입력받고 미친 아두이노 위치를 배열로 저장
 * 아두이노를 이동시킨 후 미친 아두이노들이 이동할 방향을 찾아 이동시켜줌.
 * boolean배열로 이동한 후의 위치인지 구분
 * 이동한 곳이 이미 다른 미친아두이노가 이동한 곳이면 다시 배열에 추가 x 이미 추가 해준 미친 아두이노 삭제.
 * removed 배열을 추가해 이미 방문했던 곳이고, 삭제도 해주었으면 삭제는 패스하고 추가만 x
 * 이동 전에 현재 위치를 '.'으로 초기화해주어야 하는데 다른 미친아두이노가 방문한 기록이 있으면 초기화 하면 안됨.
 * 만약 아두이노를 잡으면 이동한 횟수 출력 후 종료.
 * 이동이 끝나면 현재 맵 상태 출력.
 * */
public class Main {
    static int R,C;
    static char[][] map;
    static boolean[][] visited;
    static boolean[][] removed;
    static Queue<Pos> michins = new ArrayDeque<>();
    static int curR, curC;
    static int[] row = {0, 1, 1, 1, 0, 0, 0, -1, -1, -1};
    static int[] col = {0, -1, 0, 1, -1, 0, 1, -1, 0, 1};

    static class Pos{
        int r,c;
        public Pos(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        R = Integer.parseInt(tokenizer.nextToken());
        C = Integer.parseInt(tokenizer.nextToken());

        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                if(map[i][j] == 'R'){
                    michins.add(new Pos(i,j));
                }
                if(map[i][j]=='I'){
                    curR = i;
                    curC = j;
                }
            }
        }
        char[] input = br.readLine().toCharArray();
        int[] move = new int[input.length];
        for (int i = 0; i < move.length; i++) {
            move[i] = input[i]-'0';
        }

        for (int i = 0; i < move.length; i++) {
            if(!moveAdino(move[i])){
                System.out.println("kraj "+(i+1));
                return;
            }

            if(!moveMichinAdino()){
                System.out.println("kraj "+(i+1));
                return;
            }

        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                bw.write(map[i][j]);
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
    private static boolean moveAdino(int dir){
        int nr = curR +row[dir];
        int nc = curC +col[dir];

        if(map[nr][nc]=='R'){
            return false;
        }
        map[curR][curC] = '.';
        map[nr][nc] = 'I';
        curR = nr;
        curC = nc;
        return true;
    }

    private static boolean moveMichinAdino(){
        visited = new boolean[R][C];
        removed = new boolean[R][C];
        int size = michins.size();

        for (int i = 0; i < size; i++) {
            Pos pos = michins.poll();

            int mvIdx = getMvIndex(pos.r, pos.c);

            int nr = pos.r + row[mvIdx];
            int nc = pos.c + col[mvIdx];

            if (map[nr][nc] =='I') {
                return false;
            }
            if(!visited[pos.r][pos.c]){
                map[pos.r][pos.c] = '.';
            }

            if (visited[nr][nc]) {
                if (!removed[nr][nc]) {
                    remove(nr, nc, size-i-1);
                    removed[nr][nc] = true;
                    map[nr][nc] = '.';
                }
                continue;
            }

            map[nr][nc] = 'R';
            michins.add(new Pos(nr,nc));
            visited[nr][nc] = true;
        }
        return true;
    }
    private static int getMvIndex(int r, int c){
        if(curR == r){
            if(curC < c){
                return 4;
            }
            if(curC > c){
                return 6;
            }
        }
        if(curR > r){
            if(curC < c){
                return 1;
            }
            if(curC == c){
                return 2;
            }
            if(curC > c){
                return 3;
            }
        }
        else{
            if(curC< c){
                return 7;
            }
            if(curC == c){
                return 8;
            }
            if(curC > c){
                return 9;
            }
        }
        return 5;
    }
    private static void remove(int r, int c, int low){
        int size = michins.size();
        for (int i = 0; i < size; i++) {
            Pos poll = michins.poll();
            if(i>= low && poll.r == r && poll.c == c){
                continue;
            }
            michins.add(poll);
        }
    }
}
