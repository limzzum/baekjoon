import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int [] nums = new int[3];
        
        for (int i = 0; i < 3; i++) {
            int n = Integer.parseInt(br.readLine());
            nums[i] = n;
        }
        Arrays.sort(nums);
        System.out.println(nums[1]);
    }

}