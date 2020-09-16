import java.util.ArrayList;
import java.util.Scanner;

public class BallBearings {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        //Number of test cases
        int n = input.nextInt();

        //Test case data
        //D = inner diameter of the outer ring
        double D = 0;
        //d = diameter of a ball
        double d = 0;
        //s = minimum distance between balls
        double s = 0;

        //Saving output data to be printed
        int outputToPrint = 0;
        ArrayList<Integer> savedOutput = new ArrayList<>();

        //Getting input data
        for (int i = 0; i < n; i++) {
            D = input.nextDouble();
            d = input.nextDouble();
            s = input.nextDouble();
            outputToPrint = (int) calcOutput(D, d, s);
            savedOutput.add(outputToPrint);
        }

        //Printing output
        for (int i = 0; i < savedOutput.size(); i++) {
            System.out.println(savedOutput.get(i));
        }

    }

    public static double calcOutput(double D, double d, double s) {
        //Calculate the width of the diameter of the ball and the space between each ball
        double widthAddingSpace = d + s;

        //Output = maximum number of balls that can fit in the ball bearing
        int m = (int) Math.floor(Math.PI/Math.asin((widthAddingSpace)/(D-d)));

        return m;
    }

}
