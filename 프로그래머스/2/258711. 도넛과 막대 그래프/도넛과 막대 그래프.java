import java.util.*;
import java.io.*;

class Solution {
    
    static List<Integer>[] inEdges = new List[1_000_001];
    static List<Integer>[] outEdges = new List[1_000_001];
    static Set<Integer> allNodes = new HashSet<>();
    static Set<Integer> startNodes = new HashSet<>();
    static int middleNode;
    static int[] answer = new int[4];
    
    public int[] solution(int[][] edges) {

        int a,b;
        for(int[] edge : edges){
            connect(edge[0], edge[1]);
        }
        
        for(int i=1; i <= 1_000_000; i++){
            if(outEdges[i] == null || outEdges[i].size() <2){
                continue;
            }
            if(inEdges[i] != null){
                continue;
            }
            middleNode = i;
            answer[0] = middleNode;
            for(int j=0; j<outEdges[middleNode].size(); j++){
                checkGraph(outEdges[middleNode].get(j));
            }
            break;
        }

        return answer;
    }
    
    private static void connect(int from, int to){
        if(outEdges[from] == null){
            outEdges[from] = new ArrayList<>();
        }
        if(inEdges[to] == null){
            inEdges[to] = new ArrayList<>();
        }
        outEdges[from].add(to);
        inEdges[to].add(from);
    }
    
    private static void checkGraph(int node){
        dfs(node, node);
    }
    
    private static void dfs(int start, int cur){
        if(outEdges[cur] == null){
            answer[2] += 1;
            return;
        }
        if(outEdges[cur].size() > 1){
            answer[3] += 1;
            return;
        }
        if(start == outEdges[cur].get(0)){
            answer[1] += 1;
            return;
        }
        dfs(start, outEdges[cur].get(0));
    }
    
}