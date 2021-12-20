package greedy;

import java.util.Arrays;

public class Boat {
    public static int solution(int[] people, int limit) {
        Arrays.sort(people);
        int midIndex = -1;
        for (int i = people.length - 1; i >= 0; i--) {
            if (people[i] <= limit / 2) {
                midIndex = i;
                break;
            }
        }
        if (midIndex == people.length - 1)
            return (int) Math.ceil(people.length / 2);
        if (midIndex == -1)
            return people.length;

        int pair = 0;
        for (int i = midIndex + 1, j = midIndex; i < people.length && j >= 0; j--) {
            if (people[i] + people[j] <= limit) {
                pair++;
                i++;
            }
        }

        int alone = people.length - midIndex - pair - 1;
        double k = midIndex + 1 - pair;
        pair += (int) Math.ceil(k / 2);

        return alone + pair;
    }
}
