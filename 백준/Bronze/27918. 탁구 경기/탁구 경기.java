import java.util.*;
import java.io.*;

public class Main{
    
	static int N;
	static int scoreA;
	static int scoreB;
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        for(int i=0; i<N; i++){
            if(br.readLine().equals("D")){
                scoreA += 1;
            }else {
                scoreB += 1;
            }
            if(Math.abs(scoreA - scoreB)>=2){
                break;    
            }
        }
        
        System.out.print(scoreA+":"+scoreB);
	}
}
