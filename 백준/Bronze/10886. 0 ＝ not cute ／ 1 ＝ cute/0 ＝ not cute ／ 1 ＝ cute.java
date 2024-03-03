import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int [][] cuteCnt = new int[2][1];
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            cuteCnt[num][0] += 1;
        }
        if(cuteCnt[1][0]>cuteCnt[0][0]){
            System.out.println("Junhee is cute!");
            return;
        }
        System.out.println("Junhee is not cute!");
    }

}