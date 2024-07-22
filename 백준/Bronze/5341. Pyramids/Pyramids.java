import java.util.*;
import java.io.*;

public class Main{
    
    static List<Integer> nums = new ArrayList<>();
    static int max;
    static Map<Integer, Long> map = new HashMap<>();
    
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N;
        while((N = Integer.parseInt(br.readLine()))!=0){
            nums.add(N);
            max = Math.max(max, N);
        }
        
        long sum = 0;
        for(int i=1; i<=max; i++){
            sum += i;
            map.put(i, sum);
        }
        
        StringBuilder sb = new StringBuilder();
        for(int num : nums){
            sb.append(map.get(num)).append("\n");
        }
        System.out.print(sb);
	}

}
