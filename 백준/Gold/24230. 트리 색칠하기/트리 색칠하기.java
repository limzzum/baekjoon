import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] colors;
    static List<Integer>[] connections;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        colors = new int[N];
        connections = new List[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            colors[i] = Integer.parseInt(st.nextToken());
        }

        int a, b;
        for(int i=0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            connect(a,b);
        }
        dfs(1,1, 0);
        System.out.println(answer);
    }

    private static void connect(int a, int b){
        if(connections[a] == null){
            connections[a] = new ArrayList<>();
        }
        connections[a].add(b);

        if(connections[b] == null){
            connections[b] = new ArrayList<>();
        }
        connections[b].add(a);
    }

    private static void dfs(int parent, int n, int cur){
        if(cur != colors[n-1]){
            cur = colors[n-1];
            answer += 1;
        }
        if(connections[n] == null){
            return;
        }

        for(int i=0; i<connections[n].size(); i++){
            if(connections[n].get(i) == parent){
                continue;
            }
            dfs(n, connections[n].get(i), cur);
        }
    }

}
