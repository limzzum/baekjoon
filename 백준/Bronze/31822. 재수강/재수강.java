import java.util.*;
import java.io.*;

public class Main{
    
    static int N;

	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String target = br.readLine().substring(0,5);
        
        N = Integer.parseInt(br.readLine());
        
        String subject;
        int cnt = 0;
        for(int i=0; i<N; i++){
            subject = br.readLine().substring(0,5);
            if(target.equals(subject)){
                cnt += 1;
            }
        }
        
        bw.write(String.valueOf(cnt));
	    bw.flush();
	    bw.close();
	}
}
