import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Main {

    static int N;
    static int maxLen = 1;
    static List<String> answers;
    static List<String> words = new ArrayList();
    static Map<String, Integer> miniWordMap= new HashMap<>();
    static int aIdx;
    
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    N = Integer.parseInt(br.readLine());
	    
	    for(int i=0; i<N; i++){
	        words.add(br.readLine());
	    }
	    
	    answers = List.of(words.get(0), words.get(1));
	    aIdx = N;
	    for(int i=0; i<N; i++){
	        for(int j= maxLen; j <= words.get(i).length(); j++){
	            String piece = words.get(i).substring(0, j);
	            if(miniWordMap.containsKey(piece)){
	                int idx = miniWordMap.get(piece);
	                int len = piece.length();
	                if(len > maxLen || idx < aIdx){
	                    aIdx = idx;
	                    maxLen = len;
	                    answers = List.of(words.get(idx), words.get(i));
	                }
	            }else{
	                miniWordMap.put(piece, i);
	            }
	        }
	    }
	    
	    System.out.println(answers.get(0));
	    System.out.println(answers.get(1));

    }
}
