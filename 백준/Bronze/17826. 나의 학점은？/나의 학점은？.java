import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] sc = {1,6,16,31,36,46,49, 100};
    static String[] scores = {"A+", "A0", "B+", "B0", "C+", "C0", "F","0"};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int hong = Integer.parseInt(br.readLine());

        int idx= 0;
        int num= 1;
        while (st.hasMoreTokens()){

            int score = Integer.parseInt(st.nextToken());
            if(score == hong){
                System.out.println(scores[idx]);
                return;
            }
            num+=1;
            if(num >= sc[idx+1]){
                idx += 1;
            }
        }
    }
}
