import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static long[] tree;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int K = Integer.parseInt(input[2]);

        int s = 1;
        while(s < N){
            s *= 2;
        }
        tree = new long[s*2];

        // 트리 초기화
        for (int i=0; i<N; i++){
            tree[s+i] = Long.parseLong(br.readLine());
        }
        for (int i=s-1; i>0; i--){
            tree[i] = tree[i*2] + tree[i*2+1];
        }


        for (int i = 0; i < M+K; i++) {
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            long c = Long.parseLong(input[2]);
            if(a == 1){
                long diff = c - tree[s+b-1];
                tree[s+b-1] = c;
                int idx = (s+b-1)/2;
                while(idx > 0){
                    tree[idx] += diff;
                    idx /= 2;
                }
            }else{
                long sum = dfs(1, 1, s, b, (int)c);
                sb.append(sum).append("\n");
            }

        }
        System.out.println(sb);




    }
    private static long dfs(int startIdx , int startLeft, int startRight, int targetLeft, int targetRight){
        if(startLeft > targetRight || startRight < targetLeft) return 0;
        if(startLeft >= targetLeft && startRight <= targetRight){
            return tree[startIdx];
        }
        else{
            int mid = (startLeft + startRight) / 2;
            return dfs(startIdx*2, startLeft, mid, targetLeft, targetRight) + dfs(startIdx*2+1, mid+1, startRight, targetLeft, targetRight);
        }
    }
}
