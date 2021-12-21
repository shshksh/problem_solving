package Level2;

import java.util.ArrayList;
import java.util.Collections;

public class NewsClustering {
    public int solution(String str1, String str2) {
        StringBuilder sb1 = new StringBuilder(str1.toLowerCase());
        StringBuilder sb2 = new StringBuilder(str2.toLowerCase());

        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();

        for (int i = 0; i < sb1.length() - 1; i++) {
            if (Character.isLetter(sb1.charAt(i)) && Character.isLetter(sb1.charAt(i + 1)))
                list1.add(sb1.substring(i, i + 2));
        }
        for (int i = 0; i < sb2.length() - 1; i++) {
            if (Character.isLetter(sb2.charAt(i)) && Character.isLetter(sb2.charAt(i + 1)))
                list2.add(sb2.substring(i, i + 2));
        }
        if (list1.size() == 0 && list2.size() == 0)
            return 65536;

        Collections.sort(list1);
        Collections.sort(list2);

        int cnt = 0;
        for (int i = 0, j = 0; i < list1.size() && j < list2.size(); ) {
            if (list1.get(i).compareTo(list2.get(j)) < 0)
                i++;
            else if (list1.get(i).compareTo(list2.get(j)) > 0)
                j++;
            else {
                cnt++;
                i++;
                j++;
            }
        }

        int n = list1.size() + list2.size() - cnt;

        return 65536 * cnt / n;
    }
}
