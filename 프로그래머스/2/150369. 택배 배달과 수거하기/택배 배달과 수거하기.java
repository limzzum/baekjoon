class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int dPlus = 0;
        int pPlus = 0;
        int diff;
        for(int i= deliveries.length-1; i>=0; i--){
            if(deliveries[i] == 0 && pickups[i] == 0){
                continue;
            }
            if(dPlus != 0){
                deliveries[i] -= dPlus;
                dPlus = 0;
            }
            if(pPlus != 0){
                pickups[i] -= pPlus;
                pPlus = 0;
            }
            while(deliveries[i] > 0 || pickups[i] > 0){
                answer += i+1;
                deliveries[i] -= cap;
                pickups[i] -= cap;
            }
            
            if(deliveries[i] < 0){
                dPlus += deliveries[i] * -1;
            }
            if(pickups[i] < 0){
                pPlus += pickups[i] * -1;
            }
        }
        return answer * 2;
    }
}