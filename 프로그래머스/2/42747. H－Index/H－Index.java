import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;

        int N = citations.length;
        
        int left = 0;
        int right = N;
        int mid;
        int cnt;
        while(left <= right){
            mid = (left + right) /2;
            cnt = 0;
            for(int i=0; i<N; i++){
                if(citations[i] >= mid){
                    cnt += 1;
                }
            }
            
            if(cnt >= mid){
                answer = Math.max(answer, mid);
                left = mid + 1;
            }else {
                right = mid -1;
            }
        }
        
        return answer;
    }
}