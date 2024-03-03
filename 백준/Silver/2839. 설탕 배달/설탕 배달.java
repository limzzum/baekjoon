import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int sum = -1;

        int count = N/5;
        while (count>=0) {
            if((N - count*5)%3 == 0){
                sum = count + (N - count*5)/3;
                break;
            }
            else{
                count -=1;
            }
        }

        System.out.println(sum);
    }

}
