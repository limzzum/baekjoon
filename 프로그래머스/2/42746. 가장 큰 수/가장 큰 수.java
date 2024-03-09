import java.util.*;

class Solution {
    static StringBuilder sb = new StringBuilder();
    public String solution(int[] numbers) {
        String[] nums = new String[numbers.length];
        
        int idx = 0;
        boolean isAllZero = true;
        for(int n : numbers){
            if(n != 0){
                isAllZero = false;
            }
            nums[idx++] = String.valueOf(n);
        }
        if(isAllZero){
            return "0";
        }
        
        Arrays.sort(nums, (a,b)->{
            return Integer.valueOf(b+a) - Integer.valueOf(a+b);
        });
        
        for(int i=0; i < nums.length; i++){
            sb.append(nums[i]);
        }
        
        return sb.toString();
    }
}