import java.util.*;
import java.io.*;

public class Main{

	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());

	    int a = Integer.parseInt(st.nextToken());
	    st.nextToken();

	    int b = Integer.parseInt(st.nextToken());
        st.nextToken();
	    int result = Integer.parseInt(st.nextToken());
	    
	    if(a + b == result){
	        System.out.println("YES");
	    }else{
	        System.out.println("NO");

	    }
	}
}
