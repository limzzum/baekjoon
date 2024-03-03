import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    static int[] parent;
    static List<Integer>[] tree;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> qp = new LinkedList<>();
        int N = Integer.parseInt(br.readLine());

        parent = new int[N + 1];
        tree = new ArrayList[N+1];

        for (int i=1; i<=N; i++){
            tree[i] = new ArrayList<>();
        }

        parent[1] = 1;
        for (int i = 0; i < N - 1; i++) {
            String[] line = br.readLine().split(" ");
            int nodeL = Integer.parseInt(line[0]);
            int nodeR = Integer.parseInt(line[1]);

            tree[nodeL].add(nodeR);
            tree[nodeR].add(nodeL);
        }
        qp.add(1);
        while (!qp.isEmpty()){
            Integer poll = qp.poll();
            for (int i=0; i<tree[poll].size();i++){
                if( parent[tree[poll].get(i)]==0){
                    parent[tree[poll].get(i)] = poll;
                    qp.add(tree[poll].get(i));
                }
            }
        }
        for (int i = 2; i < parent.length; i++) {
            System.out.println(parent[i]);
        }
    }

}
