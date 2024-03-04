import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long sum = 0;
        Map<Integer, Integer> count = new HashMap<>();
        List<Integer> numbers = new ArrayList<>();
        for (int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());
            numbers.add(num);
            sum += num;
            count.put(num, count.getOrDefault(num, 0)+1);
        }

        double average = (double) sum/N;
        long aver =Math.round(average);

        Collections.sort(numbers);
        int center = numbers.get((N/2));

        int bigCount = 0;

        for(int cnt : count.values()){
            if(cnt > bigCount){
                bigCount = cnt;
            }
        }

        List<Integer> bigNums = new ArrayList<>();
        for (int key : count.keySet()) {
            if(count.get(key) == bigCount){
                bigNums.add(key);
            }
        }
        Collections.sort(bigNums);
        int big = bigNums.get(0);
        if(bigNums.size()>1){
            big = bigNums.get(1);
        }

        int range = numbers.get(N-1) - numbers.get(0);

        System.out.println(aver);
        System.out.println(center);
        System.out.println(big);
        System.out.println(range);

    }
}
