package Day03;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Jeremy on 12/2/2016.
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
