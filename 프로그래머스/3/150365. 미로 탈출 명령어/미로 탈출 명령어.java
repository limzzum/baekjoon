import java.util.*;
import java.io.*;
import java.util.stream.*;

class Solution {

    static String[] dx = {"d", "l","r","u"};
    static int[] row = {1, 0, 0, -1};
    static int[] col = {0, -1, 1, 0};
    static int[] count = new int[5];
    static int N, M;
    
    static final String FAIL = "impossible";
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        N = n;
        M = m;
        int distance = Math.abs(r - x) + Math.abs(c - y);
        if( k < distance || (k- distance)%2 == 1){
            return FAIL;
        }
        count[0] = Math.max(0, r - x);
        count[1] = Math.max(0, y - c);
        count[2] = Math.max(0, c - y);
        count[3] = Math.max(0, x - r);
        count[4] = (k-distance) /2;
        
        StringBuilder sb = new StringBuilder();
        for(int t=0; t<k; t++){     
            for(int i=0; i<4; i++){
                int nx = x + row[i];
                int ny = y + col[i];
                if(isInMap(nx, ny)){
                    if(count[i] >0){
                        count[i] -= 1;
                        sb.append(dx[i]);
                        x = nx;
                        y = ny;
                        break;
                    }else if(count[4] > 0){
                        count[4] -= 1;
                        count[3-i] += 1;
                        sb.append(dx[i]);     
                        x = nx;
                        y = ny;
                        break;
                    }
                }
            }

        }
        return sb.toString();
    }
    
    private static boolean isInMap(int x, int y){
        if(x < 1 || x>N || y <1 || y> M){
            return false;
        }
        return true;
    }
    
}