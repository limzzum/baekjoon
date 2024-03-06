import java.util.*;
import java.io.*;

class Solution {
    static final int[] endGameBits = {1 << 6 | 1<< 7 | 1 << 8, 1 << 5 | 1 << 4 | 1 << 3,  1<<2 | 1<<1 | 1<< 0,
1<<2 | 1<<5 | 1<< 8, 1 << 1 | 1<< 4 | 1 <<7, 1 << 0 | 1 << 3 | 1 << 6,
                                     1<<0 | 1<<4 | 1<<8, 1<<2 | 1<<4 | 1 << 6};
    static int yesCnt = 0;
    static int noCnt = 0;
    
    public int solution(String[] board) {
        int yesBit = 0;
        int noBit= 0;
        int idx = 0;
        
        for(String word : board){
            for(char w : word.toCharArray()){
                if(w == 'O'){
                    yesCnt += 1;
                    yesBit = yesBit | (1 << idx);

                }else if(w == 'X'){
                    noCnt += 1;
                    noBit = noBit | (1 << idx);
                }
                idx += 1;
            }
        }

        int answer = 1;
        if(isUnbalancedGame() || isEndGame(yesBit, noBit)){
            answer = 0;   
        }
        
        return answer;
    }
    
    private static boolean isUnbalancedGame(){

        if(yesCnt - noCnt <= -1 || yesCnt - noCnt > 1){
            return true;
        }
        return false;
    }
    
    private static boolean isEndGame(int yesBit, int noBit){
        int yCnt = 0;
        int nCnt = 0;
        for(int bit : endGameBits){
            if((yesBit & bit) == bit){
                yCnt += 1;
            } 
            if((noBit & bit) == bit){
                nCnt += 1;
            }
        }
    if((yCnt > 0 && nCnt > 0) || (yCnt > 0 && yesCnt - noCnt !=1) 
           || (nCnt > 0 && yesCnt - noCnt != 0) ){
            return true;
        }
        return false;
        

    }
    
}