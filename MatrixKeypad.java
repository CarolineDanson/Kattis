import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MatrixKeypad {

    public static void main(String[] args) {

        Scanner inputs = new Scanner(System.in);

        //Get the number of test cases
        int numCases = inputs.nextInt();

        for (int n = 0; n < numCases; n++) {
            //Get the number of rows and columns that will create the grid
            int rowI = inputs.nextInt();
            int columnJ = inputs.nextInt();
            String[][] inputGrid = new String[rowI][columnJ];

            //Populating the input grid based on input
            for (int x = 0; x < rowI; x++) {
                String row = inputs.next();
                String[] columns = row.split("");
                for (int y = 0; y < columnJ; y++) {
                    inputGrid[x][y] = columns[y];
                }
            }

            //Checking if inputted grid is possible and then creating output to print
            if (checkPossible(inputGrid, rowI, columnJ)) {
                String outputGrid[][] = new String[rowI][columnJ];
                for (int i = 0; i < rowI; i++) {
                    for (int j = 0; j < columnJ; j++) {
                        if (inputGrid[i][j].contains("1")) {
                            if (checkDuplicate(inputGrid, i, j, rowI)) {
                                outputGrid[i][j] = "I";
                            } else {
                                outputGrid[i][j] = "P";
                            }
                        } else {
                            outputGrid[i][j] = "N";
                        }
                    }
                }
                for (int i = 0; i < rowI; i++) {
                    System.out.println(String.join("", outputGrid[i]));
                }
            } else {
                System.out.println("impossible");
            }
            System.out.println("----------");
        }
    }

    //Method to check if the grid is possible
    static boolean checkPossible (String[][] inputGrid, int numRows, int numColumns) {
        ArrayList<Integer> rows = new ArrayList<>();
        ArrayList<Integer> columns = new ArrayList<>();

        //Checking which rows and columns that contains 1 and adding to ArrayList declared above.
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numColumns; j++) {
                if (inputGrid[i][j].contains("1")) {
                    rows.add(i);
                    columns.add(j);
                }
            }
        }

        //Creating another grid based on the columns and rows containing 1 above to see what the grid should look like if possible.
        String[][] testGrid = new String[numRows][numColumns];

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numColumns; j++) {
                if (rows.contains(i) && columns.contains(j)) {
                    testGrid[i][j] = "1";
                }
                else {
                    testGrid[i][j] = "0";
                }
            }
        }

        //If the testGrid is equal to the inputGrid then the input is possible.
        return Arrays.deepEquals(inputGrid, testGrid);
    }

    //Method to check if there is more than one alternative for the J and I combination given.
    static boolean checkDuplicate(String[][] inputGrid, int rowNumber, int columnNumber, int numRows) {

        int rowCounter = 0;
        int columnCounter = 0;

        //First check to see if there is more than one number 1 in a given row.
        for (String number : inputGrid[rowNumber]) {
            if (number.contains("1")) {
                rowCounter++;
            }
        }
        //If there is only one number 1, return false directly since only one alternative for the J and I combination.
        if (rowCounter == 1) {
            return false;
        }
        //If there is more than one number 1, then check the column for duplicates.
        else {
            for (int i = 0; i < numRows; i++) {
                if (inputGrid[i][columnNumber].contains("1")) {
                    columnCounter++;
                }
            }
            //If there is only one number 1, return false directly since only one alternative for the J and I combination.
            if (columnCounter == 1) {
                return false;
            }
        }
        //If none of the above conditions are true there is more than one number 1 in both the row and column, therefore the method returns true.
        return true;
    }
}