package silver2.P2805;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P2805 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        String[] line = br.readLine().split(" ");
        int[] trees = new int[N];
        int max =0;
        for(int i=0; i<N; i++){
            trees[i] = Integer.parseInt(line[i]);
            max = Math.max(max, trees[i]);
        }

        int left = 0;
        int right = max-1;
        int mid;
        long answer = 0;
        while (left<=right){
            long sum= 0;
            mid = (left+right)/2;
            for(int tree:trees){
                if(tree<=mid){
                    continue;
                }
                sum+= tree-mid;
            }
            if(sum>=K){
                answer = mid;
                left = mid+1;
            }
            if(sum<K){
                right=mid-1;
            }
        }
        System.out.println(answer);

    }
}
