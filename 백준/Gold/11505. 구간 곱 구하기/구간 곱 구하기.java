import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int MOD = 1_000_000_007;
    static int N;
    static int M;
    static int K;
    static int S = 1;
    static long [] tree;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        while (S < N){
            S *= 2;
        }

        tree = new long[S*2];

        for (int i = 0; i < N; i++) {
            tree[S+i] = Integer.parseInt(br.readLine());
        }
        for (int i = S+N; i <S*2; i++) {
            tree[i] = 1;
        }
        for (int i = S-1; i >0 ; i--) {
            tree[i] = (tree[i*2] * tree[i*2 + 1]) % MOD;
        }

        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(a == 1){
                tree[S+b-1] = c;
                update((S+b-1)/2);
            }
            if(a==2){
                long multi = getMulti(1, 1, S, b, c);
                sb.append(multi).append("\n");
            }
        }
        System.out.println(sb);
        
    }
    
    private static void update(int index){
        tree[index] = (tree[index*2] * tree[index*2+1]) %MOD;
        if (index == 1){
            return;
        }
        update(index/2);
    }

    private static long getMulti(int current, int startIdx, int endIdx, int targetStartIdx, int targetEndIdx){
        if(startIdx > targetEndIdx || endIdx < targetStartIdx){
            return 1;
        }
        if(startIdx >= targetStartIdx && endIdx <= targetEndIdx){
            return tree[current];
        }
        int mid = (startIdx + endIdx)/2;
        long left = getMulti(current*2, startIdx, mid, targetStartIdx, targetEndIdx);
        long right = getMulti(current * 2+1,mid+1, endIdx, targetStartIdx, targetEndIdx);
        return (left * right) % MOD;
    }

}
