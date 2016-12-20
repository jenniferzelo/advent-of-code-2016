package Day08;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Jeremy on 12/15/2016.
 */

public class Day08 {

    public static void main(String[] args) throws FileNotFoundException {

        List<String> instructions = new ArrayList<String>();
        Scanner scanner = new Scanner(new File("src\\main\\java\\Day08\\input8.txt"));
//        while (scanner.hasNext()) {
//            instructions.add(scanner.nextLine());
//        }

        instructions.add("rect 3x2");
        instructions.add("rotate column x=1 by 4");

        String[][] screen = new String[6][50];

        //populate array with .'s
        for (int x = 0; x < 6; x++) {
            for (int y = 0; y < 50; y++) {
                screen[x][y] = ".";
            }
        }

        for(String instruction : instructions) {
            if (instruction.startsWith("rect ")) {
                String[] rect = instruction.replace("rect ", "").split("x");
                System.out.println("rectangle " + rect[0] + " by " + rect[1]); //remove print
                for(int y = 0; y < Integer.valueOf(rect[0]); y++) {
                    for (int x = 0; x < Integer.valueOf(rect[1]); x++){
                        screen[x][y] = "#";
                    }
                }
            } else if (instruction.startsWith("rotate row y=")) {
                instruction = instruction.replace("rotate row y=", "");
                int row = Integer.valueOf(instruction.split(" by ")[0]);
                int yValue = Integer.valueOf(instruction.split(" by ")[1]);
                System.out.println("rotate row " + row + " value " + yValue); //remove print
            } else if (instruction.startsWith("rotate column x=")) {
                instruction = instruction.replace("rotate column x=", "");
                int column = Integer.valueOf(instruction.split(" by ")[0]);
                int xValue = Integer.valueOf(instruction.split(" by ")[1]);
                System.out.println("rotate column " + column + " value " + xValue); //remove print
                for (int x = 5; x > 0; x--) {
                    try {
                        screen[(x + xValue) % 6][column] = screen[x][column];
//                        screen[x][column] = ".";
                    } catch (Exception e){}
                }
            }
        }


        //print array
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 50; j++) {
                System.out.print(screen[i][j]);
            }
            System.out.println();
        }
    }
}
