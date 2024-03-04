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
            int b = Integer.parseInt(st.nextToken());
            int min = Math.min(a,b);
            int max = Math.max(a,b);
            for (int j = min; j <= min*max; j+=min) {
                if(j%max == 0){
                    bw.write(j+"\n");
                    break;
                }
            }
        }
        bw.flush();
        bw.close();
    }
}