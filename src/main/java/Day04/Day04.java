package Day04;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by Jeremy on 12/8/2016.
 * 
 --- Day 4: Security Through Obscurity ---

 Finally, you come across an information kiosk with a list of rooms. Of course, the list is encrypted and full of decoy data, but the instructions to decode the list are barely hidden nearby. Better remove the decoy data first.

 Each room consists of an encrypted name (lowercase letters separated by dashes) followed by a dash, a sector ID, and a checksum in square brackets.

 A room is real (not a decoy) if the checksum is the five most common letters in the encrypted name, in order, with ties broken by alphabetization. For example:

 aaaaa-bbb-z-y-x-123[abxyz] is a real room because the most common letters are a (5), b (3), and then a tie between x, y, and z, which are listed alphabetically.
 a-b-c-d-e-f-g-h-987[abcde] is a real room because although the letters are all tied (1 of each), the first five are listed alphabetically.
 not-a-real-room-404[oarel] is a real room.
 totally-real-room-200[decoy] is not.
 Of the real rooms from the list above, the sum of their sector IDs is 1514.

 What is the sum of the sector IDs of the real rooms?

 Your puzzle answer was 278221.

 --- Part Two ---

 With all the decoy data out of the way, it's time to decrypt this list and get moving.

 The room names are encrypted by a state-of-the-art shift cipher, which is nearly unbreakable without the right software. However, the information kiosk designers at Easter Bunny HQ were not expecting to deal with a master cryptographer like yourself.

 To decrypt a room name, rotate each letter forward through the alphabet a number of times equal to the room's sector ID. A becomes B, B becomes C, Z becomes A, and so on. Dashes become spaces.

 For example, the real name for qzmt-zixmtkozy-ivhz-343 is very encrypted name.

 What is the sector ID of the room where North Pole objects are stored?
 */

public class Day04 {

    public static void main(String[] args) throws FileNotFoundException {
        List<String> roomsList = new ArrayList<String>();
        int sum = 0;

        Scanner scanner = new Scanner(new File("src\\main\\java\\Day04\\input4.txt"));
        while (scanner.hasNext()) {
            roomsList.add(scanner.nextLine());
        }

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < roomsList.size(); i++) {
            String room = roomsList.get(i);
            String checksum = room.substring(room.length() - 6, room.length() - 1);
            int sectorId = Integer.parseInt(room.substring(room.length() - 10, room.length() - 7));
            int shiftAmount = sectorId % 26;
            String alphabet = "abcdefghijklmnopqrstuvwxyz";

            boolean isDecoy = false;
            String decryptedString = "";

            for (int j = 0; j < room.length(); j++) {
                char c = room.charAt(j);
                Integer value = map.get(new Character(c));
                if (Character.isDigit(room.charAt(j))) {
                    map.remove('-');
                    for (int k = 0; k < checksum.length(); k++) {
                        int maxValue = Collections.max(map.values());
                        try {
                            if (map.get(checksum.charAt(k)) == maxValue) {
                                map.remove(checksum.charAt(k));
                                maxValue = Collections.max(map.values());
                            } else {
                                isDecoy = true;
                                break;
                            }
                        } catch (Exception e) {
                            isDecoy = true;
                            break;
                        }

                    }
                    map.clear();
                    break;
                } else {

                    //part2
                    int position = alphabet.indexOf(c);

                    if (position == -1) {
                        decryptedString += " ";
                    } else {
                        int endPosition = position + shiftAmount;
                        if (endPosition > 25) {
                            endPosition = -(26 - endPosition);
                        }
                        decryptedString += alphabet.charAt(endPosition);
                    }

                    if (value != null) {
                        map.put(c, new Integer(value + 1));
                    } else {
                        map.put(c, 1);
                    }
                }
            }
            if (!isDecoy) {
                System.out.println("Part 2, Sector ID:  " + sectorId + "     Decrypted message:  " + decryptedString);
                decryptedString = "";
            }

        }
        System.out.println("Part 1, sum of sector IDs of the real rooms: " + sum);
    }
}
