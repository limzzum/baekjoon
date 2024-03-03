import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int[] parent;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        for (int i=1; i<=tc; i++){
            int N = Integer.parseInt(br.readLine());
            initParent(N);
            int K = Integer.parseInt(br.readLine());
            for(int j = 0; j<K; j++){
                String [] friends = br.readLine().split(" ");
                int a = Integer.parseInt(friends[0]);
                int b = Integer.parseInt(friends[1]);
                union(a,b);
            }
            int M = Integer.parseInt(br.readLine());
            sb.append("Scenario ").append(i).append(":").append("\n");
            for (int j = 0; j<M; j++){
                String [] friends = br.readLine().split(" ");
                int a = Integer.parseInt(friends[0]);
                int b = Integer.parseInt(friends[1]);
                if(findParent(a) == findParent(b)){
                    sb.append(1);
                }else{
                    sb.append(0);
                }
                sb.append("\n");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void initParent(int n){
        parent = new int[n];
        for (int i=0; i<n; i++){
            parent[i] = i;
        }
    }
    private static int findParent(int child){
        if(parent[child] == child){
            return child;
        }
        return parent[child] = findParent(parent[child]);
    }
    private static void union(int a, int b){
        int aParent = findParent(a);
        int bParent = findParent(b);
        if(aParent < bParent){
             parent[bParent] = aParent;
        }else{
            parent[aParent] = bParent;
        }
    }
}
