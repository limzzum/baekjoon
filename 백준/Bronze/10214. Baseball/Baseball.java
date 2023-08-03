import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            int yonsei = 0;
            int korea = 0;
            for (int j = 0; j < 9; j++) {
                st = new StringTokenizer(br.readLine());
                yonsei += Integer.parseInt(st.nextToken());
                korea += Integer.parseInt(st.nextToken());
            }
            if(yonsei>korea){
                sb.append("Yonsei");
            }else if(korea > yonsei){
                sb.append("Korea");
            }else {
                sb.append("Draw");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

}