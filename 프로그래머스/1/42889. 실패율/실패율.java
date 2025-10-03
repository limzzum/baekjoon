import java.util.*;

class Solution {
    
    static class Stage {
        int stage;
        float failPercent;
        public Stage(int stage, float failPercent){
            this.stage = stage;
            this.failPercent = failPercent;
        }
    }
    static int[] stageFailCnt;
    static int[] stageTotalCnt;
    static Queue<Stage> pq = new PriorityQueue<>(Comparator.comparing((Stage stage) -> -stage.failPercent).thenComparing(stage -> stage.stage));
    
    public int[] solution(int N, int[] stages) {
        stageFailCnt = new int[N+1];
        stageTotalCnt = new int[N+1];
        Arrays.sort(stages);
        for(int i=0; i<stages.length; i++){
            if(stages[i] > N){
                continue;
            }
            stageFailCnt[stages[i]] += 1;
            stageTotalCnt[stages[i]] = Math.max(stageTotalCnt[stages[i]], stages.length - i);
        }
        
        for(int i=1; i<=N; i++){
            pq.add(new Stage(i, (float) stageFailCnt[i]/stageTotalCnt[i]));
        }
        
        
        int[] answer = new int[N];
        int idx = 0;
        while(!pq.isEmpty()){
            answer[idx] = pq.poll().stage;
            idx += 1;
        }
        return answer;
    }
}