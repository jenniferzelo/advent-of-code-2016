package Day08;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Jeremy on 12/15/2016.
 *
 --- Day 8: Two-Factor Authentication ---

 You come across a door implementing what you can only assume is an implementation of two-factor authentication after a long game of requirements telephone.

 To get past the door, you first swipe a keycard (no problem; there was one on a nearby desk). Then, it displays a code on a little screen, and you type that code on a keypad. Then, presumably, the door unlocks.

 Unfortunately, the screen has been smashed. After a few minutes, you've taken everything apart and figured out how it works. Now you just have to work out what the screen would have displayed.

 The magnetic strip on the card you swiped encodes a series of instructions for the screen; these instructions are your puzzle input. The screen is 50 pixels wide and 6 pixels tall, all of which start off, and is capable of three somewhat peculiar operations:

 rect AxB turns on all of the pixels in a rectangle at the top-left of the screen which is A wide and B tall.
 rotate row y=A by B shifts all of the pixels in row A (0 is the top row) right by B pixels. Pixels that would fall off the right end appear at the left end of the row.
 rotate column x=A by B shifts all of the pixels in column A (0 is the left column) down by B pixels. Pixels that would fall off the bottom appear at the top of the column.
 For example, here is a simple sequence on a smaller screen:

 rect 3x2 creates a small rectangle in the top-left corner:

 ###....
 ###....
 .......
 rotate column x=1 by 1 rotates the second column down by one pixel:

 #.#....
 ###....
 .#.....
 rotate row y=0 by 4 rotates the top row right by four pixels:

 ....#.#
 ###....
 .#.....
 rotate column x=1 by 1 again rotates the second column down by one pixel, causing the bottom pixel to wrap back to the top:

 .#..#.#
 #.#....
 .#.....
 As you can see, this display technology is extremely powerful, and will soon dominate the tiny-code-displaying-screen market. That's what the advertisement on the back of the display tries to convince you, anyway.

 There seems to be an intermediate check of the voltage used by the display: after you swipe your card, if the screen did work, how many pixels should be lit?

 Your puzzle answer was 123.

 The first half of this puzzle is complete! It provides one gold star: *

 --- Part Two ---

 You notice that the screen is only capable of displaying capital letters; in the font it uses, each letter is 5 pixels wide and 6 tall.

 After you swipe your card, what code is the screen trying to display?
 */

public class Day08 {

    public static void main(String[] args) throws FileNotFoundException {

        List<String> instructions = new ArrayList<String>();
        Scanner scanner = new Scanner(new File("src\\main\\java\\Day08\\input8.txt"));
        while (scanner.hasNext()) {
            instructions.add(scanner.nextLine());
        }

        String[][] screen = new String[6][50];
        String[] tempX = new String[6];
        String[] tempY = new String[50];
        int count = 0;

        //populate array with .'s
        for (int x = 0; x < 6; x++) {
            for (int y = 0; y < 50; y++) {
                screen[x][y] = ".";
            }
        }

        for (String instruction : instructions) {
            if (instruction.startsWith("rect ")) {
                String[] rect = instruction.replace("rect ", "").split("x");
                System.out.println("rectangle " + rect[0] + " by " + rect[1]); //remove print
                for (int y = 0; y < Integer.valueOf(rect[0]); y++) {
                    for (int x = 0; x < Integer.valueOf(rect[1]); x++) {
                        screen[x][y] = "#";
                    }
                }
            } else if (instruction.startsWith("rotate row y=")) {
                instruction = instruction.replace("rotate row y=", "");
                int row = Integer.valueOf(instruction.split(" by ")[0]);
                int yValue = Integer.valueOf(instruction.split(" by ")[1]);
                for (int y = 0; y < 50; y++) {
                    try {
                        tempY[(y + yValue) % 50] = screen[row][y];
                    } catch (Exception e) {
                    }
                }
                for (int y = 0; y < 50; y++) {
                    screen[row][y] = tempY[y];
                }
            } else if (instruction.startsWith("rotate column x=")) {
                instruction = instruction.replace("rotate column x=", "");
                int column = Integer.valueOf(instruction.split(" by ")[0]);
                int xValue = Integer.valueOf(instruction.split(" by ")[1]);
                for (int x = 0; x <= 5; x++) {
                    try {
                        tempX[(x + xValue) % 6] = screen[x][column];
                    } catch (Exception e) {
                    }
                }
                for (int x = 0; x < 6; x++) {
                    screen[x][column] = tempX[x];
                }
            }
        }

        //part 1 counting
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 50; j++) {
                if (screen[i][j].equals("#")) {
                    count++;
                }
            }
        }

        System.out.println("Part 1: " + count + " pixels lit");
        System.out.println("Part 2: Print the screen");

        //print array
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 50; j++) {
                System.out.print(screen[i][j]);
            }
            System.out.println();
        }
    }
}
