import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int S = 1;
    static int [] tree;

    static class Player{
        int rank;
        int talent;
        public Player(int rank, int talent){
            this.rank = rank;
            this.talent = talent;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        while (S < N){
            S *= 2;
        }

        List<Player> players = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            players.add( new Player(i+1, num));
        }

        Collections.sort(players,Comparator.comparing(o->o.talent));

        //좌표압축
        int talent = 1;
        for (Player player:players){
            player.talent = talent;
            talent += 1;
        }

        Collections.sort(players, Comparator.comparing(o -> o.rank));

        tree = new int[S*2];

        for (int i = 0; i < N; i++) {
            int idx = players.get(i).talent + S -1;
            tree[idx] += 1;
            update(idx/2);
            int count = getCount(1, 1, S, players.get(i).talent + 1, S) + 1;
            sb.append(count).append("\n");
        }
        System.out.println(sb);

    }
    private static void update(int idx){
        tree[idx] = tree[idx * 2] + tree[idx * 2 + 1];
        if(idx == 1){
            return;
        }
        update(idx/2);
    }
    private static int getCount(int cur, int startIdx, int endIdx, int targetStartIdx, int targetEndIdx){
        if(startIdx > targetEndIdx || endIdx < targetStartIdx){
            return 0;
        }
        if(startIdx>= targetStartIdx && endIdx <= targetEndIdx){
            return tree[cur];
        }
        int mid = (startIdx + endIdx) / 2;
        int left = getCount(cur * 2, startIdx, mid, targetStartIdx, targetEndIdx);
        int right = getCount(cur * 2 + 1, mid + 1, endIdx, targetStartIdx, targetEndIdx);
        return left + right;
    }
}
