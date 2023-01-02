package silver1.P11286;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class P11286 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<int[]> qp = new PriorityQueue<>((int[] o1,int[] o2) -> {
            if(o1[0]==o2[0]){
                return o1[1]-o2[1];
            }
            return o1[0]-o2[0];
        });
        int N = Integer.parseInt(br.readLine());

        for (int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());
            if(num==0){
                if(qp.isEmpty()){
                    sb.append(0);
                }else {
                    sb.append(qp.poll()[1]);
                }
                sb.append("\n");
            }else {
                qp.add(new int[]{Math.abs(num),num});
            }
        }
        System.out.println(sb);
    }
}
