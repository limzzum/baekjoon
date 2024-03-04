import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split(" ");
        double[] num = new double[N];

        double max = 0;
        int idx = 0;
        for (String s : line) {
            double v = Double.parseDouble(s);
            num[idx] = v;
            if(v>max){
                max = v;
            }
            idx+=1;
        }

        double sum = 0;
        for (double v : num) {
            sum += v/max*100;
        }

        double answer = sum/N;
        System.out.println(answer);
    }

}
