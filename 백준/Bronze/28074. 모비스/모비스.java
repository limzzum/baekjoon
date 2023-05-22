import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static boolean[] isMobis = new boolean[26];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        isMobis['M'-'A']=true;
        isMobis['O'-'A']=true;
        isMobis['B'-'A']=true;
        isMobis['I'-'A']=true;
        isMobis['S'-'A']=true;

        char[] input = br.readLine().toCharArray();

        int cnt = 5;
        for (int i = 0; i < input.length; i++) {
            if(isMobis[input[i]-'A']){
                isMobis[input[i]-'A'] = false;
                cnt -=1;
                if(cnt == 0){
                    System.out.println("YES");
                    return;
                }
            }
        }
        System.out.println("NO");

    }
}
