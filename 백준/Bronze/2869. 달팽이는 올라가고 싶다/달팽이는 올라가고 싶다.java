import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        int diff = A-B;

        if(A==V){
            System.out.println(1);
            return;
        }
        V-= A;
        int ans = 1+ V/diff + (V%diff==0?0:1);
        System.out.println(ans);
    }
}
