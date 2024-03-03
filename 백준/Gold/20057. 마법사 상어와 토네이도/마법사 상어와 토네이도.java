import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] row = {0, 1, 0, -1};
    static int[] col = {-1, 0, 1, 0};
    static int[] turnLeftR = {0, 1, 0, -1};
    static int[] turnLeftC = {-1, 0, 1, 0};
    static int dir = 3;
    static int answer = 0;
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        for (int i=0; i<N; i++){
            String [] line = br.readLine().split(" ");
            for (int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(line[j]);
            }
        }
        int startR = N/2;
        int startC = N/2;
        visited[startR][startC] = true;
        move(startR, startC);

        System.out.println(answer);
    }

    private static void move(int r, int c){

        while (r!=0 || c!=0) {
            int leftR = r + row[(dir+1) % 4];
            int leftC = c + col[(dir+1) % 4];

            if (leftR>=0 && leftR<N && leftC>=0 && leftC<N && !visited[leftR][leftC]) {
                r = leftR;
                c = leftC;
                dir = (dir+1) % 4;
            }else{
                r += row[dir];
                c += col[dir];
            }
            
            visited[r][c] = true;
            tornado(dir, r, c);
            map[r][c] = 0;
        }
    }
    private static void tornado(int dir, int r, int c){
        double morae = map[r][c]/100.0;

        int p10 = (int) (morae * 10);
        int p7 = (int) (morae * 7);
        int p5 = (int) (morae * 5);
        int p2 = (int) (morae * 2);
        int p1 = (int) morae;
        int remain = (map[r][c] - ((p10+p7+p2+p1)*2 + p5));

        if(dir == 0){
            isIn(r-1, c-1, p10);
            isIn(r-1, c, p7);
            isIn(r-2, c, p2);
            isIn(r-1, c+1, p1);

            isIn(r+1, c-1, p10);
            isIn(r+1, c, p7);
            isIn(r+2, c, p2);
            isIn(r+1, c+1, p1);

            isIn(r, c-1, remain);
            isIn(r, c-2, p5);

        }else if(dir == 1){
            isIn(r+1, c-1, p10);
            isIn(r, c-1, p7);
            isIn(r, c-2, p2);
            isIn(r-1, c-1, p1);

            isIn(r+1, c+1, p10);
            isIn(r, c+1, p7);
            isIn(r, c+2, p2);
            isIn(r-1, c+1, p1);

            isIn(r+1, c, remain);
            isIn(r+2, c, p5);
        }else if(dir == 2){

            isIn(r-1, c-1, p1);
            isIn(r-1, c, p7);
            isIn(r-2, c, p2);
            isIn(r-1, c+1, p10);

            isIn(r+1, c-1, p1);
            isIn(r+1, c, p7);
            isIn(r+2, c, p2);
            isIn(r+1, c+1, p10);

            isIn(r, c+1, remain);
            isIn(r, c+2, p5);

        }else if(dir == 3){

            isIn(r+1, c-1, p1);
            isIn(r, c-1, p7);
            isIn(r, c-2, p2);
            isIn(r-1, c-1, p10);

            isIn(r+1, c+1, p1);
            isIn(r, c+1, p7);
            isIn(r, c+2, p2);
            isIn(r-1, c+1, p10);

            isIn(r-1, c, remain);
            isIn(r-2, c, p5);
        }
    }
    private static void isIn(int r, int c, int morae){
        if(r>=0 && r<N && c>=0 && c<N){
            map[r][c] += morae;
            return;
        }
        answer += morae;
    }
}
