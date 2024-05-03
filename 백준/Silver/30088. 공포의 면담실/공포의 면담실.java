import java.util.*;
import java.io.*;

public class Main{

    static int N;
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        
        List<Integer> sums = new ArrayList<>();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int sum = 0;
            for(int j=0; j<n; j++){
                sum += Integer.parseInt(st.nextToken());
            }
            sums.add(sum);
        }
        
        sums.sort(Comparator.comparing(a -> a));
        long answer = 0;
        for(int i=0; i<N; i++){
            answer += sums.get(i) * (N-i);
        }
        
        System.out.println(answer);
	}
}
