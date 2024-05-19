import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Main{
    
    static int N;
    static List<Integer> nums = new ArrayList<>();
    static Map<Integer, Integer> numCnt = new HashMap<>();

	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int duplicate = 0;
        int sum = 0;
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(st.nextToken());
            nums.add(num);
            numCnt.put(num, numCnt.getOrDefault(num, 0) + 1);
            sum += num;
            duplicate = Math.max(duplicate, num * numCnt.get(num));
        }
        String ns = nums.stream().sorted().map(e -> e.toString()).collect(Collectors.joining(" "));
        bw.write(String.valueOf(sum + duplicate)+"\n");
        bw.write(ns);
	    bw.flush();
	    bw.close();
	}

}
