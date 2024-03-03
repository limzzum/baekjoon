import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        long sum = 0;



        for (int i = 0; i < X; i++) {
            sum += nums[i];
        }
        long max = sum;
        int count = 1;

        int idx = 0;
        for (int i = X; i <N; i++) {
            sum += nums[i];
            sum -= nums[idx];
            if(sum == max){
                count += 1;
            }else if (sum > max){
                max = sum;
                count = 1;
            }

            idx+= 1;

        }
        if(max == 0){
            System.out.println("SAD");
            return;
        }

        System.out.println(max);
        System.out.println(count);
    }
}
