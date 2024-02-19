import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int len = br.readLine().length();
            if(len >=6 && len <=9){
                sb.append("yes");
            }else {
                sb.append("no");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

}
