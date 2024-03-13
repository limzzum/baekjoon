import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Main
{
    static Map<String, Boolean> isOutCar = new HashMap<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    Queue<String> cars = new ArrayDeque<>();
	    int N = Integer.parseInt(br.readLine());

	    for(int i=0; i<N; i++){
	        cars.add(br.readLine());
	    }
	    
	    int cnt = 0;
	    for(int i=0; i<N; i++){
	        String car = br.readLine();
	        while(isOutCar.containsKey(cars.peek())){
	            cars.poll();
	        }
	        if(cars.peek().equals(car)){
	            cars.poll();
	        }else {
	            cnt += 1;
	            isOutCar.put(car,true);
	        }
	    }
	    
	    System.out.println(cnt);
	    

	}
	
}
