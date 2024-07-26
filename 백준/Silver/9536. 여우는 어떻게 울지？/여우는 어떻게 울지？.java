import java.util.*;
import java.io.*;

public class Main{
    
    static int N;
    static Set<String> others = new HashSet<>();

	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        String input;
        for(int i=0; i<N; i++){
            input = br.readLine();
            while((st = new StringTokenizer(br.readLine())).countTokens() == 3){
                st.nextToken();
                st.nextToken();
                others.add(st.nextToken());
            }
            st = new StringTokenizer(input);
            while(st.hasMoreTokens()){
                input = st.nextToken();
                if(!others.contains(input)){
                    sb.append(input).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
	}

}
