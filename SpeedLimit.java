import java.util.ArrayList;
import java.util.Scanner;

public class SpeedLimit {

    public static void main(String[] args) {
        SpeedLimit.getSpeedLimit();
    }

    public static void getSpeedLimit() {
        Scanner scan = new Scanner(System.in);

        while (true) {
            int numOfInput = scan.nextInt();
            int totalMiles = 0;

            if (numOfInput == -1) {
                break;
            }

            ArrayList<Integer> speed = new ArrayList<>();
            ArrayList<Integer> distances = new ArrayList<>();

            //Getting the input
            for (int i = 0; i < numOfInput; i++) {
                speed.add(scan.nextInt());
                distances.add(scan.nextInt());
            }

            //Calculating the hours & speed
            for (int i = 0; i < numOfInput; i ++) {
                if (i == 0) {
                    totalMiles += speed.get(i) * distances.get(i);
                }
                else {
                    int distance = (distances.get(i) - distances.get(i - 1));
                    int distanceDriven = speed.get(i) * distance;
                    totalMiles += distanceDriven;
                }
            }

            System.out.println(totalMiles + " miles");

        }
        scan.close();
    }
}