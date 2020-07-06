package algorithm.boj.sort;

import java.io.*;
import java.util.Arrays;

public class BOJ1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] arr = br.readLine().split("");
        Arrays.sort(arr, (o1, o2) -> o2.compareTo(o1));
        for (String s : arr)
            bw.write(s);
        bw.flush();
    }
}