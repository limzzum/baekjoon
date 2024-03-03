import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static final int MAXNUM = 1_000_000;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        //음수, 양수 나눠서 카운팅
        boolean [][] nums = new boolean[2][MAXNUM + 1];
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            if(n<0){
                nums[0][n*-1] = true;
            }else{
                nums[1][n] = true;
            }
        }

        for (int i = MAXNUM ; i >0 ; i--) {
            if(nums[0][i]){
                sb.append(i*-1).append("\n");
            }
        }
        for (int i = 0; i <=MAXNUM ; i++) {
            if(nums[1][i]){
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb);

    }
}
