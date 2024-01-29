import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    enum Color {
        Red("Red", 620, 780),
        Orange("Orange", 590, 620),
        Yellow("Yellow", 570, 590),
        Green("Green", 495, 570),
        Blue("Blue", 450, 495),
        Indigo("Indigo", 425, 450),
        Violet("Violet", 380, 425);

        private String name;
        private int min;
        private int max;

        Color(String name, int min, int max){
            this.name = name;
            this.min = min;
            this.max = max;
        }

    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        if(num == 780){
            System.out.println("Red");
            return;
        }
        
        for (Color color : Color.values()) {
            if(num >= color.min && num < color.max){
                System.out.println(color.name);
                return;
            }
        }
    }
}
