import java.util.*;
import java.io.*;

public class Main{
    
    static int T, N;
    static List<String> words;
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        T = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        for(int t = 0; t<T; t++){
            N = Integer.parseInt(br.readLine());
            words = new ArrayList<>();
            for(int i=0; i<N; i++){
                words.add(br.readLine());
            }
            sb.append(find()).append("\n");
            
        }
        bw.write(sb.toString());
	    bw.flush();
	    bw.close();
	}
	
	private static String find(){
	    for(int i=0; i<N; i++){
	        for(int j=0; j<N; j++){
	            if(i == j){
	                continue;
	            }
	            String word = words.get(i) + words.get(j);
	            if(isPalin(word)){
	                return word;
	            }
	        }
	    }
	    return "0";
	}
	
	private static boolean isPalin(String word){
	    int len = word.length();
	    for(int i=0; i<= len/2; i++){
	        if(word.charAt(i) != word.charAt(len -1 -i)){
	            return false;
	        }
	    }
	    return true;
	}
}
