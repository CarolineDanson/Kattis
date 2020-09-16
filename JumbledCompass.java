import java.util.Scanner;

public class JumbledCompass {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        //Variables to get the compass directions
        int currentDirection = input.nextInt();
        int correctDirection = input.nextInt();

        //Calculating the output (CW or CCW) depending on direction answer
        int firstOutput = ((correctDirection - currentDirection + 720) % 360);
        int secondOutput = -1 * ((currentDirection - correctDirection + 720) % 360);

        if (Math.abs(firstOutput) == 180) {
            System.out.println(180);
        }
        else if (Math.abs(firstOutput) < Math.abs(secondOutput)) {
            System.out.println(firstOutput);
        }
        else {
            System.out.println(secondOutput);
        }
    }
}