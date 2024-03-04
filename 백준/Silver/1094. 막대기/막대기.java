import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int div = 64;
        int cnt = 0;
        while (N>0){
            cnt += N/div;
            N %= div;
            div /= 2;
        }
        System.out.println(cnt);
    }
}