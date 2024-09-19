import java.util.*;
import java.io.*;

public class Main{
	
	static final List<Integer> endGameBits = List.of(1 << 6 | 1<< 7 | 1 << 8, 1 << 5 | 1 << 4 | 1 << 3,  1<<2 | 1<<1 | 1<< 0,
1<<2 | 1<<5 | 1<< 8, 1 << 1 | 1<< 4 | 1 <<7, 1 << 0 | 1 << 3 | 1 << 6, 1<<0 | 1<<4 | 1<<8, 1<<2 | 1<<4 | 1 << 6);
	static final int[] row = {0, -1, -1, -1, 0, 1, 1, 1};
	static final int[] col = {-1, -1, 0, 1, 1, 1, 0, -1};
	static final StringBuilder sb = new StringBuilder();
	static int N;
	static char[][] board = new char[3][3];
	static char cur;
	static int bit;
	
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        for(int i=0; i<N; i++){
            for(int j=0; j<3; j++){
                board[j] = br.readLine().toCharArray();
            }
            cur = br.readLine().charAt(0);
            initBit();
            selectPosition();
            writeAnswer(i+1);
            
        }
        
        System.out.print(sb);
    }
    
    private static void writeAnswer(int n){
        sb.append("Case "+(n)+":").append("\n");
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                sb.append(board[i][j]);
            }
            sb.append("\n");
        }
    }
    
    private static void initBit(){
        bit = 0;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(board[i][j] == cur){
                    bit = bit | (1 << (i*3+j));
                }
            }
        }
    }
    
    private static void selectPosition(){
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(board[i][j] == '-'){
                    addBit(i, j);
                    if(isTiktakto(i, j)){
                        board[i][j] = cur;
                        return;
                    }
                    minusBit(i,j);
                }
            }
        }
    }
    
    private static void addBit(int r, int c){
        bit = bit | (1 << (r*3+c));
    }
    private static void minusBit(int r, int c){
        bit = bit & ~((1 << 9) | (1 << (r*3+c)));
    }
    
    private static boolean isTiktakto(int r, int c){
        for(int end : endGameBits){
            if((bit & end) == end){
                return true;
            }
        }
        return false;
    }
    
}
