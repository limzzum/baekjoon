import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        String [] line = br.readLine().split(" ");
        String v = br.readLine();
        int count =0;
        for (String s : line) {
            if(s.equals(v)){
                count +=1;
            }
        }
        System.out.println(count);
    }
}