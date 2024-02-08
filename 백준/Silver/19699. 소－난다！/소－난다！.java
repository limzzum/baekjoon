import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

    static int N,M;
    static List<Integer> cows = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    static boolean[] isChecked = new boolean[9001];
    static Set<Integer> set = new TreeSet<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cows.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(cows);
        dfs(0, 0, 0);

        for (Integer integer : set) {
            sb.append(integer).append(" ");
        }
        if(sb.toString().equals("")){
            System.out.println(-1);
            return;
        }
        System.out.println(sb);

    }

    private static void dfs(int start, int cnt, int sum){
        if(cnt == M){
            if(!isChecked[sum] && isDecimal(sum)){
//                sb.append(sum).append(" ");
                set.add(sum);
            }
            return;
        }
        if(N-start + cnt < M){
            return;
        }
        for (int i = start; i < N; i++) {
            dfs(i+1, cnt+1, sum + cows.get(i));
            dfs(i+1, cnt, sum);
        }
    }

    private static boolean isDecimal(int n){
        isChecked[n] = true;
        if(n == 1){
            return false;
        }
        if(n == 2){
            return true;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }

}
