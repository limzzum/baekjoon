import java.util.*;
import java.io.*;

public class Main{

    static int N;
    static Map<String, Integer> nicknameCnt = new HashMap<>();
    static Set<String> preWord = new HashSet<>();
    
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        String input;
        char[] words;
        boolean isDone;
        StringBuilder sb = new StringBuilder();
        StringBuilder answer = new StringBuilder();
        for(int i=0; i<N; i++){
            input = br.readLine();
            words = input.toCharArray();
            isDone = false;
            nicknameCnt.put(input, nicknameCnt.getOrDefault(input, 0) + 1);
            for(int j=0; j< words.length; j++){
                sb.append(words[j]);
                if(!isDone && !preWord.contains(sb.toString())){
                    isDone = true;
                    answer.append(sb);
                }
                preWord.add(sb.toString());
            }
            if(!isDone){
                if(nicknameCnt.get(input)> 1){
                    answer.append(input + nicknameCnt.get(input));
                }else {
                    answer.append(input);
                }
            }
            answer.append("\n");
            sb.setLength(0);
        }
        
        System.out.print(answer);
	}
}
