import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i <N; i++) {
            String[] input = br.readLine().split(" ");
            int a =Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            bw.write((a+b)+"\n");
        }
        bw.flush();
        bw.close();

    }
}
