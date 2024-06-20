import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Main{

    static Map<Character, Integer> map = new HashMap<>();
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        init();
        int sum = getSum(br.readLine().toCharArray());
        if(isPrime(sum)){
            System.out.print("It is a prime word.");
        }else {
            System.out.print("It is not a prime word.");
        }
    }
    
    private static void init(){
        for(int i=0; i<26; i++){
            map.put((char)('a'+i), i + 1);
            map.put((char)('A'+i), 27 + i);
        }
    }
    
    private static int getSum(char[] words){
        return IntStream.range(0, words.length).map(i -> map.get(words[i])).sum();
    }
    
    private static boolean isPrime(int n){
        if(n == 1 || n == 2){
            return true;
        }
        
        for(int i=2; i<= Math.sqrt(n); i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
}
