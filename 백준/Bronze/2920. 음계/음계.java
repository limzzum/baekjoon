import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String ans = "ascending";
        int pre = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        if(n<pre){
            ans = "descending";
        }
        pre = n;
        for (int i = 2; i < 8; i++) {
            n = Integer.parseInt(st.nextToken());
            if(n>pre){
                if(ans.equals("descending")){
                    System.out.println("mixed");
                    return;
                }
            }
            if(n<pre){
                if(ans.equals("ascending")){
                    System.out.println("mixed");
                    return;
                }
            }
            pre = n;
        }
        System.out.println(ans);
    }
}