import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] lineA = br.readLine().split("");
        String[] lineB = br.readLine().split("");

        List<String> listA = new ArrayList<>(List.of(lineA));
        List<String> listB = new ArrayList<>(List.of(lineB));

        int[][] dp = new int[lineB.length+1][lineA.length+1];
        for(int j=0; j<listA.size(); j++) {
            for(int i=0; i<listB.size(); i++) {
                if(listA.get(j).equals(listB.get(i))) {
                    dp[i+1][j+1] = dp[i][j]+1;
                }else {
                    dp[i+1][j+1] = Math.max(dp[i+1][j],dp[i][j+1]);
                }
            }
        }

        System.out.println(dp[dp.length-1][dp[0].length-1]);


    }


}
