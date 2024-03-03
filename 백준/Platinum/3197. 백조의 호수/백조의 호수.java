import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 물 공간의 구역을 나눈다.
 * 구역별 코드를 부여해서 구분하고 구역별 dfs 탐색을 통해 가장자리를 녹인다.
 * union & find 알고리즘을 사용해 구역을 통합하고, 백조가 있던 두 구역이 통합되면 백조가 만날 수 있다.
 * 백조가 있던 구역의 parent 코드가 같아지면 통합된 것임을 확인할 수 있다.
 * 백조가 있는 구역의 코드는 가장 높은 코드 두 개로 초기화 시켜주고 통합할 때는 높은 코드를 바라보게 한다.
 * */

public class Main {

    static class Pos {

        int r;
        int c;

        public Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static char[][] map;
    static int R;
    static int C;
    static final int[] row = {0, -1, 0, 1};
    static int[] col = {-1, 0, 1, 0};
    static int day = 1;
    static List<Pos> baekzoo = new ArrayList<>();
    static int[][] areaMap;
    static int code;
    static int[] parent;
    static Queue<Pos> areas = new ArrayDeque<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        if ((R <= 2 && C < 2) || (R < 2 && C <= 2)) {
            System.out.println(0);
            return;
        }

        map = new char[R][C];
        areaMap = new int[R][C];
        parent = new int[R * C];

        List<Pos> waters = new ArrayList<>();

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                if (map[i][j] != 'X') {
                    waters.add(new Pos(i, j));
                    if (map[i][j] == 'L') {
                        baekzoo.add(new Pos(i, j));
                    }
                }
            }
        }

        for (Pos water : waters) {
            if (areaMap[water.r][water.c] != 0) {
                continue;
            }
            code += 1;
            areaMap[water.r][water.c] = code;
            divideArea(water);
        }

        for (int i = 1; i <= code; i++) {
            parent[i] = i;
        }
        if (isSameParent()) {
            System.out.println(0);
            return;
        }

        while (!areas.isEmpty()) {
            int size = areas.size();
            for (int i = 0; i < size; i++) {
                Pos poll = areas.poll();
                for (int j = 0; j < 4; j++) {
                    int nr = poll.r + row[j];
                    int nc = poll.c + col[j];

                    if (nr < 0 || nr >= R || nc < 0 || nc >= C) {
                        continue;
                    }
                    if (map[nr][nc] == 'X') {
                        map[nr][nc] = '.';
                        areaMap[nr][nc] = parent[areaMap[poll.r][poll.c]];
                        int nnr = nr + row[j];
                        int nnc = nc + col[j];
                        if (nnr >= 0 && nnr < R && nnc >= 0 && nnc < C && map[nnr][nnc] == '.') {
                            union(areaMap[poll.r][poll.c], areaMap[nnr][nnc]);
                        } else {
                            areas.add(new Pos(nr, nc));
                            continue;
                        }
                    }

                    union(areaMap[poll.r][poll.c], areaMap[nr][nc]);
                    if (isSameParent()) {
                        System.out.println(day);
                        return;
                    }

                }
            }

            day += 1;

        }


    }

    private static void divideArea(Pos pos) {
        areas.add(pos);
        for (int i = 0; i < 4; i++) {
            int nr = pos.r + row[i];
            int nc = pos.c + col[i];

            if (nr < 0 || nr >= R || nc < 0 || nc >= C) {
                continue;
            }

            if (map[nr][nc] == 'X' || areaMap[nr][nc] == code) {
                continue;
            }

            areaMap[nr][nc] = code;
            divideArea(new Pos(nr, nc));

        }
    }

    private static int find(int code) {
        if (parent[code] == code) {
            return code;
        }
        return parent[code] = find(parent[code]);

    }

    private static void union(int a, int b) {
        if (find(a) == find(b)) {
            return;
        }

        if (parent[a] > parent[b]) {
            int temp = a;
            a = b;
            b = temp;
        }

        parent[parent[a]] = parent[b];

    }

    private static boolean isSameParent() {
        Pos baek1 = baekzoo.get(0);
        Pos baek2 = baekzoo.get(1);
        if (find(areaMap[baek1.r][baek1.c]) == find(areaMap[baek2.r][baek2.c])) {
            return true;
        }
        return false;
    }

}
