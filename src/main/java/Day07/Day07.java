package Day07;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Jeremy on 12/14/2016.
 */

public class Day07 {

    public static void main(String[] args) throws FileNotFoundException {

        List<String> ips = new ArrayList<String>();
        Scanner scanner = new Scanner(new File("src\\main\\java\\Day07\\input7.txt"));
        while (scanner.hasNext()) {
            ips.add(scanner.nextLine());
        }

        boolean insideBrackets = false;
        boolean tls = false;
        boolean ssl = false;
        int count = 0;

        for (String ip : ips ) {
            for (int i = 0; i < ip.length() - 3; i++) {
                char c = ip.charAt(i);
                if (c == '[') {
                    insideBrackets = true;
                }

                if (c == ']') {
                    insideBrackets = false;
                }

                if (c == ip.charAt(i + 3) && ip.charAt(i + 1) == ip.charAt(i + 2) && c != ip.charAt(i + 1) && !insideBrackets) {
                        tls = true;
                }

                if (c == ip.charAt(i + 3) && ip.charAt(i + 1) == ip.charAt(i + 2) && insideBrackets) {
                    if (c == ip.charAt(i + 1) && c == ip.charAt(i + 2) && c == ip.charAt(i + 3)) {
                        //do not change
                    } else {
                        tls = false;
                        break;
                    }
                }
            }

            if (tls) {
                count++;
            }

            insideBrackets = false;
            tls = false;
        }

        System.out.println(count);
    }
}
