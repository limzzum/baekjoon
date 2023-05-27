import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        int N =  Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            bw.write(a/25+" ");
            a%=25;
            bw.write(a/10+" ");
            a%=10;
            bw.write(a%25/5+" ");
            a%=5;
            bw.write(a/1+"\n");
        }
        bw.flush();
        bw.close();
    }
}