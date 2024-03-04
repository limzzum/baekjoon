import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long [][] conference = new long[N][2];

        for(int i=0; i<N; i++){
            String [] line = br.readLine().split(" ");
            conference[i][0] = Long.parseLong(line[0]);
            conference[i][1] = Long.parseLong(line[1]);
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
                end = con[1];
            }
        }

        System.out.println(count);

    }

}
