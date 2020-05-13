package boj.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        long max = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }

        long length = cutWire(arr, k, 0, max);
        System.out.println(length);
    }

    private static long cutWire(int[] arr, int k, long start, long end) {
        long count = 0;
        for (int i = 0; i < arr.length; i++) {
            count += arr[i] / end;
        }
        if(start >= end)
            return end;
        if (count < k)
            return cutWire(arr, k, start, (start+end)/2);
        else
            return cutWire(arr, k, end, end+(start+end)/2);
    }
}