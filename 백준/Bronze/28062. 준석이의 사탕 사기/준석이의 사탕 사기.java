import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> nums = new ArrayList<>();
        int sum = 0;
        while (st.hasMoreTokens()){
            int num = Integer.parseInt(st.nextToken());
            if(num % 2== 0){
                sum += num;
            }else{
                nums.add(num);
            }

        }
        Collections.sort(nums,Collections.reverseOrder());
       
        for (int i = 0; i < nums.size()-nums.size()%2; i++) {
            sum += nums.get(i);
        }
        System.out.println(sum);
    }
}
