import java.util.*;
import java.io.*;

public class Main{

	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] nums = br.readLine().toCharArray();
        
        int zeroCnt = 0;
        int oneCnt = 0;
        for(char num : nums){
            if(num == '0'){
                zeroCnt += 1;
            }else{
                oneCnt += 1;
            }
        }
        zeroCnt/=2;
        oneCnt/=2;
        
        StringBuilder sb = new StringBuilder();
        for(char num : nums){
            if(num == '0'){
                if(zeroCnt > 0){
                    zeroCnt -= 1;
                    sb.append(0);
                }
            }else if(oneCnt>0){
                oneCnt -= 1;
            }else{
                sb.append(1);
            }
        }
        
        System.out.println(sb);
	}
}
