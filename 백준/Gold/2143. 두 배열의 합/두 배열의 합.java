import java.util.*;
import java.io.*;

public class Main{

    static int T, N, M;
    static List<Integer> aNums = new ArrayList<>();
    static List<Integer> bNums = new ArrayList<>();
    static Map<Integer, Integer> map = new HashMap<>();
    
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            aNums.add(Integer.parseInt(st.nextToken()));        
        }
        
        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            bNums.add(Integer.parseInt(st.nextToken()));
        }
        
        int sum = 0;
        for(int i=0; i<N; i++){
            sum = 0;
            for(int j= i; j<N; j++){
                sum += aNums.get(j);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        
        long answer = 0L;
        for(int i=0; i<M; i++){
            sum = 0;
            for(int j= i; j<M; j++){
                sum += bNums.get(j);
                answer += map.getOrDefault(T-sum, 0);
            }
        }
        
        System.out.println(answer);
	}
}
