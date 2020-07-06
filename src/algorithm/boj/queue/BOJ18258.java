package algorithm.boj.queue;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ18258 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        int earliest = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "push":
                    earliest = Integer.parseInt(st.nextToken());
                    q.offer(earliest);
                    break;
                case "pop":
                    if (q.isEmpty())
                        sb.append("-1\n");
                    else
                        sb.append(q.poll()).append("\n");
                    break;
                case "size":
                    sb.append(q.size()).append("\n");
                    break;
                case "empty":
                    if (q.isEmpty())
                        sb.append("1\n");
                    else
                        sb.append("0\n");
                    break;
                case "front":
                    if (q.isEmpty())
                        sb.append("-1\n");
                    else
                        sb.append(q.peek()).append("\n");
                    break;
                case "back":
                    if (q.isEmpty())
                        sb.append("-1\n");
                    else
                        sb.append(earliest).append("\n");
                    break;
            }
        }
        System.out.println(sb.toString());
    }
}