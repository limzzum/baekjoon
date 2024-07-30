import java.util.*;
import java.io.*;

public class Main{
    
    static int N;
    static List<Integer> nums = new ArrayList<>();
    static int total;
    static int left;
    static int right;
    static int sum;
    static int maxValue;
    static int answer;
	
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num;
        for(int i=0; i<N; i++){
            num = Integer.parseInt(st.nextToken());
            sum += num;
            maxValue = Math.max(maxValue, num);
            right = Math.max(right, num);
            nums.add(num);
        }
        
        total = Integer.parseInt(br.readLine());
        if(sum <= total){
            System.out.print(maxValue);
            return;
        }
        
        int mid;
        while(left <= right){
            mid = (left + right) /2;
            sum = 0;
            maxValue = 0;
            for(int i=0; i<N; i++){
                maxValue = Math.max(maxValue, Math.min(mid, nums.get(i)));
                sum += Math.min(mid, nums.get(i));
                if(sum > total){
                    break;
                }
            }
            
            if(sum <= total){
                answer = Math.max(answer, maxValue);
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        System.out.print(answer);
	}
	

}
