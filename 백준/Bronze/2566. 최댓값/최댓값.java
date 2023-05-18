import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int max = 0;
    static int maxR = 1;
    static int maxC = 1;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;


        for (int i = 1; i <= 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <=9 ; j++) {
                int num = Integer.parseInt(st.nextToken());
                if(num>max){
                    max = num;
                    maxR = i;
                    maxC = j;
                }
            }
        }
        bw.write(max+"\n");
        bw.write(maxR+" "+maxC);
        bw.flush();
        bw.close();

    }

}
