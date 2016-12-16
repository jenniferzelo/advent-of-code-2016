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
        while (scanner.hasNext()) {
            instructions.add(scanner.nextLine());
        }

        String[][] screen = new String[6][50];

        //populate array with .'s
        for (int x = 0; x < 6; x++) {
            for (int y = 0; y < 50; y++) {
                screen[x][y] = ".";
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
