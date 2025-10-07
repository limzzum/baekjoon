import java.util.*;

class Solution {
    static int N;
    static int[] infos;
    static int[] answer = new int[11];
    static boolean lianWin;
    static int diff;
    public int[] solution(int n, int[] info) {
        N = n;
        infos = info;
        dfs(9,0,0,0,new int[11]);
        if(!lianWin){
            return new int[]{-1};
        }
        return answer;
    }
    
    private static void dfs(int idx, int cnt, int apeachSum, int lianSum, int[] result){
        if(cnt > N){
            return;
        }
        if(idx == -1){
            if(lianSum > apeachSum && lianSum - apeachSum > diff){
                lianWin = true;
                diff = lianSum - apeachSum;
                for(int i=0; i<11; i++){
                    answer[i] = result[i];               
                }
                answer[10] += N - cnt;
            }
            return;
        }
        

        int lianCnt = infos[idx] + 1;
        result[idx] = lianCnt;
        dfs(idx - 1, cnt + lianCnt, apeachSum, lianSum + 10-idx, result);
        result[idx] = 0;
        if(infos[idx] > 0){
            dfs(idx - 1, cnt, apeachSum + 10 - idx, lianSum, result);
        }else {
            dfs(idx - 1, cnt, apeachSum, lianSum, result);
        }
    }
}