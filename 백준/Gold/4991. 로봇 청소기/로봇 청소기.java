import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static String[][] map;
    static int N;
    static int M;
    static int startR;
    static int startC;
    static int [] row = {0, -1, 0, 1};
    static int [] col = {-1, 0, 1, 0};
    static List<Dust> dusts;
    static int[][] costs;
    static int[] startCosts;
    static boolean[] used;
    static int result;

    static class Dust{
        int r;
        int c;
        int cnt;
        public Dust(int r, int c){
            this.r = r;
            this.c = c;
        }
        public Dust(int r, int c, int cnt){
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String[] input = br.readLine().split(" ");
            N = Integer.parseInt(input[1]);
            M = Integer.parseInt(input[0]);
            map = new String[N][M];
            result = N*M+1;

            if(N ==0 && M==0){
                break;
            }
            dusts = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                map[i] = br.readLine().split("");
                for (int j = 0; j < M; j++) {
                    if (map[i][j].equals("o")) {
                        startR = i;
                        startC = j;
                        map[i][j] = ".";
                    }
                    if (map[i][j].equals("*")) {
                        dusts.add(new Dust(i,j));
                    }
                }
            }
            int len = dusts.size();
            used = new boolean[len];
            costs = new int[len][len];
            startCosts = new int[len];
            for(int i=0; i<len; i++){
                startCosts[i] = getDistance(new Dust(startR,startC), dusts.get(i));
            }
            for (int i=0; i<len; i++){
                for (int j=0; j<len; j++){
                    if(i==j){
                        continue;
                    }
                    costs[i][j] = getDistance(dusts.get(i), dusts.get(j));
                }
            }

            getOrder(0,new int[len]);
            if(result == N*M +1){
                sb.append(-1).append("\n");
            }else{
                sb.append(result).append("\n");
            }

        }
        System.out.println(sb);
    }

    public static void getOrder(int idx, int[] answer ) {
        if(idx == dusts.size()){
            int cost = startCosts[answer[0]];
            if(cost == -1){
                return;
            }
            for (int i=0; i<answer.length-1; i++){
                if(costs[answer[i]][answer[i+1]]== -1){
                    return;
                }
                cost += costs[answer[i]][answer[i+1]];
            }
            result = Math.min(result, cost);
            return;
        }
        for (int i=0; i<dusts.size(); i++){
            if(!used[i]){
                used[i] = true;
                answer[idx] = i;
                getOrder(idx+1, answer);
                used[i] = false;
            }
        }
    }

    private static int getDistance(Dust startD, Dust endD){
        Queue<Dust> qp = new ArrayDeque<>();
        qp.add(startD);

        boolean[][] visited = new boolean[N][M];
        while (!qp.isEmpty()){
            Dust poll = qp.poll();
            for (int i=0; i<4; i++){
                int nexR = poll.r + row[i];
                int nexC = poll.c + col[i];
                if(nexR >=0 && nexR<N && nexC>=0 && nexC<M){
                    if(nexR == endD.r && nexC == endD.c){
                        return poll.cnt + 1;
                    }
                    if(!visited[nexR][nexC] && !map[nexR][nexC].equals("x")){
                        visited[nexR][nexC] = true;
                        qp.add(new Dust(nexR, nexC, poll.cnt+1));
                    }
                }

            }

        }
        return -1;
    }
}
