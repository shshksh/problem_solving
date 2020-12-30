package algorithm.boj.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        Deque<Integer> d = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            d.offer(i+1);
        }

        int sum = 0;
        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            int cnt = 0;
            while(d.peek() != num){
                d.offer(d.poll());
                cnt++;
            }
            cnt = Math.min(cnt, d.size() - cnt);
            sum += cnt;
            d.poll();
        }

        System.out.println(sum);
    }
}