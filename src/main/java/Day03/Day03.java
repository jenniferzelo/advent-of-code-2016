package Day03;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Jeremy on 12/2/2016.
 *
 --- Day 3: Squares With Three Sides ---

 Now that you can think clearly, you move deeper into the labyrinth of hallways and office furniture that makes up this part of Easter Bunny HQ. This must be a graphic design department; the walls are covered in specifications for triangles.

 Or are they?

 The design document gives the side lengths of each triangle it describes, but... 5 10 25? Some of these aren't triangles. You can't help but mark the impossible ones.

 In a valid triangle, the sum of any two sides must be larger than the remaining side. For example, the "triangle" given above is impossible, because 5 + 10 is not larger than 25.

 In your puzzle input, how many of the listed triangles are possible?

 Your puzzle answer was 862.

 --- Part Two ---

 Now that you've helpfully marked up their design documents, it occurs to you that triangles are specified in groups of three vertically. Each set of three numbers in a column specifies a triangle. Rows are unrelated.

 For example, given the following specification, numbers with the same hundreds digit would be part of the same triangle:

 101 301 501
 102 302 502
 103 303 503
 201 401 601
 202 402 602
 203 403 603
 In your puzzle input, and instead reading by columns, how many of the listed triangles are possible?

 Your puzzle answer was 1577.
 */

public class Day03 {

    public static void main(String[] args) throws FileNotFoundException {

        String filepath = "src\\main\\java\\Day03\\input3.txt";
        Scanner scan = new Scanner(new File(filepath));
        int count1 = 0;
        int count2 = 0;
        while (scan.hasNext()) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            int c = scan.nextInt();
            int[] z = {a, b, c};
            Arrays.sort(z);
            if (z[0] + z[1] > z[2])
                count1++;

            int d = scan.nextInt();
            int e = scan.nextInt();
            int f = scan.nextInt();
            int g = scan.nextInt();
            int h = scan.nextInt();
            int i = scan.nextInt();
            int[] w = {a, d, g};
            int[] x = {b, e, h};
            int[] y = {c, f, i};
            Arrays.sort(w);
            Arrays.sort(x);
            Arrays.sort(y);
            if (w[0] + w[1] > w[2])
                count2++;
            if (x[0] + x[1] > x[2])
                count2++;
            if (y[0] + y[1] > y[2])
                count2++;
        }
        System.out.println("Answer 1: " + count1);
        System.out.println("Answer 2: " + count2);


    }
}
