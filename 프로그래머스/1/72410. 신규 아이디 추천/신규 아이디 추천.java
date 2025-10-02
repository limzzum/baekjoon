import java.util.*;

class Solution {
    public String solution(String new_id) {
        String answer = "";
        answer = getAnswer(new_id);
        
        return answer;
    }
    
    private String getAnswer(String word){
        String answer;
        answer = toLowerCase(word);
        answer = onlyAcceptedWord(answer);
        answer = twoDotToOneDot(answer);
        answer = trimDot(answer);
        answer = emptyWordToA(answer);
        answer = maxLength(answer);
        answer = leastLength(answer);
        return answer;
    }
    
    private String toLowerCase(String word){
        return word.toLowerCase();
    }
    
    private String onlyAcceptedWord(String word){
        return word.replaceAll("[^a-z0-9-_.]", "");
    }
    
    private String twoDotToOneDot(String word){
        return word.replaceAll("\\.{2,}","\\.");
    }
    
    private String trimDot(String word){
        return word.replaceAll("^\\.|\\.$", "");
    }
    
    private String emptyWordToA(String word){
        if(word == null || word.isEmpty()){
            return "a";
        }
        return word;
    }
    
    private String maxLength(String word){
        if(word.length() >= 16){
            return trimDot(word.substring(0, 15));
        }
        return word;
    }
    
    private String leastLength(String word){
        if(word.length() >= 3){
            return word;
        }
        return leastLength(word+word.charAt(word.length()-1));
    }
}