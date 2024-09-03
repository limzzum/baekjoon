import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int A, B;
    static List<Integer> primes;
    static Set<Integer> primesSet = new HashSet<>();
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        init();

        for(int i=A; i<=B; i++){
            if(primesSet.contains(count(i))){
                answer += 1;
            }
        }
        System.out.println(answer);

    }

    private static void init(){
        primes = new ArrayList<>();
        for(int i=2; i<=B; i++){
            if(isPrime(i)){
                primes.add(i);
                primesSet.add(i);
            }
        }
    }

    private static boolean isPrime(int n){
        if(n == 2){
            return true;
        }
        for(int i=2; i<= Math.sqrt(n); i++){
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static int count(int n){
        int idx = 0;
        int count = 0;
        while(n > 1){
            if(n % primes.get(idx) == 0){
                n /= primes.get(idx);
                count += 1;
                continue;
            }
            idx += 1;
        }
        return count;
    }

}
