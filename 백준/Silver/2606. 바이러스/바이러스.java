import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int ansCnt;
    static List<Integer>[] link;
    static boolean [] isVirus;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        link = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            link[i] = new ArrayList<>();
        }
        isVirus = new boolean[N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            link[a].add(b);
            link[b].add(a);
        }
        isVirus[1] = true;
        dfs(1);
        System.out.println(ansCnt);
    }

    private static void dfs(int start){
        for (int i = 0; i < link[start].size(); i++) {
            int n = link[start].get(i);
            if(!isVirus[link[start].get(i)]){
                isVirus[n]= true;
                ansCnt += 1;
                dfs(n);
            }
        }
    }
}
