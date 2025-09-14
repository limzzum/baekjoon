import java.util.*;

class Solution {
    static class Node {
        int num;
        int index;
        Node(int num, int index){
            this.num = num;
            this.index = index;
        }
    }
    static Map<String, Integer> engToInt = new HashMap<>(){{
        put("zero", 0);
        put("one" , 1);
        put("two", 2);
        put("three" , 3);
        put("four", 4);
        put("five", 5);
        put("six", 6);
        put("seven", 7);
        put("eight", 8);
        put("nine", 9);
        put("0", 0);
        put("1", 1);
        put("2", 2);
        put("3", 3);
        put("4", 4);
        put("5", 5);
        put("6", 6);
        put("7", 7);
        put("8", 8);
        put("9", 9);
    }};
    
    static Queue<Node> nodes = new PriorityQueue<>(Comparator.comparing((Node x) -> x.index));
    static Map<String, Integer> startIndex = new HashMap<>();
    
    public int solution(String s) {
        int index;
        for(String key : engToInt.keySet()){
            index = s.indexOf(key);
            while(index >= 0){
                nodes.add(new Node(engToInt.get(key), index));
                startIndex.put(key, index+1);
                index = s.indexOf(key,startIndex.get(key));
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while(!nodes.isEmpty()){
            sb.append(String.valueOf(nodes.poll().num));
        }
        return Integer.parseInt(sb.toString());
    }
}