import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0;
        int min = 100;
        for (int i = 0; i < 7; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num%2==1){
                sum += num;
                min = Math.min(min, num);
            }
        }

        if(min == 100){
            System.out.println(-1);
            return;
        }
        System.out.println(sum);
        System.out.println(min);
    }
}