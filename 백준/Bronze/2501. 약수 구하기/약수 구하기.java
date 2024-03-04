import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int c = 0;
        for (int i = 1; i <= N; i++) {
            if(N%i == 0){
                c += 1;
                if(c == K){
                    System.out.println(i);
                    return;
                }
            }
        }
        System.out.println(0);
    }
}