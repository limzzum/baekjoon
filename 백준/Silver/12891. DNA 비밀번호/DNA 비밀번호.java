import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int[] count = new int ['T'-'A'+1];
    static String key = "ACGT";
    static String[] condition;
    static int answer;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        String [] word = br.readLine().split("");
        condition = br.readLine().split(" ");

        for (int i=0; i<K; i++){
            if(key.contains(word[i])){
                count[word[i].charAt(0) - 'A'] += 1;
            }
        }

        if(isSafe()){
            answer +=1;
        }

        for (int i=1; i<= N - K; i++){
            if(key.contains(word[i-1])){
                count[word[i-1].charAt(0)-'A'] -= 1;
            }
            if(key.contains(word[K+i-1])){
                count[word[K+i-1].charAt(0)-'A'] += 1;
            }

            if (isSafe()){
                answer +=1;
            }
        }
        System.out.println(answer);
    }

    private static boolean isSafe(){
            if(count[0]< Integer.parseInt(condition[0])){
                return false;
            }
            if(count['C'-'A']< Integer.parseInt(condition[1])){
                return false;
            }
            if(count['G'-'A']< Integer.parseInt(condition[2])){
                return false;
            }
            if(count['T'-'A']< Integer.parseInt(condition[3])){
                return false;
            }
            return true;

    }
}
