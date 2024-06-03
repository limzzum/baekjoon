import java.util.*;
import java.io.*;

public class Main{
    
    static class Cow{
        int start;
        int end;
        public Cow(int start){
            this.start = start;
        }
    }
    
    static List<Cow> cowes = new ArrayList<>();
    static Map<Integer, Integer> cowesIndex = new HashMap<>();
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int time = 1;
	    for(char name : br.readLine().toCharArray()){
	        if(cowesIndex.containsKey(name - 'A')){
	            cowes.get(cowesIndex.get(name - 'A')).end = time;
	        }else {
	            cowes.add(new Cow(time));
	            cowesIndex.put(name - 'A', cowes.size()-1);
	        }
	        
	        time += 1;
	    }
	    
        cowes.sort(Comparator.comparing(a -> a.start));

	    int cnt = 0;
	    for(int i=0; i<26; i++){
	        for(int j=i+1; j<26; j++){
	            if(cowes.get(j).start < cowes.get(i).end && cowes.get(j).end > cowes.get(i).end){
	                cnt += 1;
	            }
	        }
	    }
        
	    System.out.print(cnt);
	}
	
}
