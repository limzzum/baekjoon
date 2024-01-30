import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N, K;
    static List<Character>[] words;
    static int answer;
    static boolean[] isLearn = new boolean[26];

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        words = new ArrayList[N];

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            words[i] = new ArrayList();
            for (int j = 4; j < word.length() - 4; j++) {
                words[i].add(word.charAt(j));
            }
        }

        if(K < 5){
            System.out.println(0);
            return;
        }
        if(K==26){
            System.out.println(N);
            return;
        }
        K -= 5;

        HashSet<Character> learnWords = new HashSet<>();
        init();
        dfs(0, 0);
        System.out.println(answer);

    }

    private static void init() {
        isLearn['a' - 'a'] = true;
        isLearn['n' - 'a'] = true;
        isLearn['t' - 'a'] = true;
        isLearn['i' - 'a'] = true;
        isLearn['c' - 'a'] = true;
    }
    private static void dfs(int start, int cnt){
        if(cnt + 1 > K){
            answer = Math.max(answer, getWordCnt());
            return;
        }

        for (int i = start; i < 26; i++) {
            if(isLearn[i]){
                continue;
            }
            isLearn[i] = true;
            dfs(i+1, cnt + 1);
            isLearn[i] = false;
        }
    }
    private static int getWordCnt(){
        int cnt = 0;
        loop: for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].size(); j++) {
                if(!isLearn[words[i].get(j)-'a']){
                    continue loop;
                }
            }
            cnt += 1;
        }
        return cnt;
    }

}
