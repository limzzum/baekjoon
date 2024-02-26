import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    enum Semina {
        Algorithm("Algorithm", "204"),
        DataAnalysis("DataAnalysis", "207"),
        ArtificialIntelligence("ArtificialIntelligence", "302"),
        CyberSecurity("CyberSecurity", "B101"),
        Network("Network", "303"),
        Startup("Startup", "501"),
        TestStrategy("TestStrategy", "105");

        private final String name;
        private final String classNum;

        private Semina(String name, String classNum){
            this.name = name;
            this.classNum = classNum;
        }

    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String semi = br.readLine();
            sb.append(Semina.valueOf(semi).classNum).append("\n");
        }
        System.out.println(sb);
    }

}
