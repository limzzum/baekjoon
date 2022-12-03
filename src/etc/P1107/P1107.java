package etc.P1107;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P1107 {
    static String lowAnswer="";
    static String[] answerLow;
    static String[] answerHigh;
    static String highAnswer="";
    static boolean[] broken;
    static String target;
    static public void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        broken = new boolean[10];
        target = br.readLine();
        int targetNum = Integer.parseInt(target);
        int n = Integer.parseInt(br.readLine());
        answerLow= new String[target.length()];
        answerHigh= new String[target.length()];
        if(n==0){
            System.out.println(target.length());
            return;
        }
        String[] list = br.readLine().split(" ");

        for(int i=0; i<n; i++){
            int num = Integer.parseInt(list[i]);
            broken[num]=true;
        }

        getLowAnswer();
        getHighAnswer();
        int low =0;

        if(!lowAnswer.isEmpty()){
            low = Integer.parseInt(lowAnswer);
        }
        int high=0;
//        System.out.println(lowAnswer);
//        System.out.println(highAnswer);
        if(!highAnswer.isEmpty()){
            high = Integer.parseInt(highAnswer);
        }

        int result = Math.min(Math.abs(targetNum - low), Math.abs(high - targetNum)) + target.length();
        result = Math.min(result, Math.abs(targetNum-100));

        System.out.println(result);
    }

    private static void getHighAnswer() {

        int minNum =0;

        for (int j = 0; j <= 9; j++) {
            if (!broken[j]) {
                minNum= j;
                break;
            }
        }
        boolean done = false;
        for (String s : target.split("")) {
            if(done){
                highAnswer+=minNum;
                continue;
            }
            if(!broken[Integer.parseInt(s)]){
                highAnswer+=Integer.parseInt(s);
            }else{
                for (int j = Integer.parseInt(s)+1; j <= 9; j++) {
                    if (!broken[j]) {
                        highAnswer += j;
                        done=true;
                        break;
                    }
                }
            }


        }
//        for (String s : target.split("")) {
//            for (int j = 0; j <=9; j++) {
//                int targetNum = Integer.parseInt(s);
//                if (j >= targetNum && !broken[j]) {
//                    highAnswer += j;
//                    break;
//                }
//            }
//        }
    }

    private static void getLowAnswer() {
        int maxNum =0;
        for (int j = 9; j >= 0; j--) {
            if (!broken[j]) {
                maxNum= j;
                break;
            }
        }

        boolean done = false;
        int idx=0;
        for (String s : target.split("")) {
            if(done){
                //lowAnswer+=maxNum;
                continue;
            }
            if(!broken[Integer.parseInt(s)]){
                //lowAnswer+=Integer.parseInt(s);
            }else{
                for (int j = Integer.parseInt(s)-1; j >= 0; j--) {
                    if (!broken[j]) {
                      //  lowAnswer += j;
                        done=true;
                        break;
                    }
                }
            }


        }
//        for (String s : target.split("")) {
//            for (int j = 9; j >= 0; j--) {
//                int targetNum = Integer.parseInt(s);
//
//                if (j < targetNum && !broken[j]) {
//                    lowAnswer += j;
//                    break;
//                }
//            }
//        }
    }
}
