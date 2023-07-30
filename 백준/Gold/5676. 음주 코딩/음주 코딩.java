import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int S = 1;
    static int[] tree;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        String input = null;
        while ((input = br.readLine()) != null){
            st = new StringTokenizer(input);
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            
            while (S < N){
                S *= 2;
            }
            tree = new int[S*2];

            st = new StringTokenizer(br.readLine());

            //트리 초기화.
            for (int i = 0; i < N; i++) {
                int num = Integer.parseInt(st.nextToken());
                if(num < 0 ){
                    num = -1;
                }else if(num > 0) {
                    num = 1;
                }
                tree[S+i] = num;
            }
            for (int i = S+N; i < S*2; i++) {
                tree[i] = 1;
            }
            for (int i = S-1; i >0 ; i--) {
                tree[i] = tree[i*2] * tree[i*2+1];
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                char command = st.nextToken().charAt(0);
                if(command == 'C'){
                    int idx = Integer.parseInt(st.nextToken());
                    int num = Integer.parseInt(st.nextToken());
                    if(num > 0){
                        num = 1;
                    }else if(num <0){
                        num = -1;
                    }
                    tree[S+idx-1] = num;
                    update((S+idx-1)/2);
                }else{
                    int start = Integer.parseInt(st.nextToken());
                    int end = Integer.parseInt(st.nextToken());
                    int result = getResult(1, 1, S, start, end);
                    if(result == 0){
                        sb.append(0);
                    }else if(result == 1){
                        sb.append("+");
                    }else {
                        sb.append("-");
                    }
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    private static void update(int idx){
        tree[idx] = tree[idx*2] * tree[idx*2+1];
        if(idx == 1){
            return;
        }
        update(idx/2);
    }
    private static int getResult(int curIdx, int startIdx, int endIdx, int targetStartIdx, int targetEndIdx){
        if(startIdx>targetEndIdx || endIdx < targetStartIdx){
            return 1;
        }
        if(startIdx >= targetStartIdx && endIdx <= targetEndIdx){
            return tree[curIdx];
        }
        int mid = (startIdx + endIdx) /2;
        int left = getResult(curIdx * 2, startIdx, mid, targetStartIdx, targetEndIdx);
        int right = getResult(curIdx * 2 +1, mid + 1, endIdx, targetStartIdx, targetEndIdx);
        return left * right;
    }
}
