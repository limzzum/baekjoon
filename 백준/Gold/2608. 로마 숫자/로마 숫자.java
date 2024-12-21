import java.util.*;
import java.io.*;

public class Main{
    
    static class Node {
        int sum;
        String word;
        public Node(int sum, String word){
            this.sum = sum;
            this.word = word;
        }
    }
    
    static Map<String, Integer> values = new HashMap<>(){{
        put("M", 1000);
        put("I", 1);
	    put("V", 5);
	    put("X", 10);
	    put("L", 50);
	    put("C", 100);
	    put("D", 500);
	    
	    put("IV", 4);
	    put("IX", 9);
	    put("XL", 40);
	    put("XC", 90);
	    put("CD", 400);
	    put("CM", 900);
    }};
    static List<String> ascendingWords = new ArrayList<>(List.of("IV", "IX", "XL", "XC", "CD", "CM"));
    static Queue<Node> queue = new PriorityQueue<>(Comparator.comparing((Node node)-> -node.sum).thenComparing(node -> node.word.length()));
    static int sum;
    static String answer;
    
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    String words;
	    boolean[] isUsed;
	    int idx;
	    for(int i=0; i<2; i++){
	        words = br.readLine();
	        isUsed = new boolean[words.length()];
	        for(int j=0; j<ascendingWords.size(); j++){
	            idx = words.indexOf(ascendingWords.get(j));
	            if(idx >= 0){
	                isUsed[idx] = true;
	                isUsed[idx+1] = true;
	                sum += values.get(ascendingWords.get(j));
	            }
	        }
	        for(int j=0; j<words.length(); j++){
	            if(!isUsed[j]){
	                sum += values.get(String.valueOf(words.charAt(j)));
	            }
	        }
	    }
	    queue.add(new Node(0, ""));
	    while(!queue.isEmpty()){
	        Node node = queue.poll();
	        if(node.sum == sum){
	            answer = node.word;
	            break;
	        }
	        
	        for(Map.Entry<String, Integer> entry : values.entrySet()){
	            if(node.sum + entry.getValue() > sum){
	                continue;
	            }
	            if(!canAdd(node.word, entry.getKey())){
	                continue;
	            }
                queue.add(new Node(node.sum + entry.getValue(), node.word + entry.getKey()));
            }
        }
	    
	    System.out.println(sum);
	    System.out.println(answer);
	}
	
	private static boolean canAdd(String from, String add){
	    if(add.equals("IV")){
	        if(from.indexOf("IV") >= 0 || from.indexOf("IX") >= 0){
	            return false;
	        }
	    }else if(add.equals("IX")){
	        if(from.indexOf("IX") >= 0 || from.indexOf("IV") >= 0){
	            return false;
	        }
	    }else if(add.equals("XL")){
	        if(from.indexOf("XL") >= 0 || from.indexOf("XC") >= 0){
	            return false;
	        }
	    }else if(add.equals("XC")){
	        if(from.indexOf("XC") >= 0 || from.indexOf("XL") >= 0){
	            return false;
	        }
	    }else if(add.equals("CD")){
	        if(from.indexOf("CD") >= 0 || from.indexOf("CM") >= 0){
	            return false;
	        }
	    }else if(add.equals("CM")){
	        if(from.indexOf("CM") >= 0 || from.indexOf("CD") >= 0){
	            return false;
	        }
	    }
	    return true;
	}
}
