import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if(N == 1){
            System.out.println(1);
            return;
        }
        Queue<Integer> nums = new ArrayDeque<>();
        for(int i=1 ; i<=N ;i++) {
            nums.add(i);
        }

        while(nums.size()>2) {
            nums.poll();
            nums.add(nums.poll());
        }
        nums.poll();
        System.out.println(nums.poll());
    }
}
