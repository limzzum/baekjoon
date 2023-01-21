import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static class Truck{
        int endTime;
        int weight;

        Truck(int endTime, int weight){
            this.endTime = endTime;
            this.weight = weight;
        }
    }
    public static class Bridge{
        final int length;
        final int maxWeight;
        int currentWeight;
        int currentTruckCnt;
        List<Truck> trucks = new LinkedList<>();

        Bridge(int length, int maxWeight) {
            this.length = length;
            this.maxWeight = maxWeight;
        }

        void addTruck(Truck truck){
            currentWeight += truck.weight;
            currentTruckCnt += 1;
            trucks.add(truck);
        }
        void removeArriveTruck(int time){
            if(trucks.size()==0){
                return;
            }
            Truck truck = trucks.get(0);
            if(truck.endTime == time) {
                currentWeight -= truck.weight;
                currentTruckCnt -= 1;
                trucks.remove(0);
            }
        }
        int getEndTime(){
            return trucks.get(0).endTime;
        }

        boolean isPossibleAddTruck(int weight){
            if(currentWeight + weight <= maxWeight && currentTruckCnt<length){
                return true;
            }
            return false;
        }
    }
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int W = Integer.parseInt(input[1]);
        int L = Integer.parseInt(input[2]);

        String[] list = br.readLine().split(" ");
        Bridge bridge = new Bridge(W, L);

        int time = 0;
        for(String t: list){
            time +=1;
            bridge.removeArriveTruck(time);
            int weight = Integer.parseInt(t);
            while(!bridge.isPossibleAddTruck(weight)){
                time = bridge.getEndTime();
                bridge.removeArriveTruck(time);
            }
            bridge.addTruck(new Truck(time+W, weight));
        }
        time += W;
        System.out.println(time);
    }
}
