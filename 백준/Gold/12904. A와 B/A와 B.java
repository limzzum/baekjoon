import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    static String A;
    static String B;
    static Deque<Character> deque = new ArrayDeque<>();
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        A = br.readLine();
        B = br.readLine();
        char[] bWords = B.toCharArray();
        for (char bWord : bWords) {
            deque.add(bWord);
        }
        dfs(false);
        System.out.println(answer);
    }

    private static void dfs(boolean isReversed){
        if(deque.size() == A.length()){
            Deque<Character> temp = new ArrayDeque<>(deque);
            if(isAnswer(temp, isReversed)){
                answer = 1;
            }
            return;
        }
        Character c;
        if(isReversed){
            c = deque.pollFirst();
        }else{
            c = deque.pollLast();
        }
        if(c == 'B'){
            dfs(!isReversed);
        }else{
            dfs(isReversed);
        }
    }

    private static boolean isAnswer(Deque<Character> deque, boolean isReversed) {
        int idx = 0;
        char word;
        while (!deque.isEmpty()){
            if(isReversed) {
                word = deque.pollLast();
            }else{
                word = deque.pollFirst();
            }
            if(word != A.charAt(idx)){
                return false;
            }
            idx += 1;
        }
        return true;
    }
}
