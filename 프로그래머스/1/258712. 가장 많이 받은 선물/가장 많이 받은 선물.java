import java.util.*;
import java.util.stream.*;
import java.io.*;

class Solution {

    static int answer = 0;
    
    static Map<String, Map<String, Integer>> map = new HashMap(); 
    static Map<String, Integer> score = new HashMap(); 
    static StringTokenizer st;

    public int solution(String[] friends, String[] gifts) {
        
        for(String friend: friends){
            map.put(friend, new HashMap());
            for(String f: friends){
                if(friend.equals(f)){
                    continue;
                }
                map.get(friend).put(f, 0);
            }
        }
        
        for(String gift : gifts){
            st = new StringTokenizer(gift);
            String from = st.nextToken();
            String to = st.nextToken();
            
            score.put(from, score.getOrDefault(from, 0) +1);
            score.put(to, score.getOrDefault(to, 0) -1);
            
            map.get(from).put(to, map.get(from).get(to) + 1);
            map.get(to).put(from, map.get(to).get(from) - 1);

        }
        
        answer = map.entrySet().stream().mapToInt(entry -> {
        return (int) entry.getValue().entrySet().stream().filter(e-> e.getValue() > 0 || (e.getValue() == 0 && score.getOrDefault(entry.getKey(),0) > score.getOrDefault(e.getKey(), 0))).count();
    }).max().orElse(0);

        return answer;
    }
}