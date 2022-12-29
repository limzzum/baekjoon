package silver1.P14888;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P14888 {
    static int N;
    static String[] line;
    static int max = -1000000000;
    static int min = 100000000;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        line = br.readLine().split(" ");
        String[] command = br.readLine().split(" ");
        int [] com = new int[4];
        int idx = 0;
        for (String s : command) {
            com[idx] = Integer.parseInt(s);
            idx+=1;
        }
        int start = Integer.parseInt(line[0]);
        dfs(start, 1, com);
        System.out.println(max);
        System.out.println(min);
    }

    private static void dfs(int pre, int idx, int[] com) {
        if(idx == N){
            max = Math.max(max,pre);
            min = Math.min(min, pre);
            return;
        }

        int i=0;
        while(i<4){
            for(int j = 0; j<com[i]; j++){
                int current = Integer.parseInt(line[idx]);
                if(i==0){
                    current+= pre;
                }
                if(i==1){
                    current = pre-current;
                }
                if(i==2){
                    current *= pre;
                }
                if(i==3){
                    if(pre<0){
                        current = -((pre*-1)/current);
                    }
                    else{
                        current = pre/current;
                    }
                }
                com[i]-=1;
                dfs(current,idx+1,com);
                com[i]+=1;

            }
            i+=1;
        }
    }
}
