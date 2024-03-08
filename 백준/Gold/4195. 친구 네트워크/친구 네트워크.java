import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static int[] parent;
    static Map<Integer, Integer> groupMemberCnt;
    static Map<String, Integer> members;
    static int cnt;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            int N = Integer.parseInt(br.readLine());
            parent = new int[N*2 + 1];
            cnt = 0;
            groupMemberCnt = new HashMap<>();
            members = new HashMap<>();

            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                String b = st.nextToken();

                Integer aGroupKey = members.get(a);
                Integer bGroupKey = members.get(b);

                if(aGroupKey != null){
                    if(bGroupKey != null){
                        union(aGroupKey, bGroupKey);
                    }else{

                        parent[++cnt] = find(aGroupKey);
                        members.put(b, cnt);
                        groupMemberCnt.put(parent[aGroupKey], groupMemberCnt.get(parent[aGroupKey])+1);
//                        if(a.equals("b") && b.equals("e")){
//                            System.out.println(parent[aGroupKey] + " "+groupMemberCnt.get(parent[aGroupKey])+ " "+find(parent[aGroupKey]));
//                        }
                    }
                }else if(bGroupKey != null){
                    parent[++cnt] = find(bGroupKey);
                    members.put(a, cnt);
                    groupMemberCnt.put(parent[bGroupKey], groupMemberCnt.get(parent[bGroupKey])+1);
                }else {
                    parent[++cnt] = cnt;
                    parent[++cnt] = cnt -1;
                    members.put(a, cnt -1);
                    members.put(b, cnt);
                    groupMemberCnt.put(cnt -1, 2);
                }

                Integer count = groupMemberCnt.get(find(members.get(a)));
                sb.append(count).append("\n");

            }

        }
        System.out.println(sb);
    }

    private static int find(int a){
        if(parent[a] == a){
            return a;
        }

        return parent[a] = find(parent[a]);
    }

    private static void union(int aGroupKey, int bGroupKey){
        int rootA = find(aGroupKey);
        int rootB = find(bGroupKey);

        if(rootA == rootB){
            return;
        }

        Integer aGroupCnt = groupMemberCnt.get(rootA);
        parent[rootA] = rootB;
        groupMemberCnt.put(rootB, groupMemberCnt.get(rootB) + aGroupCnt);

    }

}
