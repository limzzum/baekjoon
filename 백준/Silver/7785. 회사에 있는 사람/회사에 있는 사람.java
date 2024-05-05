import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Main{

    static int N;
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        Set<String> names = new HashSet<>();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String behavior = st.nextToken();
            if(behavior.equals("enter")){
                names.add(name);
            }else {
                names.remove(name);
            }
        }
        
        names.stream().sorted(Comparator.comparing((String a) -> a).reversed()).forEach(System.out::println);
	}
}
