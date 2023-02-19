import java.io.*;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main{
    static int answer = 0;
    static int N;
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        int d = Integer.parseInt(input[1]);
        int k = Integer.parseInt(input[2]);
        int c = Integer.parseInt(input[3]);

        int[] nums = new int[N];
        for (int i=0; i<N; i++){
            nums[i] = Integer.parseInt(br.readLine());
        }

        int count = 1;
        Queue<Integer> chobab = new LinkedList<>();
        for(int i=0; i<k; i++){
            if(!chobab.contains(nums[i]) && nums[i] != c){
                count +=1;
            }
            chobab.add(nums[i]);
        }
        answer = count;
        for(int i=k; i<nums.length; i++){
            int removed = chobab.poll();
            if(!chobab.contains(removed) && removed != c){
                count -=1;
            }

            if(!chobab.contains(nums[i]) && nums[i] != c){
                count +=1;
            }
            chobab.add(nums[i]);
            answer = Math.max(answer, count);
        }
        
         for(int i=0; i<k-1; i++){
            int removed = chobab.poll();
            if(!chobab.contains(removed) && removed != c){
                count -=1;
            }

            if(!chobab.contains(nums[i]) && nums[i] != c){
                count +=1;
            }
            chobab.add(nums[i]);
            answer = Math.max(answer, count);
        }
        
        System.out.println(answer);
    }
}