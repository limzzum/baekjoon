import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int M;
    static PriorityQueue<Integer> priorityList = new PriorityQueue<>();
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);



        int [] inList = new int[N+1];
        List<Integer> [] outList = new ArrayList[N+1];

        for (int i = 1; i <= N; i++) {
            outList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            String[] line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            inList[b] += 1;
            outList[a].add(b);

        }

        visited = new boolean[N+1];

        int count = 0;
       while (count<N){
           for (int i = 1; i <= N; i++) {
               if(inList[i] == 0 && !visited[i]){
                   visited[i] = true;
                   priorityList.add(i);
               }
           }
           int num = priorityList.poll();
           for (int i = 0; i < outList[num].size(); i++) {
               int n = outList[num].get(i);
               inList[n] -=1;
           }
           sb.append(num).append(" ");
           count +=1;
       }


        System.out.println(sb);
    }

}
