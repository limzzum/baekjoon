import java.util.*;
import java.io.*;
import java.util.stream.*;

class Solution {
    static Map<String, Integer> map = new HashMap();
    static int max;
    static List<String> answer = new ArrayList();

    public List<String> solution(String[] orders, int[] course) {
        
        char[][] words = new char[orders.length][];
        int idx = 0;
        for(String order: orders){
            words[idx] = order.toCharArray();
            Arrays.sort(words[idx++]);
        }
        
            for(int c : course){
                max = 0;
                for(char[] word: words){          
                comb(word, 0,0,new char[c]);     
            }   

                if(max >= 2){
                    answer.addAll(map.entrySet().stream().filter(entry ->
                        entry.getValue() == max && entry.getKey().length() == c
                    ).map(entry -> entry.getKey()).
                                  collect(Collectors.toList()));
                }
                
        }
        answer.sort(Comparator.comparing(a -> a));
        
        return answer;
    }
    
    private static void comb(char[] words,int start, int cur, char[] answer){
        if(cur == answer.length){
            String ans = String.valueOf(answer);
            map.put(ans, map.getOrDefault(ans, 0) + 1);
            
            max = Math.max(max, map.get(ans));
            return;
        }
        
        for(int i=start; i<words.length; i++){
            answer[cur] = words[i];
            comb(words,i + 1, cur + 1, answer);
        }
    }
}