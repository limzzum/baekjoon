import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/* 세 용액 중 한 용액을 선택하고 나머지 두 용액을 찾는다.
* 한 용액을 선택하는 N가지 경우에 대해 나머지 두 용액은 투 포인터를 이용해 찾는다.
* 특성값을 오름차순 정렬 해주고 먼저 선택된 한 용액과, 포인터가 가르키는 제일 작은값과 제일 큰값을 더해 절댓값을 구하고
* 이 과정에서 가장 작은 절댓값을 찾는다.
* 시간 복잡도는 N^2이므로 N의 최댓값은 5000 이고 25000000이므로 시간안에 해결할 수 있다.
* */
public class Main {
    static int N;
    static long answer;
    static int [] answerNum = new int[3];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        String [] input = br.readLine().split(" ");

        int [] nums = new int[N];
        for (int i=0; i<N; i++){
            nums[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(nums);

        answer = Long.MAX_VALUE;
        for (int i=0; i<N; i++){
            int select = nums[i];
            int front = 0;
            int tail = N-1;
             while (front<tail){
                if(front == i){
                    front+=1;
                    continue;
                }
                if(tail == i){
                    tail -= 1;
                    continue;
                }
                long sum = (long) select + (long) nums[front] + nums[tail];
                if (sum == 0) {
                    int[] result = {select, nums[front], nums[tail]};
                    Arrays.sort(result);
                    for (int i1 : result) {
                        System.out.print(i1+" ");
                    }
                    return;
                }
                if(sum<0){
                    if(Math.abs(sum)< answer){
                        answer = Math.abs(sum);
                        answerNum = new int[]{select, nums[front], nums[tail]};
                    }
                    front += 1;
                }else{
                    if(Math.abs(sum)< answer){
                        answer = Math.abs(sum);
                        answerNum = new int[]{select, nums[front], nums[tail]};
                    }
                    tail -= 1;
                }

            }
        }
        Arrays.sort(answerNum);
        System.out.println(answerNum[0]+" "+answerNum[1]+" "+answerNum[2]);
    }

}
