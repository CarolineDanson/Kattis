import java.util.Scanner;

public class ADifferentProblem {

        public static void main (String[] args) {
            Scanner intSc = new Scanner(System.in);
            while (intSc.hasNextLong()) {
                long a = intSc.nextLong();
                long b = intSc.nextLong();
                long answer = Math.abs((a - b));
                System.out.println(answer);
        }
    }
}
