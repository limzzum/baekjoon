import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    static int totalCnt;
    static Map<String, Integer> treesCnt = new HashMap<>();
    static Set<String> trees = new TreeSet<>();

    public static void main(String[] args) throws Exception{
        String name;
        while ((name = br.readLine()) != null){
            treesCnt.put(name, treesCnt.getOrDefault(name, 0) + 1);
            trees.add(name);
            totalCnt += 1;
        }

        for (String tree : trees) {
            double percentage = treesCnt.get(tree) * 1_000_000.0 / totalCnt;
            sb.append(tree).append(" ").append(String.format("%.4f",Math.round(percentage)/10000.0)).append("\n");
        }

        System.out.println(sb);
    }

}
