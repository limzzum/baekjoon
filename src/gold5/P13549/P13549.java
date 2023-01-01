package gold5.P13549;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class P13549 {
    static int count;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<int[]> qp = new LinkedList<>();
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        if(N>=K){
            count = N-K;
            System.out.println(count);
            return;
        }
        count = K-N;
        qp.add(new int[]{N,0});
        boolean [] visited = new boolean[100001];

        while (!qp.isEmpty()){
            int[] poll = qp.poll();
            if(poll[0] >= K){
                count = Math.min(count, poll[1] + poll[0] - K);
                continue;
            }
            if(poll[0]*2>=0 && poll[0]*2<=100000 && !visited[poll[0]*2]){
                qp.add(new int[]{poll[0]*2, poll[1]});
                visited[poll[0]*2]=true;
            }
            if(poll[0] - 1 >= 0 && !visited[poll[0] - 1]){
                qp.add(new int[]{poll[0]-1, poll[1]+1});
                visited[poll[0]-1]=true;
            }
            if(poll[0]+1<=100000 && !visited[poll[0]+1]){
                qp.add(new int[]{poll[0]+1, poll[1]+1});
                visited[poll[0]+1]=true;
            }
        }
        System.out.println(count);
    }


}
