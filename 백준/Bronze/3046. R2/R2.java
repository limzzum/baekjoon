import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int s1 = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken()) * 2;

        System.out.println(S - s1);
    }

}