package algorithm.boj.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringJoiner;
import java.util.StringTokenizer;

public class BOJ11866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        StringJoiner sj = new StringJoiner(", ", "<", ">");
        Queue<String> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            q.offer(String.valueOf(i+1));
        }

        while (!q.isEmpty()) {
            for (int i = 0; i < k-1; i++) {
                q.offer(q.poll());
            }
            sj.add(q.poll());
        }

        System.out.println(sj.toString());
    }
}