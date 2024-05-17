import java.util.*;
import java.io.*;

public class Main{
    
    static int N;
    static int cnt;

	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        
        char[] input;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            input = br.readLine().toCharArray();
            cnt = 0;
            if(isVPS(input)){
                sb.append("YES");
            }else{
                sb.append("NO");
            }
            sb.append("\n");
        }

	    bw.write(sb.toString());
	    bw.flush();
	    bw.close();
	}
	
	private static boolean isVPS(char[] input){
	    for(char i : input){
	        if(i == '('){
	            cnt += 1;
	        }else if(cnt == 0){
	            return false;
	        }else {
	            cnt -=1;
	        }
	    }
	    return cnt == 0;
	}
}
