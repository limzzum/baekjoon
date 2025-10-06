import java.util.*;

class Solution {
    static Queue<Integer> queueOne = new ArrayDeque<>();
    static Queue<Integer> queueTwo = new ArrayDeque<>();
    
    public int solution(int[] queue1, int[] queue2) {
        long queue1Sum = 0;
        long queue2Sum = 0;
        for(int i=0; i<queue1.length; i++){
            queue1Sum += queue1[i];
            queue2Sum += queue2[i];
            queueOne.add(queue1[i]);
            queueTwo.add(queue2[i]);
        }

        int answer = 0;
        int queueOnePollCnt = 0;
        int queueTwoPollCnt = 0;
        int n;
        while(queueOnePollCnt < queue1.length*3 && queueTwoPollCnt < queue2.length*3){
            if(queue1Sum == queue2Sum){
                break;
            }
            if(queue1Sum > queue2Sum){
                n = queueOne.poll();
                queueTwo.add(n);
                queueOnePollCnt += 1;
                queue1Sum -= n;
                queue2Sum += n;
            }else {
                n = queueTwo.poll();
                queueOne.add(n);
                queueTwoPollCnt += 1;
                queue2Sum -= n;
                queue1Sum += n;
            }
            answer += 1;
        }
        if(queue1Sum != queue2Sum){
            return -1;
        }
        return answer;
    }
}