import java.io.*;

public class Main{

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = br.readLine();
        int N = Integer.parseInt(input);

        int sum1 =(int)(N*0.78);
        int sum2 = (int)((N*0.8) + (N*0.2*0.78));
        System.out.println(sum1+" "+sum2);
    }
}