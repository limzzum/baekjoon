import java.util.*;
import java.io.*;

public class Main{
    
	static int[][] testimony = new int[10][2];
	static Set<Integer> others;
	static int firstMan;
	static List<Integer> answer = new ArrayList<>();
	
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    StringTokenizer st;
	    for(int i=1; i<=9; i++){
            st = new StringTokenizer(br.readLine());
            testimony[i][0] = Integer.parseInt(st.nextToken());
            testimony[i][1] = Integer.parseInt(st.nextToken());
	    }
	    
	loop: for(int i=1; i<=9; i++){
	        firstMan = -1;
	        others = new HashSet<>();
	        testimony[i][0] = testimony[i][0] == 0 ? 1:0;
	        testimony[i-1][0] = testimony[i-1][0] == 0 ? 1:0;
	        
	        for(int j=1; j<=9; j++){
	            if(testimony[j][0] == 0){
	                if(firstMan == testimony[j][1]){
	                   continue loop;
	                }
	                others.add(testimony[j][1]);
	            }else{
	                if(others.contains(testimony[j][1])){
	                    continue loop;
	                }
	                
	                if(firstMan == -1){
	                   firstMan = testimony[j][1];
	                }else if(firstMan != testimony[j][1]){
	                   continue loop;
	                }
	            }
    
	        }
	        
	        if(findFirstMan()!= -1){
	            if(findFirstMan() == -2){
                    System.out.print(-1);
                    return;
	            }
	           answer.add(firstMan);
	        }
	    }
	    
	    if(answer.size()== 1){
	        System.out.print(answer.get(0));
	        return;
	    }
	    System.out.print(-1);

	    
	}    
	private static int findFirstMan(){
	    if(firstMan != -1){
	        return firstMan;
	    }
	    
	    if(others.size() != 8){
	        return -2;
	    }
	    
	    for(int i=1; i<=9; i++){
	        if(!others.contains(i)){
	            return firstMan = i;
	        }
	    }
	    return -1;
	}
}
