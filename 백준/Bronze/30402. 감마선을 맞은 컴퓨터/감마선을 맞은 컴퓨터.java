import java.util.*;
import java.io.*;

public class Main{
    
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st;
        for(int i=0; i<15; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<15; j++){
                char word = st.nextToken().charAt(0);
                if(word == 'w'){
                    System.out.print("chunbae");
                    return;
                }else if(word == 'b'){
                    System.out.print("nabi");
                    return;
                }else if(word == 'g'){
                    System.out.print("yeongcheol");
                    return;
                }
            }
        }
	}
}
