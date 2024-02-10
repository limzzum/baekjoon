import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    static String A;
    static String B;
    static Deque<Character> deque = new ArrayDeque<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        A = br.readLine();
        B = br.readLine();
        char[] bWords = B.toCharArray();
        for (char bWord : bWords) {
            deque.add(bWord);
        }
        boolean isPossible = dfs(false);
        if(!isPossible){
            System.out.println(0);
        }
    }

    private static boolean dfs(boolean isReversed){
        if(deque.size() == A.length()){
            Deque<Character> temp = new ArrayDeque<>(deque);
            return isAnswer(temp, isReversed);
        }
        boolean isEnd;
        if(isReversed){
            if(deque.peekLast() == 'B'){
                Character c = deque.pollLast();
                isEnd = dfs(!isReversed);
                if(isEnd){
                    return true;
                }
                deque.addLast(c);
            }
            if(deque.peekFirst() == 'A'){
                Character c = deque.pollFirst();
                isEnd = dfs(isReversed);
                if(isEnd){
                    return true;
                }
                deque.addFirst(c);
            }
        }else {
            if(deque.peekFirst() == 'B'){
                Character c = deque.pollFirst();
                isEnd = dfs(!isReversed);
                if(isEnd){
                    return true;
                }
                deque.addFirst(c);
            }
            if(deque.peekLast() == 'A'){
                Character c = deque.pollLast();
                isEnd = dfs(isReversed);
                if(isEnd){
                    return true;
                }
                deque.addLast(c);
            }
        }

        return false;
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
        System.out.println(1);
        return true;
    }
}
