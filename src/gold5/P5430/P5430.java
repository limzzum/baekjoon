package gold5.P5430;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P5430 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            String[] command = br.readLine().split("");
            int N = Integer.parseInt(br.readLine());
            String line = br.readLine();

            if (N == 0) {
                ArrayList<String> strings = new ArrayList<>(List.of(command));
                if (strings.contains("D")) {
                    sb.append("error").append("\n");
                } else {
                    sb.append("[]").append("\n");
                }
                continue;
            }
            String[] nums = line.substring(1, line.length() - 1).split(",");

            List<String> number = new ArrayList<>(List.of(nums));
            boolean reversed = false;
            boolean end = false;
            for (String s : command) {
                if (s.equals("R")) {
                    reversed = !reversed;
                }
                if (s.equals("D")) {
                    if (number.isEmpty()) {
                        sb.append("error").append("\n");
                        end = true;
                        break;
                    }
                    if (reversed) {
                        number.remove(number.size() - 1);
                    } else {
                        number.remove(0);
                    }
                }
            }
            if(end){
                continue;
            }
            if (reversed) {
                Collections.reverse(number);
            }
            sb.append("[");
            for(int j=0; j<number.size(); j++){
                sb.append(number.get(j));
                if(j== number.size()-1){
                    break;
                }
                sb.append(",");
            }
            sb.append("]");
            sb.append("\n");

        }

        System.out.println(sb);
    }
}

