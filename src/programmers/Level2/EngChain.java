package programmers.Level2;

import java.util.HashSet;

public class EngChain {
    public int[] solution(int n, String[] words) {
        HashSet<String> set = new HashSet<>();
        for (int i = 0, k = 1; i < words.length; k++) {
            for (int j = 1; i < words.length && j <= n; j++, i++) {
                if (i > 0 && !words[i - 1].endsWith(words[i].substring(0, 1)) || set.contains(words[i])) {
                    return new int[]{j, k};
                }
                set.add(words[i]);
            }
        }
        return new int[]{0, 0};
    }
}