/*
상자 개수 = 총 높이 - 구하려는 곳 높이
구하려는 상자의 열의 최상단이 채워지려면 상자가 최소 몇 개인지, 주어진 상자 개수보다 많으면 상자 개수 - 1
*/

class Solution {
    public int solution(int n, int w, int num) {
        int height = (int) Math.ceil((float)n / w);
        int targetHeight = (int) Math.ceil((float) num / w);
        int answer = height - targetHeight + 1;
        
        int targetCol = num % w;
        if(targetCol == 0) {
            targetCol = w;
        }
        if(targetHeight % 2 == 0){
            targetCol = w - targetCol + 1;
        }
        if(height % 2 == 0){
            if(!(n % w == 0 || n % w >= w-targetCol+1)){
                answer -= 1;
            }
        }else {
            if(!(n % w == 0 || n % w >= targetCol)){
                answer -= 1;
            }
        }
        return answer;
    }
}