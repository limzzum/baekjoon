import java.io.*;
import java.util.*;

public class Main{

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<int[]> nums = new Stack<>();

        int N = Integer.parseInt(br.readLine());

        String [] input = br.readLine().split(" ");
        sb.append(0).append(" ");
        nums.add(new int[]{Integer.parseInt(input[0]), 1});
        for(int i=1; i<N; i++) {
            int num = Integer.parseInt(input[i]);
            while(!nums.isEmpty()){
                if(nums.peek()[0] < num){
                    nums.pop();
                }else{
                    break;
                }
            }
            if(nums.isEmpty()){
                sb.append(0).append(" ");
            }else{
                sb.append(nums.peek()[1]).append(" ");
            }
            nums.add(new int[] {num,i+1});
        }

        System.out.println(sb);
    }
}