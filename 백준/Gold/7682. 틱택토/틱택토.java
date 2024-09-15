import java.util.*;
import java.io.*;

public class Main{
	
	//X,O의 개수는 같거나 X가 하나 더 많아야 한다.
	// 우승자는 한 명이다. 한 명의 우승자가 나왔는지 체크, 우승 즉시 게임 종료해야함
	// 우승자가 없고,빈자리가 없는지 체크
	
	static final List<Integer> endGameBits = List.of(1 << 6 | 1<< 7 | 1 << 8, 1 << 5 | 1 << 4 | 1 << 3,  1<<2 | 1<<1 | 1<< 0,
1<<2 | 1<<5 | 1<< 8, 1 << 1 | 1<< 4 | 1 <<7, 1 << 0 | 1 << 3 | 1 << 6, 1<<0 | 1<<4 | 1<<8, 1<<2 | 1<<4 | 1 << 6);
    static int xCnt;
    static int oCnt;
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        String input;
        char[] boards;
        int xBits;
        int oBits;
        StringBuilder sb = new StringBuilder();
        while(!(input = br.readLine()).equals("end")){
            boards = input.toCharArray();
            xBits = 0;
            oBits = 0;
            xCnt = 0;
            oCnt = 0;
            for(int i=0; i<9; i++){
                if(boards[i] == 'X'){
                    xBits = xBits | (1<< (8-i));
                    xCnt += 1;
                }else if(boards[i] == 'O'){
                    oBits = oBits | (1<<(8-i));
                    oCnt += 1;
                }
            }
            if(!isBalancedGame(xCnt, oCnt) || !isEndGame(xBits, oBits, xCnt + oCnt == 9)){
                sb.append("invalid");
            }else{
                sb.append("valid");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
    
    private static boolean isBalancedGame(int xCnt, int oCnt){
        return (xCnt == oCnt) || (xCnt - 1 == oCnt);
    }
    
    private static boolean isEndGame(int xBits, int oBits, boolean isMax){
        boolean isXWin = endGameBits.contains(xBits);
        boolean isOWin = endGameBits.contains(oBits);
        
        for(int endBit : endGameBits){
            if((xBits & endBit) == endBit){
                isXWin = true;
            }
            if((oBits & endBit) == endBit){
                isOWin = true;
            }
        }
        
        if(isXWin && isOWin){
            return false;
        }
        if(isOWin && xCnt > oCnt){
            return false;
        }
        if(isXWin && xCnt == oCnt){
            return false;
        }
    
        return (isXWin && !isOWin) || (!isXWin && isOWin) || isMax;
        
    }

}
