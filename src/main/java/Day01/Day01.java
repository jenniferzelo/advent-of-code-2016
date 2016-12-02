package Day01;


import jdk.internal.util.xml.impl.Pair;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Jeremy on 12/1/2016.
 */

public class Day01 {

    public static void main(String[] args) throws IOException {

        String filepath = "D:\\IntelliJ IDEA 2016.2.5\\IdeaProjects\\AdventOfCode2016\\src\\main\\java\\Day01\\input.txt";
        BufferedReader reader = new BufferedReader(new FileReader(new File(filepath)));
        String[] instructions = reader.readLine().split(", ");
        reader.close();

        int x = 0;
        int y = 0;
        int degrees = 90;
        ArrayList setList = new ArrayList();
        ArrayList doubleVisit = new ArrayList();

        for(String step : instructions) {
            String direction = step.substring(0, 1);
            int distance = Integer.parseInt(step.substring(1, step.length()));
            int[] set = new int[2];

//            set[0] = x;
//            set[1]  =y;

            if (direction.equals("L")) {
                degrees += 90;
            } else {
                degrees -= 90;
            }

            switch (degrees % 360) {
                case 0:
                    for (int i=0; i<=distance; i++){
                        set[0] = x + i;
                        set[1] = y;
                        if (setList.contains(set)){
                            System.out.println("set " + set[0] + ", " + set[1] + " visited again");
                        }
                        setList.add(set);
                    }
                    x += distance;
                    break;
                case 90:
                case -270:
                    for (int i=0; i<=distance; i++){
                        set[0] = x;
                        set[1] = y + i;
                        if (setList.contains(set)){
                            System.out.println("set " + set[0] + ", " + set[1] + " visited again");
                        }
                        setList.add(set);
                    }
                    y += distance;
                    break;
                case 180:
                case -180:
                    for (int i=0; i<=distance; i++){
                        set[0] = x - i;
                        set[1] = y;
                        if (setList.contains(set)){
                            System.out.println("set " + set[0] + ", " + set[1] + " visited again");
                        }
                        setList.add(set);
                    }
                    x -= distance;
                    break;
                case 270:
                case -90:
                    for (int i=0; i<=distance; i++){
                        set[0] = x;
                        set[1] = y - i;
                        if (setList.contains(set)){
                            System.out.println("set " + set[0] + ", " + set[1] + " visited again");
                        }
                        setList.add(set);
                    }
                    y -= distance;
                    break;
            }
        }

        int manhattanLength = Math.abs(x) + Math.abs(y);
        System.out.println("Part 1:\t" + manhattanLength + " blocks");
        System.out.println("Part 2:\t");

    }
}
