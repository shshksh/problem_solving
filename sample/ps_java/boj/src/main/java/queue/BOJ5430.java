package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            String command = br.readLine();
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), "[,]");
            Deque<String> d = new ArrayDeque<>();
            for (int j = 0; j < n; j++) {
                d.offer(st.nextToken());
            }

            sb.append(testcase(command, d)).append("\n");
        }

        System.out.println(sb.toString());
    }

    private static String testcase(String command, Deque<String> d) {
        int flag = 1;
        for (int i = 0; i < command.length(); i++) {
            switch (command.charAt(i)) {
                case 'R':
                    flag = flag ^ 1;
                    break;
                case 'D':
                    if (d.isEmpty())
                        return "error";
                    if (flag == 1)
                        d.pollFirst();
                    else
                        d.pollLast();
                    break;
            }
        }

        StringJoiner sj = new StringJoiner(",", "[", "]");
        Iterator<String> iterator = null;
        if (flag == 1)
            iterator = d.iterator();
        else
            iterator = d.descendingIterator();

        for (Iterator<String> it = iterator; it.hasNext(); ) {
            sj.add(it.next());
        }

        return sj.toString();
    }
}
