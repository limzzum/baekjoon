import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[][] map = new char[5][];


        for(int i=0; i<5; i++){
            map[i] = br.readLine().toCharArray();
        }

        for (int j=0; j<15; j++){

            for (int i=0; i<5; i++){
                if(map[i].length < j+1){
                    continue;
                }
                bw.write(map[i][j]);

            }
        }

        bw.flush();
        bw.close();

    }
}
