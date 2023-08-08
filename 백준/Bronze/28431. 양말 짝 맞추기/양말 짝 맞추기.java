import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0;
        boolean [] isUsed = new boolean[10];
        for (int i = 0; i < 5; i++) {
            int n = Integer.parseInt(br.readLine());
            if(isUsed[n]){
                sum -= n;
                isUsed[n] = false;
                continue;
            }
            isUsed[n] = true;
            sum += n;
        }

        System.out.println(sum);
    }

}