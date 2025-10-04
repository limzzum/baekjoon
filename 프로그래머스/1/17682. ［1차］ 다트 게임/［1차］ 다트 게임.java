import java.util.*;

class Solution {
    
    static Set<Character> scores = Set.of('0', '1', '2', '3', '4', '5', '6', '7', '8', '9');
    static Map<Character, Integer> multiScore = Map.of('S', 1, 'D', 2, 'T', 3);
    
    public int solution(String dartResult) {
        char[] results = dartResult.toCharArray();
        int answer = 0;
        int preScore = 0;
        int score = 0;
        for(int i=0; i<results.length; i++){
            if(scores.contains(results[i])){
                if(score != 0){
                    preScore = score;
                    answer += score;
                    score = 0;
                }
                
                int num = Integer.parseInt(String.valueOf(results[i]));
                if(scores.contains(results[i+1])){
                    num = 10;
                    i+= 1;
                }
                score = (int) Math.pow(num, multiScore.getOrDefault(results[i+1], 1));
                i += 1;
            }else {
                if(results[i] == '*'){
                    answer += preScore;
                    score *= 2;
                }else {
                    score *= -1;
                }
            }
        }
        answer += score;
        return answer;
    }
}