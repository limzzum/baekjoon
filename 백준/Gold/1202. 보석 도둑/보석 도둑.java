import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Long> qp = new PriorityQueue<>(Collections.reverseOrder());
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        long[][] gold = new long[N][2];
        long[] bags = new long[K];
        
        for(int i=0; i<N; i++) {
            String[] line = br.readLine().split(" ");
            gold[i][0] = Long.parseLong(line[0]);
            gold[i][1] = Long.parseLong(line[1]);
        }

        for(int i=0; i<K; i++) {
            bags[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(gold,(a, b)->(int) (a[0]-b[0]));
        Arrays.sort(bags);

        int idx =0;
        long sum = 0;

        for (long bag : bags) {
            for (int j = idx; j < gold.length; j++) {
                if (bag >= gold[j][0]) {
                    qp.add(gold[j][1]);
                    idx += 1;
                } else {
                    break;
                }
            }
            if (!qp.isEmpty()) {
                sum += qp.poll();
            }
        }
        System.out.println(sum);
    }
}
