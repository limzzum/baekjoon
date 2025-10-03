import java.util.*;

class Solution {
    static Set<Integer> leftHandNumbers = Set.of(1, 4, 7);
    static Set<Integer> rightHandNumbers = Set.of(3,6,9);
    static int curLeftHandHeight = 3;
    static int curRightHandHeight = 3;
    static int curLeftHandWidth = 0;
    static int curRightHandWidth = 2;
    static int[] height = new int[]{3,0,0,0,1,1,1,2,2,2};
    static int[] width = new int[]{1,0,1,2,0,1,2,0,1,2};
    
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        for(int number : numbers){
            if(isLeftHand(number, hand)){
                curLeftHandHeight = height[number];
                curLeftHandWidth = width[number];
                sb.append("L");
            }else {
                curRightHandHeight = height[number];
                curRightHandWidth = width[number];
                sb.append("R");
            }
        }
        return sb.toString();
    }
    
    private boolean isLeftHand(int number, String hand){
        if(leftHandNumbers.contains(number)){
            return true;
        }
        if(rightHandNumbers.contains(number)){
            return false;
        }
        int leftDiff = Math.abs(height[number] - curLeftHandHeight) + Math.abs(width[number] - curLeftHandWidth);
        int rightDiff = Math.abs(height[number] - curRightHandHeight) + Math.abs(width[number] - curRightHandWidth);
        return leftDiff < rightDiff || (leftDiff == rightDiff && hand.equals("left"));
        
    }
}