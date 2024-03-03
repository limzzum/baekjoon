import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n;
        int sum = 0;
        int answer = 0;
        for (int i = 0; i < 10; i++) {
            n = Integer.parseInt(br.readLine());
            sum += n;
            if(sum>=100){
                if(sum - 100 <= 100-answer){
                    answer = sum;
                }
                System.out.println(answer);
                return;
            }
            answer = sum;
        }
        System.out.println(answer);
    }
}
