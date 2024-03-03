import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        char[] a = st.nextToken().toCharArray();
        char[] b = st.nextToken().toCharArray();
        sb.append(a[2]).append(a[1]).append(a[0]);
        int ans = Integer.parseInt(sb.toString());

        sb = new StringBuilder();
        sb.append(b[2]).append(b[1]).append(b[0]);
        ans = Math.max(ans, Integer.parseInt(sb.toString()));
        System.out.println(ans);

    }
}