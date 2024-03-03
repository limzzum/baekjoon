import java.io.*;
import java.util.*;

public class Main{

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nums = new int[9];
        
        int sum = 0;
        for(int i=0; i<9; i++) {
        	nums[i] = Integer.parseInt(br.readLine());
        	sum += nums[i];
        }
        
        int over = sum - 100;
        
        for(int i=0; i<9; i++) {
        	for(int j=i+1; j<9; j++) {
        		if(nums[i]+nums[j] == sum-100) {
        			for(int k=0; k<9; k++) {
        				if(k!= i && k != j) {
        					System.out.println(nums[k]);
        				}
        			}
        			return;
        		}
        	}
        }
       
        
    }   
}