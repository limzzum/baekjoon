import java.io.*;
import java.util.*;

public class Main{

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque<int[]> nums = new ArrayDeque<>();

        int N = Integer.parseInt(br.readLine());

        String [] input = br.readLine().split(" ");
        sb.append(0).append(" ");
        nums.add(new int[]{Integer.parseInt(input[0]), 1});
        for(int i=1; i<N; i++) {
            int num = Integer.parseInt(input[i]);
            while(!nums.isEmpty()){
                if(nums.peekLast()[0] < num){
          
                    nums.pollLast();
                }else{
                    break;
                }
            }
            if(nums.isEmpty()){
                sb.append(0).append(" ");
            }else{
                sb.append(nums.peekLast()[1]).append(" ");
            }
            nums.add(new int[] {num,i+1});
        }

        System.out.println(sb);
    }
}