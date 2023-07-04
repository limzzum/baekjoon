import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int leafNodeCnt;
    static int[] parents;
    static ArrayList<Integer>[] outList;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        leafNodeCnt = N;

        parents = new int[N];
        outList = new ArrayList[N];

        for (int i = 0; i < N; i++) {
            outList[i] = new ArrayList();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if(parent != -1){
                parents[i] = parent;
                if(outList[parent].size()==0){
                    leafNodeCnt -= 1;
                }
                outList[parent].add(i);
            }
        }

        int removeNode = Integer.parseInt(br.readLine());
        dfs(removeNode);
        if(outList[parents[removeNode]].size() == 1){
            leafNodeCnt += 1;
        }

        System.out.println(leafNodeCnt);
    }

    private static void dfs(int startNode){
        if(outList[startNode].size() == 0){
            leafNodeCnt -= 1;
            return;
        }
        for (int i = 0; i < outList[startNode].size(); i++) {
            dfs(outList[startNode].get(i));
        }
    }
}
