import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer,Integer> ranking = new TreeMap<>();
        int N = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split(" ");

        int idx =0;
        int[] numbers = new int[N];

        for(String st:line){
            int n = Integer.parseInt(st);
            numbers[idx] = n;
            idx += 1;
            if(!ranking.containsKey(n)){
                ranking.put(n,0);
            }
        }
       
        int rank = 0;
        for(int key:ranking.keySet()){
            ranking.put(key,rank);
            rank+=1;
        }

        StringBuilder sb = new StringBuilder();
        for(int num: numbers){
            sb.append(ranking.get(num)).append(" ");
        }
        System.out.println(sb);
    }
}
