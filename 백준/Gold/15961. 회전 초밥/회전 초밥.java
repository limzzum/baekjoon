import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int answer = 0;
    static int N;
    static int[] count;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        int d = Integer.parseInt(input[1]);
        int k = Integer.parseInt(input[2]);
        int c = Integer.parseInt(input[3]);

        int[] nums = new int[N+k];
        count = new int[d+1];
        count[c] = 1;

        for (int i=0; i<N; i++){
            nums[i] = Integer.parseInt(br.readLine());
        }
        for (int i=0; i<k; i++){
            nums[N+i] = nums[i];
        }

        int cnt = 1;
        for (int i=0; i<k; i++){
            if(count[nums[i]] == 0){
                cnt++;
            }
            count[nums[i]]++;
        }
        answer = cnt;
        for (int i=k; i<N+k; i++){
            count[nums[i-k]]--;
            if(count[nums[i-k]] == 0){
                cnt--;
            }
            if (count[nums[i]] == 0){
                cnt++;
            }
            count[nums[i]]++;
               answer = Math.max(answer, cnt);

        }

        System.out.println(answer);
    }
  
}
