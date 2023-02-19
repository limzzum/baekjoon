
import java.io.*;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main{
    static int answer = 0;
    static int N;
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        getSumDecimal(N);
        System.out.println(answer);
    }

    private static boolean isDecimal(int num){
        if(num == 2){
            return true;
        }
        for(int i=2; i<=Math.sqrt(num); i++){
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static void getSumDecimal(int num){
        Queue<Integer> decimals = new LinkedList<>();
        int sum = 0;
        for(int i=num; i>=2; i--){
            if(isDecimal(i)){
                sum += i;
                decimals.add(i);
            }
            if(sum == N){
                answer +=1;
                sum -= decimals.poll();
            }
            if(sum > N){
                sum -= decimals.poll();
            }
        }
    }
}