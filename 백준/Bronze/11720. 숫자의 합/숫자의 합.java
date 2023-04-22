import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split("");

        int sum = 0;
        for (String n: input){
            sum += Integer.parseInt(n);
        }
        System.out.println(sum);
    }
}
