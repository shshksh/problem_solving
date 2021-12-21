package DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;

public class ConvertWord {
    public static int solution(String begin, String target, String[] words) {
        Queue<String> q = new LinkedList<>();
        boolean[] flag = new boolean[words.length];
        q.offer(begin);
        int count = 0;

        while (!q.isEmpty()) {
            count++;
            int t = q.size();
            for (int i = 0; i < t; i++) {
                String wd = q.poll();
                for (int j = 0; j < words.length; j++) {
                    if (!flag[j] && isSimilar(wd, words[j])) {
                        if (words[j].equals(target))
                            return count;
                        flag[j] = true;
                        q.offer(words[j]);
                    }
                }
            }
        }
        return 0;
    }

    private static boolean isSimilar(String current, String word) {
        int cnt = 0;
        for (int i = 0; i < current.length(); i++)
            if (current.charAt(i) != word.charAt(i))
                cnt++;
        return cnt <= 1;
    }

    public static void main(String[] args) {
        System.out.println(solution("hit", "cog", new String[]{"hot", "dot", "dog",
                "lot", "log", "cog"}));
    }
}
