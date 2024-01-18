import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static abstract class Pos {
        int r;
        int c;
        public Pos(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    
    static class Person extends Pos{
        int time;
        public Person(int x, int y, int time) {
            super(x, y);
            this.time = time;
        }
    }

    static class Fire extends Pos{
        public Fire(int r, int c) {
            super(r, c);
        }
    }

    static int R;
    static int C;
    static char[][] map;
    static int[] row = {0, -1, 0, 1};
    static int[] col = {-1, 0, 1, 0};
    static boolean[][] isVisited;
    static List<Pos> fires = new ArrayList<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Pos> queue = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        isVisited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                if(map[i][j] == 'J') {
                    queue.add(new Person(i, j, 1));
                    isVisited[i][j] = true;
                }else if(map[i][j] == 'F'){
                    fires.add(new Fire(i, j));
                }
            }
        }

        queue.addAll(fires);

        while (!queue.isEmpty()){
            Pos poll = queue.poll();
            if(poll instanceof Person){
                Person person = (Person) poll;
                if(map[person.r][person.c] == 'F'){
                    continue;
                }
                if(person.r == 0 || person.r == R-1 || person.c == 0 || person.c == C -1){
                    System.out.println(person.time);
                    return;
                }
                for (int i = 0; i < 4; i++) {
                    int nr = person.r + row[i];
                    int nc = person.c + col[i];

                    if(isVisited[nr][nc] || map[nr][nc] == 'F'){
                        continue;
                    }
                    isVisited[nr][nc] = true;
                    if(map[nr][nc] == '.'){
                        queue.add(new Person(nr, nc, person.time + 1));
                    }
                }
            }else {
                for (int i = 0; i < 4; i++) {
                    int nr = poll.r + row[i];
                    int nc = poll.c + col[i];
                    if (nr < 0 || nr >= R || nc < 0 || nc >= C) {
                        continue;
                    }
                    if(map[nr][nc] == 'F' || map[nr][nc] == '#'){
                        continue;
                    }
                    isVisited[nr][nc] = true;
                    map[nr][nc] = 'F';
                    queue.add(new Fire(nr, nc));
                }
            }

        }
        System.out.println("IMPOSSIBLE");
    }

}
