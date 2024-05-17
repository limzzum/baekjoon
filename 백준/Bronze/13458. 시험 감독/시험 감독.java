import java.util.*;
import java.io.*;

public class Main{
    
    static int N, B, C;
    static List<Integer> studentCnt = new ArrayList<>();

	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            studentCnt.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        long answer = N;
        for(int cnt : studentCnt){
            answer += getCnt(cnt - B);
        }
        bw.write(String.valueOf(answer));
	    bw.flush();
	    bw.close();
	}
	
	private static int getCnt(int n){
	    if(n <= 0){
	        return 0;
	    }  
	    return (int) Math.ceil((double) n/C);
	}
}
