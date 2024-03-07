import java.util.*;

class Solution
{
    public int solution(String s)
    {
        
        int answer = 1;
        char[] words = s.toCharArray();
        for(int i=1; i<words.length -1; i++){
            if(words[i-1] == words[i+1]){
                int count = 1;
                int max = Math.min(i, words.length -1 -i);
                for(int j=1; j<= max; j++){
                    if(words[i-j] == words[i+j]){
                        count += 2;
                    }else{
                        break;
                    }
                }
                answer = Math.max(answer, count);
            }
        }
        
        for(int i=0; i<words.length -1; i++){
            if(words[i] == words[i+1]){
                int count = 2;
                int max = Math.min(i, words.length-2-i);
                for(int j=1; j<= max; j++){
                    if(words[i-j] == words[i+1+j]){
                        count += 2;
                    }else{
                        break;
                    }
                }
                answer = Math.max(answer, count);
            }
        }


        return answer;
    }
}