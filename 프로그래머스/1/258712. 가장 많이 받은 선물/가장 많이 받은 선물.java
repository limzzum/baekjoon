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
        int[] cnt = {0};
        map.forEach((key, value)->{
            cnt[0] = 0;
            value.forEach((k, v)->{
                if(v > 0){
                    cnt[0] += 1;
                }else if( v == 0){
                    if(score.getOrDefault(key, 0)> score.getOrDefault(k,0)){
                        cnt[0] += 1;
                    }
                }
            });
                answer = Math.max(answer, cnt[0]);
        });
        
        return answer;
    }
}