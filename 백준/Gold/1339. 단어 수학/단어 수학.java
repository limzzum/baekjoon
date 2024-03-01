import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class Main {

    static class Node{
        char word;
        int sum;

        public Node(char word, int sum){
            this.word = word;
            this.sum = sum;
        }
    }
    static char[][] words;
    static int[] nums = new int[26];

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o2.sum - o1.sum);
        int N = Integer.parseInt(br.readLine());

        words = new char[N][];
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            words[i] = br.readLine().toCharArray();
            int z =words[i].length -1;
            for (char words : words[i]){
                map.put(words, map.getOrDefault(words, 0) + (int)(Math.pow(10, z)));
                z -= 1;
            }
        }

        for (Entry<Character, Integer> characterIntegerEntry : map.entrySet()) {
            pq.add(new Node(characterIntegerEntry.getKey(), characterIntegerEntry.getValue()));
        }

        int num = 9;
        while (!pq.isEmpty()){
            Node poll = pq.poll();
            nums[poll.word - 'A'] = num;
            num -= 1;
        }

        int sum = 0;
        StringBuilder sb;
        for (int i = 0; i < N; i++) {
            sb = new StringBuilder();
            for (int j = 0; j < words[i].length; j++) {
                sb.append(nums[words[i][j] - 'A']);
            }
            sum += Integer.parseInt(sb.toString());
        }

        System.out.println(sum);



    }

}
