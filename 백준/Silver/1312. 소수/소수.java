import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] input = br.readLine().split(" ");

        int A = Integer.parseInt(input[0]);
        int B = Integer.parseInt(input[1]);
        int N = Integer.parseInt(input[2]);

        int remain = (A%B) * 10;

        int answer = 0;
        for (int i = 0; i < N; i++) {
            answer = remain/B;
            remain = (remain%B) * 10;
        }
        System.out.println(answer);

    }
}
