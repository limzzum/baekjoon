import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if(N %2== 1){
            System.out.println(0);
            return;
        }

        int[] count = new int[N+1];
        count[2] = 3;
        int sum = 0;
        for (int i = 4; i <= N; i+=2) {
            count[i] = count[i-2] * 3 + sum + 2;
            sum += count[i-2] * 2;
        }
        System.out.println(count[N]);

    }

}
