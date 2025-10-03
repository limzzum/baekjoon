import java.util.*;

class Solution {
    static Stack<Integer> basket = new Stack();
    static int[] firstDollHeight;
    public int solution(int[][] board, int[] moves) {
        firstDollHeight = new int[board[0].length];
        int height = 0;
        for(int[] line : board){
            height += 1;
            for(int i=0; i<line.length; i++){
                if(firstDollHeight[i] == 0 && line[i] != 0){
                    firstDollHeight[i] = height;
                }
            }
            
        }
                
        int doll;
        int answer = 0;
        for(int move : moves){
            move -= 1;
            if(firstDollHeight[move] == 0 || firstDollHeight[move] > board.length){
                continue;
            }
            doll = board[firstDollHeight[move]-1][move];
            if(!basket.isEmpty() && basket.peek() == doll){
                answer += 2;
                basket.pop();
            }else {
                basket.add(doll);
            }
            firstDollHeight[move] += 1;
        }
        return answer;
    }
}