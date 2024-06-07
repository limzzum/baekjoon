import java.util.*;
import java.io.*;

public class Main{
    
    static int N, M;
    static List<Integer> snackes = new ArrayList<>();
    static int answer;
    
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            snackes.add(Integer.parseInt(st.nextToken()));
        }
        
        snackes.sort(Comparator.comparing(a -> -a));

        int left = 1;
        int right = snackes.get(0);
        int mid;
        int cnt;
        while(left <= right){
            mid = (left + right)/2;
            cnt = 0;
            for(int i=0; i<M; i++){
                int c = snackes.get(i)/mid;
                if(c == 0 || cnt >= N){
                    break;
                }
                cnt += c;
            }
            if(cnt >= N){
                answer = Math.max(answer, mid);
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        
        System.out.print(answer);        
	}
}
