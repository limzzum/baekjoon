import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static long[] participants;
    static int[] parent;
    static long know;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        participants = new long[M];
        parent = new int[N+1];

        st = new StringTokenizer(br.readLine());
        int truth = Integer.parseInt(st.nextToken());
        if(truth == 0){
            System.out.println(M);
            return;
        }

        init();
        for (int i = 0; i < truth; i++) {
            int n = Integer.parseInt(st.nextToken());
            parent[n] = -1;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int people = Integer.parseInt(st.nextToken());
            int pre = Integer.parseInt(st.nextToken());
            participants[i] = 1L << pre;
            for (int j = 1; j < people; j++) {
                int n = Integer.parseInt(st.nextToken());
                participants[i] = participants[i] | 1L << n;
                union(pre, n);
            }

        }

        for (int i = 1; i <= N; i++) {
            if(parent[find(i)] == -1){
                know = know | 1L << i;
            }
        }

        int ans = 0;
        for (long participant : participants) {
            if((participant & know) == 0){
                ans += 1;
            }
        }

        System.out.println(ans);
    }

    private static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(parent[a] > parent[b]){
            int temp = parent[a];
            parent[a] = parent[b];
            parent[b] = temp;
        }
        parent[b] = parent[a];
    }

    private static int find(int a){
        if(parent[a] == a || parent[a] == -1){
            return a;
        }
        return parent[a] = find(parent[a]);
    }

    private static void init(){
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
    }

}
