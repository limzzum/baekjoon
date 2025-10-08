import java.util.*;

class Solution {
    
    static int[][] dices;
    static boolean[] isSelected;
    static int maxWinCnt;
    static int[] answer;
    static List<Integer> aSums = new ArrayList<>();
    static List<Integer> bSums = new ArrayList<>();
    
    public int[] solution(int[][] dice) {
        dices = dice;
        answer = new int[dice.length/2];
        isSelected = new boolean[dice.length];
        dfs(0, 0, new int[dice.length/2]);
        Arrays.sort(answer);
        return answer;
    }
    
    private static void dfs(int start, int idx, int[] selected){
        if(idx == selected.length){
            answer(selected);
            return;
        }
        if(idx == 0 && start >= dices.length/2){
            return;
        }
        for(int i=start; i<dices.length; i++){
            if(isSelected[i]){
                continue;
            }
            isSelected[i] = true;
            selected[idx] = i;
            dfs(i + 1, idx + 1, selected);
            isSelected[i] = false;
        }
    }
    
    private static void answer(int[] selected){
        aSums.clear();
        bSums.clear();
        int[] unSelected = new int[selected.length];
        int idx = 0;
        for(int i=0; i<dices.length; i++){
            if(!isSelected[i]){
                unSelected[idx] = i;
                idx += 1;
            }
        }
        calSum(0, selected, unSelected, 0, 0);

        aSums.sort(Comparator.comparing(a -> a));
        bSums.sort(Comparator.comparing(a -> a));
        int aWinCnt = getAWinCnt();
        int bWinCnt = aSums.size() * aSums.size() - aWinCnt;
        if(aWinCnt > maxWinCnt){
            for(int i=0; i<selected.length; i++){
                answer[i] = selected[i] + 1;
            }
            maxWinCnt = aWinCnt;
        }
        // if(bWinCnt > maxWinCnt){
        //     for(int i=0; i<selected.length; i++){
        //         answer[i] = unSelected[i] + 1;
        //     }
        //     maxWinCnt = bWinCnt;
        // }
    }
    
    private static void calSum(int idx, int[] selected, int[] unSelected, int aSum, int bSum){
        if(idx == selected.length){
            aSums.add(aSum);
            bSums.add(bSum);
            return;
        }
        for(int i=0; i<6; i++){
            calSum(idx+1, selected, unSelected, aSum + dices[selected[idx]][i], bSum + dices[unSelected[idx]][i]);
        }
    }
    
    private static int getAWinCnt(){
        int totalCnt = 0;
        int left = 0;
        int cnt = 1;
        for(int i=0; i<aSums.size(); i++){
            left = Math.max(1, cnt) -1;
            cnt = 0;
            int right = bSums.size() - 1;
            int mid = (left + right) / 2;
            while(left <= right){
                mid = (left + right) / 2;
                if(aSums.get(i) > bSums.get(mid)){
                    cnt = Math.max(cnt, mid + 1);
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }
            totalCnt += cnt;
        }
        return totalCnt;
    }
}