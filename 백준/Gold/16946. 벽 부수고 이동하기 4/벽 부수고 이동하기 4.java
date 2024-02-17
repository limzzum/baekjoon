import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] map;
    static int[] row = {0, -1, 0, 1};
    static int[] col = {-1, 0, 1, 0};
    static int[][] areaMap;
    static int[] areaCnt;
    static int areaCode;
    static Queue<int[]> queue = new ArrayDeque<>();
    static Set<Integer> areas = new HashSet<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        areaMap = new int[N][M];
        areaCnt = new int[N * M];

        int wallCnt = 0;
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
                if (map[i][j] == 1) {
                    wallCnt += 1;
                }
            }
        }
        if (wallCnt == 0) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    System.out.print(0);
                }
                System.out.println();
            }
            return;
        }

        if (wallCnt == 1) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 0) {
                        System.out.print(0);
                    } else {
                        System.out.print((N*M) % 10);
                    }
                }
                System.out.println();
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0 && areaMap[i][j] == 0) {
                    areaCode += 1;
                    areaMap[i][j] = areaCode;
                    queue.add(new int[]{i,j});
                    areaCnt[areaCode] = visitArea();
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    sb.append("0");
                } else {
                    sb.append((getCnt(i, j)) % 10);
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static int visitArea() {
        int cnt = 0;
        while (!queue.isEmpty()){
            int[] poll = queue.poll();
            cnt += 1;
            for (int i = 0; i < 4; i++) {
                int nr = poll[0] + row[i];
                int nc = poll[1] + col[i];

                if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
                    continue;
                }
                if (map[nr][nc] == 0 && areaMap[nr][nc] == 0) {
                    areaMap[nr][nc] = areaCode;
                    queue.add(new int[]{nr,nc});
                }
            }
        }
        return cnt;
    }

    private static int getCnt(int r, int c) {
        int cnt = 1;
        for (int i = 0; i < 4; i++) {
            int nr = r + row[i];
            int nc = c + col[i];

            if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
                continue;
            }
            if (areaMap[nr][nc] != 0) {
                areas.add(areaMap[nr][nc]);
            }
        }

        for (Integer area : areas) {
            cnt += areaCnt[area];
        }
        areas.clear();
        return cnt;
    }

}
