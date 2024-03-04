import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        String [] line = br.readLine().split(" ");
        int[] num = new int[N];
        int idx = 0;
        for (String s : line) {
            num[idx] = Integer.parseInt(s);
            idx+=1;
        }
        Arrays.sort(num);
        int answer = num[0] * num[num.length-1];
        System.out.println(answer);
    }

}
