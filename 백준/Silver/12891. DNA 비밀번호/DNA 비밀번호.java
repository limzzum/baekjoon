import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int[] count = new int [26];
    static String[] condition;
    static int answer;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        char [] word = br.readLine().toCharArray();
        condition = br.readLine().split(" ");

        count[0] = Integer.parseInt(condition[0]);
        count['C'-'A'] = Integer.parseInt(condition[1]);
        count['G'-'A'] = Integer.parseInt(condition[2]);
        count['T'-'A'] = Integer.parseInt(condition[3]);

        for (int i=0; i<K; i++){
                count[word[i] - 'A'] -= 1;
        }

        if(isSafe()){
            answer +=1;
        }

        for (int i=1; i<= N - K; i++){
            count[word[i-1]-'A'] += 1;
            count[word[K+i-1]-'A'] -= 1;

            if (isSafe()){
                answer +=1;
            }
        }
        System.out.println(answer);
    }

    private static boolean isSafe(){
            if(count[0]>0){
                return false;
            }
            if(count['C'-'A']>0){
                return false;
            }
            if(count['G'-'A']>0){
                return false;
            }
            if(count['T'-'A']>0){
                return false;
            }
            return true;

    }
}
