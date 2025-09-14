import java.util.*;

class Solution {
    
    static class Friend {
        String name;
        int presentPoint;
        Map<String, Integer> relationship;
        
        Friend(String name){
            this.name = name;
            relationship = new HashMap<>();
        }
        
        public void receiveFrom(String name){
            presentPoint -= 1;
            relationship.put(name, relationship.getOrDefault(name, 0) -1);
        }
        
        public void sentTo(String name){
            presentPoint += 1;
            relationship.put(name, relationship.getOrDefault(name, 0) +1);
        }
        
        public int getPresentPoint(){
            return presentPoint;
        }
        
        public int getPresentCnt(){
            return (int) kakaoFriends.stream().map(x -> x.name).filter(x -> 
                relationship.getOrDefault(x,0) > 0 || 
                    (relationship.getOrDefault(x, 0) == 0 && presentPoint > kakaoFriends.get(indexs.get(x)).getPresentPoint())
            ).count();
        }
        
    }
    
    static List<Friend> kakaoFriends = new ArrayList<>();
    static Map<String, Integer> indexs = new HashMap<>();
    
    public int solution(String[] friends, String[] gifts){
        
        for(String friend : friends){
            kakaoFriends.add(new Friend(friend));
            indexs.put(friend, kakaoFriends.size()-1);
        }
        
        StringTokenizer st;
        String from;
        String to;
        for(String gift : gifts){
            st = new StringTokenizer(gift);
            from = st.nextToken();
            to = st.nextToken();
            kakaoFriends.get(indexs.get(from)).sentTo(to);
            kakaoFriends.get(indexs.get(to)).receiveFrom(from);
        }
        
        int answer = 0;
        for(Friend friend : kakaoFriends){
            answer = Math.max(answer, friend.getPresentCnt());
        }
        return answer;
    }
}