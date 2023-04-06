import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int[] parent;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        parent = new int[N+1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            if(find(a) == find(b)){
                System.out.println(i+1);
                return;
            }
            union(a, b);
        }
        System.out.println(0);

    }

    private static int find(int a) {
        if(parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }

    private static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        parent[pa] = pb;

    }
}
