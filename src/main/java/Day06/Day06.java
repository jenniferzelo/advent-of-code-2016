package Day06;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by Jeremy on 12/10/2016.
 *
 --- Day 6: Signals and Noise ---

 Something is jamming your communications with Santa. Fortunately, your signal is only partially jammed, and protocol in situations like this is to switch to a simple repetition code to get the message through.

 In this model, the same message is sent repeatedly. You've recorded the repeating message signal (your puzzle input), but the data seems quite corrupted - almost too badly to recover. Almost.

 All you need to do is figure out which character is most frequent for each position. For example, suppose you had recorded the following messages:

 eedadn
 drvtee
 eandsr
 raavrd
 atevrs
 tsrnev
 sdttsa
 rasrtv
 nssdts
 ntnada
 svetve
 tesnvt
 vntsnd
 vrdear
 dvrsen
 enarar
 The most common character in the first column is e; in the second, a; in the third, s, and so on. Combining these characters returns the error-corrected message, easter.

 Given the recording in your puzzle input, what is the error-corrected version of the message being sent?

 Your puzzle answer was xhnqpqql.

 --- Part Two ---

 Of course, that would be the message - if you hadn't agreed to use a modified repetition code instead.

 In this modified code, the sender instead transmits what looks like random data, but for each character, the character they actually want to send is slightly less likely than the others. Even after signal-jamming noise, you can look at the letter distributions in each column and choose the least common letter to reconstruct the original message.

 In the above example, the least common character in the first column is a; in the second, d, and so on. Repeating this process for the remaining characters produces the original message, advent.

 Given the recording in your puzzle input and this new decoding methodology, what is the original message that Santa is trying to send?

 Your puzzle answer was brhailro.

 Both parts of this puzzle are complete! They provide two gold stars: **
 */

public class Day06 {

    public static void main(String[] args) throws FileNotFoundException {

        List<String> signals = new ArrayList<String>();
        Scanner scanner = new Scanner(new File("src\\main\\java\\Day06\\input6.txt"));
        while (scanner.hasNext()) {
            signals.add(scanner.nextLine());
        }

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        int row = 0;
        String message = "";
        String part2Message = "";
        int iterator = 0;

        while (message.length() < 8) {
            for (int i = 0; i < signals.size(); i++) {
                String signal = signals.get(i);

                char c = signal.charAt(iterator);
                Integer value = map.get(new Character(c));

                if (value != null) {
                    map.put(c, new Integer(value + 1));
                } else {
                    map.put(c, 1);
                }
            }

            int maxValue = Collections.max(map.values());
            int minValue = Collections.min(map.values());

            Iterator<Map.Entry<Character, Integer>> iter = map.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry<Character, Integer> entry = iter.next();
                if (entry.getValue().equals(maxValue)) {
                    String key = entry.getKey().toString();
                    message += key;
                }
                if (entry.getValue().equals(minValue)) {
                    String key = entry.getKey().toString();
                    part2Message += key;
                }
            }

            map.clear();
            iterator++;
        }

        System.out.println("Part 1 message:  " + message);
        System.out.println("Part 2 message:  " + part2Message);
    }
}
