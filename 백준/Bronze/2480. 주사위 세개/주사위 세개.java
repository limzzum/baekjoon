import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int maxNum = 0;
        int maxCount = 0;
        int num = 0;

        int [] countNum = new int[7];
        for (int i = 0; i < 3; i++) {
            int n = Integer.parseInt(st.nextToken());
            maxNum = Math.max(maxNum, n);
            countNum[n] += 1;
            if(countNum[n] > maxCount){
                maxCount = countNum[n];
                num = n;
            }
        }
        if(maxCount == 1){
            System.out.println(maxNum * 100);
            return;
        }

        if(maxCount == 2){
            System.out.println(1000 + num * 100);
            return;
        }

        System.out.println(10000 + num * 1000);


    }

}