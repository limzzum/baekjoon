import java.util.*;

class Solution {
    static char[][] result = {{'R', 'T'}, {'C', 'F'}, {'J', 'M'}, {'A', 'N'}};
    public String solution(String[] survey, int[] choices) {
        
        char[] input;
        char[] point = new char[26];
        for(int i=0; i<survey.length; i++){
            input = survey[i].toCharArray();
            if(choices[i] < 4){
                point[input[0]-'A'] += 4 - choices[i];
            }else {
                point[input[1] - 'A'] += choices[i] - 4;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<result.length; i++){
            if(point[result[i][0]-'A'] >= point[result[i][1]-'A']){
                sb.append(result[i][0]);
            }else {
                sb.append(result[i][1]);
            }
        }
        
        return sb.toString();
    }
}