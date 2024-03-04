import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int sum = 0;
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            int N = Integer.parseInt(br.readLine());
            sum += N;
            nums.add(N);
        }

        Collections.sort(nums);
        bw.write(sum/5+"\n"+nums.get(2));
        bw.flush();
        bw.close();

    }
}
