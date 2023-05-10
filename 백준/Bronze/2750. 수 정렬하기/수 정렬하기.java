import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        int [][] nums = new int[2][1001];
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            if(n>=0){
                nums[0][n] = 1;
            }else{
                nums[1][n*-1] =1;
            }

        }

        for (int i = 1000; i>0; i--) {
            if(nums[1][i]==1){
                bw.write(i*-1+"\n");
            }
        }
        for (int i = 0; i<=1000; i++) {
            if(nums[0][i]==1){
                bw.write(i+"\n");
            }
        }

        bw.flush();
        bw.close();

    }
}
