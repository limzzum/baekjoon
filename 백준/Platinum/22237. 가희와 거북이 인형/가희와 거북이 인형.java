import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
 * 거북이 위치를 입력받고, 장애물이 있다면, 거북이 인형들과 장애물과의 거리를 구해
 * 2차원 배열로 부딪히게 되는 거리를 표시한다.
 * bfs 탐색을 하며 장애물과 부딪히는지 확인하고, 최단거리 경로를 구한다.
 * */
public class Main {

    public static class Pos{
        int r, c;
        public Pos(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    static class Turtle{
        int r, c;
        int sumR, sumC;
        StringBuilder sb;
        public Turtle(int r, int c, int sumR, int sumC, StringBuilder sb){
            this.r = r;
            this.c = c;
            this.sumR = sumR;
            this.sumC = sumC;
            this.sb = sb;
        }
    }

    static Pos endPoint;
    static boolean[][][] isHome;
    static boolean[][][] isBarrier;
    static boolean[][] visited;
    static int[] row = {0, -1, 0, 1};
    static int[] col = {1, 0, -1, 0};
    static String [] dir = {"R", "U", "L", "D"};
    static int minRow, maxRow, minCol, maxCol;
    static int R, C;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        R = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);

        isBarrier = new boolean[4][R+1][C+1];
        isHome = new boolean[4][R][C];
        visited = new boolean[R][C];
        minRow = R;
        minCol = C;


        List<Pos> barrier = new ArrayList<>();
        List<Pos> turtle = new ArrayList<>();
        char[] line;
        for (int i = 0; i < R; i++) {
            line = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                if(line[j] == 'H'){
                    endPoint = new Pos(i,j);
                }
                if(line[j] == '#'){
                    barrier.add(new Pos(i,j));
                }
                if(line[j] == 'T'){
                    turtle.add(new Pos(i,j));
                    if(i<minRow){
                        minRow = i;
                    }
                    if(j<minCol){
                        minCol = j;
                    }
                    if(i>maxRow){
                        maxRow = i;
                    }
                    if(j>maxCol){
                        maxCol = j;
                    }
                }
            }
        }

        for (int i = 0; i < turtle.size(); i++) {
            int r = endPoint.r - turtle.get(i).r;
            int c = endPoint.c - turtle.get(i).c;
            isHome[getIdx(r,c)][Math.abs(r)][Math.abs(c)] = true;
            for (int j = 0; j < barrier.size(); j++) {
                int diffR = barrier.get(j).r - turtle.get(i).r;
                int diffC = barrier.get(j).c - turtle.get(i).c;

                int aR = Math.abs(diffR);
                int aC = Math.abs(diffC);
                int idx = getIdx(diffR, diffC);
                isBarrier[idx][aR][aC] = true;

            }
        }

        Queue<Turtle> queue = new ArrayDeque<>();

        queue.add(new Turtle(turtle.get(0).r, turtle.get(0).c, 0, 0, new StringBuilder()));

        visited[turtle.get(0).r][turtle.get(0).c] = true;
        while (!queue.isEmpty()){
            Turtle poll = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nr = poll.r + row[i];
                int nc = poll.c + col[i];
                int sumR = poll.sumR + row[i];
                int sumC = poll.sumC + col[i];
                int idx = getIdx(sumR, sumC);

                if(!isin(sumR, sumC)){
                    continue;
                }

                if(isBarrier[idx][Math.abs(sumR)][Math.abs(sumC)] ||
                        visited[nr][nc] ){
                    continue;
                }

                int aR = Math.abs(sumR);
                int aC = Math.abs(sumC);

                if(isHome[idx][aR][aC]){
                    System.out.println(poll.sb.append(dir[i]));
                    return;
                }

                visited[nr][nc] = true;
                StringBuilder newSb = new StringBuilder(poll.sb);
                newSb.append(dir[i]);
                queue.add(new Turtle(nr, nc, sumR, sumC, newSb));
            }
        }

        System.out.println(-1);

    }
    private static int getIdx(int r, int c){
        if(r<0 && c<0){
            return 3;
        }
        if(r<0){
            return 1;
        }
        if(c<0){
            return 2;
        }
        return 0;
    }

    private static boolean isin(int sumR, int sumC){

        if(sumR <= (minRow +1) * -1 || sumR >= R -maxRow || sumC <= (minCol + 1)*-1 || sumC >= C - maxCol){
            return false;
        }
        return true;
    }
}
