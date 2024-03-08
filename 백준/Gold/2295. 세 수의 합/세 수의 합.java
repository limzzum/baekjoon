import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int N;
    static List<Integer> nums = new ArrayList<>();
    static int answer;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            nums.add(num);
        }
        nums.sort((a,b)-> b-a);

        for (int i = 0; i < N-1; i++) {
            if(comb(i+1,0, 0, nums.get(i))){
                answer = nums.get(i);
                break;
            };
        }

        System.out.println(answer);

    }

    private static boolean comb(int start, int n, int sum, int target){
        if(sum > target){
            return false;
        }

        if(n == 3){
            return sum == target;
        }

        for (int i = start; i < N; i++) {
            if(sum + nums.get(i) * (3-n) < target){
                return false;
            }
            if(comb(i,n + 1, sum+nums.get(i), target)){
                return true;
            }
        }
        return false;
    }

}
