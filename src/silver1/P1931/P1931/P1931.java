package silver1.P1931.P1931;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P1931 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long [][] conference = new long[N][2];

        for(int i=0; i<N; i++){
            String [] line = br.readLine().split(" ");
            conference[i] = new long[]{Long.parseLong(line[0]), Long.parseLong(line[1])};
        }

        Arrays.sort(conference, (long[] s1,long[] s2)->{
            if(s1[1]==s2[1]){
                return (int) (s1[0]-s2[0]);
            }
            return (int) (s1[1]-s2[1]);
        });

        long end=0;
        int count =0;
        for(long[] con:conference){
            if(con[0]>=end){
                count+=1;
                end =con[1];
            }
        }

        System.out.println(count);

    }

}
