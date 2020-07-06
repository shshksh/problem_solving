package algorithm.boj.sort;

import java.io.*;
import java.util.Arrays;

public class BOJ2751 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }
        Arrays.sort(arr, (o1, o2) -> Integer.parseInt(o1)-Integer.parseInt(o2));
        for (String s : arr) {
            bw.write(s + "\n");
        }
        bw.flush();
    }
}