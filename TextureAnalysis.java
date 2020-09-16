import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TextureAnalysis {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int lineCounter = 1;

        while (true) {
            String text = scan.next();
            ArrayList<Integer> cases = new ArrayList<>();

            if (text.contains("END")) {
                break;
            }

            for (int i = 0; i < text.length(); i++) {
                if (text.charAt(i) == '*') {
                    cases.add(i);
                }
            }

            if (checkTexture(cases)) {
                System.out.println(lineCounter + " EVEN");
            }
            else {
                System.out.println(lineCounter + " NOT EVEN");
            }
            lineCounter++;

        }
    }

    public static boolean checkTexture(ArrayList<Integer> checkSequence){
        if (checkSequence.size() == 1) {
            return true;
        }
        ArrayList<Integer> comparingArray = new ArrayList<>();
        for (int i = 0; i < checkSequence.size() - 1; i++) {
            int gap = checkSequence.get(i + 1) - checkSequence.get(i);
            comparingArray.add(gap);
        }
        if (Collections.frequency(comparingArray, comparingArray.get(0)) == comparingArray.size()) {
            return true;
        }
        else {
            return false;
        }
    }
}