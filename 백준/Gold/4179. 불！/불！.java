import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    enum Type{
        PERSON, FIRE;
    }
    static class Node {
        int x;
        int y;
        int time;
        Type type;
        public Node(int x, int y, int time, Type type){
            this.x = x;
            this.y = y;
            this.time = time;
            this.type = type;
        }
    }

    static class Pos {
        int x;
        int y;
        public Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int R;
    static int C;
    static char[][] map;
    static int[] row = {0, -1, 0, 1};
    static int[] col = {-1, 0, 1, 0};
    static boolean[][] isVisited;
    static List<Node> fires = new ArrayList<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Node> queue = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        isVisited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                if(map[i][j] == 'J') {
                    queue.add(new Node(i, j, 1, Type.PERSON));
                    isVisited[i][j] = true;
                }else if(map[i][j] == 'F'){
                    fires.add(new Node(i, j, 0, Type.FIRE));
                }
            }
        }

        queue.addAll(fires);

        while (!queue.isEmpty()){
            Node poll = queue.poll();
            if(poll.type == Type.PERSON){
                if(map[poll.x][poll.y] == 'F'){
                    continue;
                }
                if(poll.x == 0 || poll.x == R-1 || poll.y == 0 || poll.y == C -1){
                    System.out.println(poll.time);
                    return;
                }
                for (int i = 0; i < 4; i++) {
                    int nr = poll.x + row[i];
                    int nc = poll.y + col[i];

                    if(isVisited[nr][nc] || map[nr][nc] == 'F'){
                        continue;
                    }
                    isVisited[nr][nc] = true;
                    if(map[nr][nc] == '.'){
                        queue.add(new Node(nr, nc, poll.time + 1, Type.PERSON));
                    }
                }
            }else {
                for (int i = 0; i < 4; i++) {
                    int nr = poll.x + row[i];
                    int nc = poll.y + col[i];
                    if (nr < 0 || nr >= R || nc < 0 || nc >= C) {
                        continue;
                    }
                    if(map[nr][nc] == 'F' || map[nr][nc] == '#'){
                        continue;
                    }
                    isVisited[nr][nc] = true;
                    map[nr][nc] = 'F';
                    queue.add(new Node(nr, nc, 0, Type.FIRE));
                }
            }

        }
        System.out.println("IMPOSSIBLE");
    }

}
