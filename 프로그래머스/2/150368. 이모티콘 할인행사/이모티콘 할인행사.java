
class Solution {
    static int maxEmoticonPlusCnt;
    static int maxSaleAmount;
    static int[] answer = new int[2];
    static int[][] users;
    static int[] emoticons;
    
    public int[] solution(int[][] kUsers, int[] kEmoticons) {
        users = kUsers;
        emoticons = kEmoticons;
        dfs(0, new int[emoticons.length]);
        return answer;
    }
    
    private static void dfs(int idx, int[] selected){
        if(idx == selected.length){
            checkResult(selected);
            return;
        }
        for(int i=10; i<=40; i+=10){
            selected[idx] = i;
            dfs(idx + 1, selected);
        }
    }
    
    private static void checkResult(int[] selected){
        int plusCnt = 0;
        int totalSum = 0;
        for(int[] user : users){
            int sum = 0;
            for(int i=0; i<emoticons.length; i++){
                if(selected[i] >= user[0]){
                    sum += emoticons[i] / 100 * (100 - selected[i]);
                }
            }
            if(sum >= user[1]){
                plusCnt += 1;
            }else {
                totalSum += sum;
            }
        }
        if(plusCnt > maxEmoticonPlusCnt ||
            plusCnt == maxEmoticonPlusCnt && totalSum > maxSaleAmount){
            answer[0] = plusCnt;
            answer[1] = totalSum;
            maxEmoticonPlusCnt = answer[0];
            maxSaleAmount = answer[1];
        }
        
    }
}