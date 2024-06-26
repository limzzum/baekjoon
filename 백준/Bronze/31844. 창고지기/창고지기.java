import java.util.*;
import java.io.*;

public class Main{

    static char[] map;
    static int robotIndex;
    static int boxIndex;
    static int targetIndex;
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = br.readLine().toCharArray();
        
        for(int i=0; i<10; i++){
            if(map[i] == '@'){
                robotIndex = i;
            }else if(map[i] == '#'){
                boxIndex = i;
            }else if(map[i] == '!'){
                targetIndex = i;
            }
        }
        
        if(!isBetween()){
            System.out.print(-1);
            return;
        }
        
        System.out.print(Math.abs(targetIndex - robotIndex) -1);
        
    }
    
    private static boolean isBetween(){
        return (boxIndex > robotIndex && boxIndex < targetIndex) || (boxIndex > targetIndex && boxIndex < robotIndex);
    }
    
}
