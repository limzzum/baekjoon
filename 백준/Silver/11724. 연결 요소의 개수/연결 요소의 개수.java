import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static int[] parent;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<Integer> set = new HashSet<>();
        String [] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        parent = new int[N+1];

        for(int i=1; i<=N; i++){
            parent[i] = i;
        }

        for (int i= 0; i<M; i++){
            String[] edge = br.readLine().split(" ");
            int node1 = Integer.parseInt(edge[0]);
            int node2 = Integer.parseInt(edge[1]);
              if(find(node1)!=find(node2)){
                union(node1,node2);
            }
        }

        for (int i=1; i<parent.length; i++) {
           set.add(find(parent[i]));
        }
        System.out.println(set.size());
    }

      private static void union(int a,int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        
        if(aRoot>bRoot) parent[aRoot] = bRoot;
        else parent[bRoot] = aRoot;
    }
    
    private static int find(int a) {
        if(parent[a]==a) return a;
        return parent[a] = find(parent[a]);
    }
 
}
