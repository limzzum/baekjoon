
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int[] count = new int[10];
    static int maxCount = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split("");
        for (int i = 0; i < input.length; i++) {
            int n = Integer.parseInt(input[i]);
            if(n == 6 || n== 9){
                count[6] += 1;
            }
            else{
                count[n] += 1;
            }
        }
        if(count[6]>1){
            count[6]= count[6]/2 + count[6]%2;
        }
        for (int i = 0; i < 10; i++) {
            if(count[i]> maxCount){
                maxCount = count[i];
            }
        }

        System.out.println(maxCount);

    }
}
