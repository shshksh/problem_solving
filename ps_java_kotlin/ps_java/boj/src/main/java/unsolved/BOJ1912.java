package unsolved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] data = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }
        int[] arr = new int[n + 1];
        arr[0] = -1000;

        int max = -1000;
        for (int i = 1; i <= n; i++) {
            arr[i] = Math.max(0, arr[i - 1]) + data[i];
            max = Math.max(arr[i], max);
        }

        System.out.println(max);
    }
}
