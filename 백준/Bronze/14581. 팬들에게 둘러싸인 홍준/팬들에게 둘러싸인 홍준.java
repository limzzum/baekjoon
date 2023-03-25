import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String id = br.readLine();
        System.out.println(":fan::fan::fan:\n" +
                ":fan::"+id+"::fan:\n" +
                ":fan::fan::fan:");

    }
}
