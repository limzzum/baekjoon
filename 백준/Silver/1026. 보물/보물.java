import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int [] listA = new int[N];
        int [] listB = new int[N];
        for (int i = 0; i < N; i++) {
            listA[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            listB[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(listA);
        Arrays.sort(listB);

        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += ( listA[i] * listB[N-1-i] );
        }
        System.out.println(sum);
    }
}
