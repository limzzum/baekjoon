import java.util.*;
import java.io.*;

public class Main{
    
    static int N;
    static List<String> student = new ArrayList<>();
    static int maxCnt;
    static int leader = 1;
 
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        for(int i=0; i<N; i++){
            student.add(br.readLine());
        }
        
        int cnt;
        for(int i=0; i<N; i++){
            cnt = 0;
            for(int j=0; j<N; j++){
                if(i == j){
                    continue;
                }
                for(int k=0; k<5; k++){
                    if(student.get(i).charAt(k*2) == student.get(j).charAt(k*2)){
                        cnt += 1;
                        break;
                    }
                }
            }
            if(cnt > maxCnt){
                maxCnt = cnt;
                leader = i + 1;
            }
            
        }

        System.out.print(leader);
	}
}
