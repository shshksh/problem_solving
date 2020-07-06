package algorithm.boj.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            Queue<Integer> q = new LinkedList<>();
            for (int j = 0; j < n; j++) {
                q.offer(Integer.parseInt(st.nextToken()));
            }
            System.out.println(test(n, m, q));
        }
    }

    private static int test(int n, int m, Queue<Integer> q) {
        int[] arr = new int[q.size()];
        int index = -1;
        for (Integer integer : q) {
            arr[index+1] = integer;
            index++;
        }
        Arrays.sort(arr);
        int cnt = 1;

        while (true) {
            if (q.peek().equals(arr[index])) {
                if (m == 0)
                    return cnt;
                m--;
                if (m < 0)
                    m = q.size() - 1;
                cnt++;
                index--;
                q.poll();
            } else {
                q.offer(q.poll());
                m--;
                if (m < 0)
                    m = q.size() - 1;
            }
        }
    }
}