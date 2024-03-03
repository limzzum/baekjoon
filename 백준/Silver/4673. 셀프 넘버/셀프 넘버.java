import java.io.*;
public class Main {
	static boolean [] selfNumber = new boolean[10000];
	
	public static void main(String[] agrs) {
			StringBuilder sb = new StringBuilder();
		for(int i=1; i<9975; i++) {
			toSelfNum(i);
		}
		for(int i=1; i<10000; i++) {
			if(selfNumber[i]==false) {
				sb.append(i+"\n");
			
			}
		}
		System.out.println(sb.toString());
	}
	
	
	
	static void toSelfNum(int num) {
		int sum = num;
		while(num>=10) {
			sum += num%10;
			num/=10;
		}
		sum+= num;
		if(sum<10000)
			selfNumber[sum]=true;
	}
}
