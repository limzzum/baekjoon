import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Node{
        int r,c;
        int dist;

        public Node(int r, int c, int dist){
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }

    static int N, M;
    static int[] row = {0, -1, 0, 1};
    static int[] col = {-1, 0, 1, 0};

    static int[][] map;
    static int[][] answer;
    static boolean[][] isVisited;
    static int startR, startC;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Node> queue = new ArrayDeque<>();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        answer = new int[N][M];
        isVisited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j] == 2){
                    startR = i;
                    startC = j;
                    answer[i][j] = 0;
                }else if(map[i][j] == 1){
                    answer[i][j] = -1;
                }else if(map[i][j] == 0){
                    answer[i][j] = 0;
                }
            }
        }


        queue.add(new Node(startR, startC, 0));
        isVisited[startR][startC] = true;

        while (!queue.isEmpty()){
            Node poll = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nr = poll.r + row[i];
                int nc = poll.c + col[i];

                if(nr< 0 || nr >=N || nc<0 || nc>=M){
                    continue;
                }
                if(isVisited[nr][nc] || map[nr][nc] == 0){
                    continue;
                }

                isVisited[nr][nc] = true;
                answer[nr][nc] = poll.dist + 1;
                queue.add(new Node(nr, nc, poll.dist + 1));

            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }


    }
}
