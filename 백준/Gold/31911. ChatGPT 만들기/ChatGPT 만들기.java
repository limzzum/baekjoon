import java.util.*;
import java.io.*;

public class Main{
    
    static class Word{
        char word;
        char afterWord;
        int[] wordCnt;
        public Word(char word){
            this.word = word;
            this.afterWord = 'z';
            this.wordCnt = new int[28];
        }
        
        public void add(char word){
            int idx = word-'a'+2;
            if(word == '-'){
                idx = 0;
            }else if(word == ']'){
                idx = 1;
            }
            wordCnt[idx] += 1;
            
            int curIdx = afterWord - 'a'+2;
            if(afterWord == '-'){
                curIdx = 0;
            }else if(afterWord == ']'){
                curIdx = 1;
            }

            if(wordCnt[idx] >= wordCnt[curIdx]){
                if(wordCnt[idx] == wordCnt[curIdx] && idx > curIdx){
                    return;
                }
                afterWord = word;
            }
        }
    }
    static int N, M;
    static long K;
    static List<Word> words = new ArrayList<>();
    static Map<Character, Integer> wordsKey = new HashMap<>();
    static char curWord = '[';
    static int[] visitIdx = new int[28];
    
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Long.parseLong(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        for(int i=0; i<N; i++){
            char[] inputWord = br.readLine().toCharArray();
            for(int j=1; j<inputWord.length; j++){
                if(!wordsKey.containsKey(inputWord[j-1])){
                    words.add(new Word(inputWord[j-1]));
                    wordsKey.put(inputWord[j-1], words.size()-1);
                }
                words.get(wordsKey.get(inputWord[j-1])).add(inputWord[j]);
            }
        }
        StringBuilder sb = new StringBuilder(curWord);
        int wordIdx;
        int cycleIdx = 0;
        sb.append('[');
        for(int i=1; i<K+M-1; i++){
            curWord = words.get(wordsKey.get(curWord)).afterWord;
            if(curWord == ']'){
                sb.append(curWord);
                sb.append(".");
                cycleIdx = i+1;
                break;
            }
            wordIdx = curWord - 'a'+2;
            if(curWord == '-'){
                wordIdx = 0;
            }
            if(visitIdx[wordIdx]> 0){
                cycleIdx = visitIdx[wordIdx];
                break;
            }
            sb.append(curWord);

            visitIdx[wordIdx] = i;
        }
        char[] word = sb.toString().toCharArray();
        sb.setLength(0);
        int cycleCnt = word.length - cycleIdx;
        int start = (int) K-1;
        if(K> word.length){
            start = cycleIdx;
            if(cycleCnt > 0){
            start = cycleIdx + (int) ((K-1 - cycleIdx)%cycleCnt);

            }
        }

        int max = Math.min(word.length, start+M);
        for(int i=start; i<max; i++){
            sb.append(word[i]);
        }

        int idx = 0;
        if(cycleCnt == 0){
            cycleCnt = 1;
        }
        for(int i=word.length; i<start+M; i++){
            idx = cycleIdx + (i-word.length)%cycleCnt;
            sb.append(word[idx]);
        }
        System.out.print(sb);
    }
}
