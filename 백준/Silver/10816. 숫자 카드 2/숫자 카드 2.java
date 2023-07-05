import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final int MAX_NUM = 10_000_000;
    static int[][] numCount = new int[2][MAX_NUM + 1];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;


        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int num=0;
        for (int i = 0; i < N; i++) {
            num = Integer.parseInt(st.nextToken());
            if(num<0){
                numCount[0][Math.abs(num)] += 1;
            }else{
                numCount[1][num] += 1;
            }
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());


        for (int i = 0; i < M; i++) {
            num = Integer.parseInt(st.nextToken());
            if(num<0){
                sb.append(numCount[0][Math.abs(num)]);
            }else{
                sb.append(numCount[1][num]);
            }
            sb.append(" ");
        }

        System.out.println(sb);

    }
}
