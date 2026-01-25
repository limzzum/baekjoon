import java.util.*;
import java.io.*;

public class Main{
    
    private static int N, M;
    private static List<Integer> rides = new ArrayList<>();
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        if(N <= M){
            System.out.print(N);
            return;
        }
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            rides.add(Integer.parseInt(st.nextToken()));
        }

        int right = N/M * 30;
        int left = N/M;
        int mid;
        int cnt;
        int time = 0;
        int diff = 0;
        while(left <= right){
            cnt = M;
            mid = (left + right) / 2;
            for(int i=0; i<M; i++){
                cnt += mid / rides.get(i);
                if(cnt >= N){
                    break;
                }
            }
            if(cnt >= N){
                time = mid;
                diff = cnt - N;
                right = mid -1;
            }else {
                left = mid + 1;
            }
        }
        for(int i=M-1; i>=0; i--){
            if(time % rides.get(i) == 0){
                if(diff == 0){
                    System.out.print(i+1);
                    return;
                }
                diff -= 1;
            }
        }
        
	}
}
