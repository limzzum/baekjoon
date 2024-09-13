import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static String L, R;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = st.nextToken();
        R = st.nextToken();

        if(L.length() != R.length()){
            System.out.println(0);
            return;
        }
        System.out.println(count());
    }

    private static int count(){
        int cnt = 0;
        char[] wordL = L.toCharArray();
        char[] wordR = R.toCharArray();
        for(int i=0; i <wordL.length; i++){
            if(wordL[i] != wordR[i]){
                break;
            }
            if(wordL[i] == '8' && wordR[i] == '8'){
                cnt += 1;
            }
        }
        return cnt;
    }
}
