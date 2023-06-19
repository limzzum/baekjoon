import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/*
* 방문체크를 열쇠를 가지고 있는 경우의 수에 따라 해주어야 하므로
* 비트마스킹을 사용하여 각 열쇠의 유무에 대한 방문 체크를 해준다.
* 입력에 나온 모든 열쇠를 사용할 필요가 있다면 단순히 크기 비교로 방문여부를 체크할 수도 있지만
* 필요없는 열쇠가 있을 수 있기 때문에 크기는 작아도 각 열쇠를 가진 경우의 수가 다르다면 다시 방문할 수 있도록 해야한다.
*
* --- 틀렸습니다 원인
* 방문체크를 하면서 들고있던 키를 계속 누적해서 더해주기만 했는데 a , b 따로 하나씩 가지고 지나간 곳을
* a,b두 개 동시에 들고 지나갈 수 있어야 하는데 a,b 둘 다 가지고 있던 것으로 방문체크를 이미 해버려서 지나가지 못했다.
* 방문체크를 3차원 배열로 다시 설정하여 모든 경우에 대해 체크할 수 있도록 한다.
* */
public class Main {
    static char[][] map;
    static int N,M;
    static boolean[][][] isVisitedKey;
    static boolean[][] isVisited;
    static int[] row = {0, -1, 0, 1};
    static int[] col = {-1, 0, 1, 0};
    static String keys = "abcdef";
    static String door = "ABCDEF";

    static class Minsick{
        int r,c;
        int bitKey;
        int cnt;
        public Minsick(int r, int c, int bitKey, int cnt){
            this.r = r;
            this.c = c;
            this.bitKey = bitKey;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Minsick> queue = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        isVisitedKey = new boolean[N][M][(int) Math.pow(2,6)*2];
        isVisited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String [] input = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = input[j].charAt(0);
                if(map[i][j]=='0'){
                    queue.add(new Minsick(i,j,0,0));
                    map[i][j] = '.';
                    isVisited[i][j] = true;
                }
            }
        }
        if(N==1 && M==1){
            System.out.println(0);
            return;
        }
        
        int nr;
        int nc;
        while (!queue.isEmpty()){
            Minsick poll = queue.poll();
            for (int i = 0; i < 4; i++) {
                nr = poll.r + row[i];
                nc = poll.c + col[i];
                if(!canGo(nr, nc, poll.bitKey)){
                    continue;
                }
                if(map[nr][nc]=='1'){
                    System.out.println(poll.cnt+1);
                    return;
                }
                int nBitKey=poll.bitKey;
                if(keys.contains(String.valueOf(map[nr][nc]))){
                    nBitKey = poll.bitKey | (1 << map[nr][nc] - 'a');
                }
                isVisited[nr][nc] = true;
                isVisitedKey[nr][nc][nBitKey] = true;
                queue.add(new Minsick(nr,nc, nBitKey, poll.cnt+1 ));
            }
        }
        System.out.println(-1);
    }
    private static boolean canGo(int r, int c, int curkeys){

        if(r>=N || r<0 || c>=M || c<0){
            return false;
        }
        if(map[r][c]=='#'){
            return false;
        }
        if(isVisited[r][c] && curkeys == 0){
            return false;
        }
        if(door.contains(String.valueOf(map[r][c]))){
            if((curkeys & (1 << map[r][c]-'A')) == 0){
                return false;
            }
        }
        if(!isVisited[r][c]){
            return true;
        }
        if(!isVisitedKey[r][c][curkeys]){
            return true;
        }
        return false;
    }
}
