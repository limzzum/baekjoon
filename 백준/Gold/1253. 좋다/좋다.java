import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int [] nums;
    static int ansCnt;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);
        for (int i = 0; i < N; i++) {
            int start = 0;
            int end = N-1;
            if(start== i){
                start += 1;
            }
            if(end == i){
                end -= 1;
            }
            while (start<end){
                int sum = nums[start]+nums[end];
                if(sum == nums[i]){
                    ansCnt += 1;
                    break;
                }
                if(sum<nums[i]){
                    start += 1;
                }else {
                    end -= 1;
                }
                if(start== i){
                    start += 1;
                }
                if(end == i){
                    end -= 1;
                }
            }
        }
        System.out.println(ansCnt);
    }

}
