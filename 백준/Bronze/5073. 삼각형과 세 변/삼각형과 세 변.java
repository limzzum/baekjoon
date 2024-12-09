import java.util.*;
import java.io.*;

public class Main{
    
    static Set<Integer> lengths = new HashSet<>();
    
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String input;
	    StringTokenizer st;
	    StringBuilder sb = new StringBuilder();
	    while(true){
	        input = br.readLine();
	        st = new StringTokenizer(input);
	        List<Integer> nums = new ArrayList<>();
	        for(int i=0; i<3; i++){
	            nums.add(Integer.parseInt(st.nextToken()));
	            lengths.add(nums.get(i));
	        }
	        if(lengths.size() == 1 && lengths.contains(0)){
	            break;
	        }
	        
	        nums.sort(Comparator.comparing(a-> a));
	        if(nums.get(0) + nums.get(1) <= nums.get(2)){
	            sb.append("Invalid");
	        }else if(lengths.size() == 1){
	            sb.append("Equilateral");
	        }else if(lengths.size() == 2){
	            sb.append("Isosceles");
	        }else {
	            sb.append("Scalene");
	        }
	        sb.append("\n");
	        lengths.clear();
	    }  
	    System.out.print(sb);
	}
	
}
