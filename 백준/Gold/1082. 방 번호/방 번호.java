import java.util.*;
import java.io.*;

public class Main{

    static class Number{
        int num;
        int price;
        public Number(int num, int price){
            this.num = num;
            this.price = price;
        }
    }
    
    static int N, M;
    static List<Number> numbers = new ArrayList<>();
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            numbers.add(new Number(i, Integer.parseInt(st.nextToken())));        
        }
        M = Integer.parseInt(br.readLine());
        
        numbers.sort(Comparator.comparing(a-> a.price));
        Number number = numbers.get(0);
        int len = M / number.price;
        M -= number.price * len;
        if(len > 1 && number.num == 0){
            if(N==1){
                System.out.println(0);
                return;
            }
            double diff = numbers.get(1).price - number.price;
            if(diff > M){
                int removeCnt = (int) Math.ceil((diff - M)/number.price);
                if(removeCnt >= len){
                    System.out.println(0);
                    return;
                }
                
                len -= removeCnt;
                M += number.price * removeCnt;
            }
        }
        
        int basePrice = number.price;
        numbers.sort(Comparator.comparing(a-> -a.num));
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<len; i++){
            for(int j=0; j<N; j++){
                Number num = numbers.get(j);
                if(M - (num.price - basePrice) >=0){
                    sb.append(num.num);
                    M -= (num.price - basePrice);
                    break;
                }
            }    
        }

        System.out.println(sb);
	}
}
