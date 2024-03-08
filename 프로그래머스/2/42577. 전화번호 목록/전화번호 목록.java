import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        boolean answer = true;
        String pre = "--";
        for(String phone : phone_book){
            if(phone.startsWith(pre)){
                answer = false;
                break;
            }
            pre = phone;
        }
        return answer;
    }
}