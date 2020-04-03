package boj.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1931 {
    static class Cost {
        int start;
        int end;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Cost[] arr = new Cost[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = new Cost();
            arr[i].start = Integer.parseInt(st.nextToken());
            arr[i].end = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (o1, o2) -> {
            if(o1.end == o2.end)
                return o1.start-o2.start;
            return o1.end-o2.end;
        });

        int finish = arr[0].end;
        int cnt = 1;
        for (int i = 1; i < n; i++) {
            if(arr[i].start >= finish){
                cnt++;
                finish = arr[i].end;
            }
        }

        System.out.println(cnt);
    }
}
