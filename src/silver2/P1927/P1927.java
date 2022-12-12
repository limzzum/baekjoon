package silver2.P1927;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class P1927 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> qp = new PriorityQueue<>();
        int N = Integer.parseInt(br.readLine());

        for (int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());
            if(num == 0){
                if(qp.isEmpty()){
                    sb.append(0).append("\n");
                }
                else{
                    sb.append(qp.poll()).append("\n");
                }
            }
            else{
                qp.add(num);
            }
        }
        System.out.println(sb);
    }
}
