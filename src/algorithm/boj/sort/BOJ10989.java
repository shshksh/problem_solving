package algorithm.boj.sort;

import java.io.*;

public class BOJ10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[10001];
        for (int i = 0; i < n; i++) {
            arr[Integer.parseInt(br.readLine())]++;
        }
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > 0)
                for(int j = arr[i]-1; j >= 0; j--) {
                    bw.write(String.valueOf(i) + "\n");
                }
        }
        bw.flush();
    }
}