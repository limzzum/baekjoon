import java.util.*;
import java.io.*;

public class Main{
    
    static class Pos{
        int r;
        int c;
        public Pos(int r, int c){
            this.r = r;
            this.c = c;
        }
        
        @Override
        public boolean equals(Object obj){
            if(!(obj instanceof Pos)){
                return false;
            }
            Pos pos = (Pos) obj;
            return r == pos.r && c == pos.c;
        }
        
        @Override
        public int hashCode(){
            return Objects.hash(r, c);
        }
    }
    
    static final int[] row = {0, -1, 0, 1};
    static final int[] col = {-1, 0, 1, 0};
    static int N;
    static int startR;
    static int startC;
    static int endR;
    static int endC;
    static Pos curPos = new Pos(0,0);
    static Set<Pos> visitPos = new HashSet<>();
    static int diretion = 3;
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        char[] commands = br.readLine().toCharArray();
        
        for(char command : commands){
            if(command == 'F'){
                move();
            }else if(command == 'R'){
                diretion = (diretion + 1)%4;
            }else {
                diretion = (diretion + 3)%4;
            }
        }
        
        visitPos.add(new Pos(0,0));
        StringBuilder sb = new StringBuilder();
        for(int i=startR; i<= endR; i++){
            for(int j= startC; j<= endC; j++){
                if(visitPos.contains(new Pos(i, j))){
                    sb.append(".");
                }else{
                    sb.append("#");
                }
            }
            sb.append("\n");
        }
        
        System.out.print(sb);
    }
    
    private static void move(){
        curPos.r = curPos.r + row[diretion];
        curPos.c = curPos.c + col[diretion];
        visitPos.add(new Pos(curPos.r, curPos.c));
        updateMap();

    }
    
    private static void updateMap(){
        if(curPos.r < startR){
            startR = curPos.r;
        }else if(curPos.r > endR){
            endR = curPos.r;
        }
        
        if(curPos.c < startC){
            startC = curPos.c;
        }else if(curPos.c > endC){
            endC = curPos.c;
        }
    }
    
}
