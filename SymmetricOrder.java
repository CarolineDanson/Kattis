import java.util.Scanner;

public class SymmetricOrder {

    public static void main(String[] args) throws Exception {
        Scanner inputs = new Scanner(System.in);
        int setSize = inputs.nextInt();
        int setNum = 1;
        System.out.println(" ");

        while (setSize != 0) {

            System.out.println("SET " + setNum);
            int castOrder = setSize;
            String castNames[] = new String[setSize];

            for (int i = 0; i < setSize / 2; i++) {
                castNames[i]=inputs.next();
                castNames[castOrder - 1] = inputs.next();
                castOrder--;
            }

            if (setSize % 2 != 0) {
                castNames[(setSize / 2)] = inputs.next();
            }

            for (int i = 0; i < castNames.length; i++) {
                System.out.println(castNames[i]);
            }

            setSize = inputs.nextInt();
            setNum++;
        }
    }
}
