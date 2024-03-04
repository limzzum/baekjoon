
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int K = Integer.parseInt(br.readLine());

        boolean isAdd = false;
        for (int i = 0; i < K; i++) {
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            if(a %2== 1 && b %2 == 1){
                isAdd = true;
            }
        }

        if(N %2== 0 || M %2 == 0){
            System.out.println(N/2 + M/2);
            return;
        }
        int answer = N/2 + M/2;
        if(isAdd){
            answer++;
        }
        System.out.println(answer);
    }
}
