package boj.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2805 {
    static int[] arr;
    static int n, m, max=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }

        System.out.println(maxCut(0, max));
    }

    private static long maxCut(long start, long cutSize) {
        long sum = 0;
        for (int i = 0; i < n; i++) {
            if(arr[i] > cutSize)
                sum += arr[i]-cutSize;
        }
        if(start >= cutSize)
            return cutSize;
        if(sum < m)
            return maxCut(start,(start+cutSize) /2);
        else
            return maxCut(cutSize, cutSize+Math.round((cutSize-start) /2.0));
    }
}