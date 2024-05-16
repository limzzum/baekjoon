import java.util.*;
import java.io.*;

public class Main{
    
    static int totalCnt;
    static double totalScore;
    static Map<String, Float> map = Map.of(
        "A+", 4.5f,
        "A0", 4.0f,
        "B+", 3.5f,
        "B0", 3.0f,
        "C+", 2.5f,
        "C0", 2.0f,
        "D+", 1.5f,
        "D0", 1.0f,
        "F", 0.0f
    );
    
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
	    for(int i=0; i<20; i++){
	        st = new StringTokenizer(br.readLine());
	        st.nextToken();
	        double n = Double.parseDouble(st.nextToken());
	        String score = st.nextToken();
	        if(score.equals("P")){
	            continue;
	        }
	        totalScore += map.get(score) * n;
	        totalCnt += n;
	    }

	    bw.write(String.format("%f",totalScore/totalCnt));
	    bw.flush();
	    bw.close();
	}
}
