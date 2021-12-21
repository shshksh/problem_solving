package priorityqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o1 - o2);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            switch (num) {
                case 0:
                    if (pq.isEmpty())
                        sb.append(0 + "\n");
                    else
                        sb.append(pq.poll() + "\n");
                    break;
                default:
                    pq.offer(num);
            }
        }

        System.out.println(sb);
    }
}
