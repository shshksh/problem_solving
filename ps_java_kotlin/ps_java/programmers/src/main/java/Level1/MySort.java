package Level1;

import java.util.Arrays;

class MySort {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, (o1, o2) -> {
            if (o1.charAt(n) == o2.charAt(n))
                return o1.compareTo(o2);
            return Character.compare(o1.charAt(n), o2.charAt(n));
        });
        return strings;
    }
}
