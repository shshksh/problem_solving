package algorithm.boj.divandcon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2749 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        long[][] arr = fastExpo(new long[][]{{0, 1}, {1, 1}}, n);
        System.out.println(arr[0][1]);
    }

    private static long[][] fastExpo(long[][] arr, long n) {
        if(n==1)
            return arr;
        long[][] temp = fastExpo(arr, n/2);
        if(n % 2 == 0)
            return multMatrix(temp, temp);
        else
            return multMatrix(multMatrix(temp, temp), arr);
    }

    private static long[][] multMatrix(long[][] arr1, long[][] arr2) {
        long[][] result = new long[2][2];
        result[0][0] = (arr1[0][0]*arr2[0][0] + arr1[0][1]*arr2[1][0]) % 1000000;
        result[0][1] = (arr1[0][0]*arr2[0][1] + arr1[0][1]*arr2[1][1]) % 1000000;
        result[1][0] = (arr1[1][0]*arr2[0][0] + arr1[1][1]*arr2[1][0]) % 1000000;
        result[1][1] = (arr1[1][0]*arr2[0][1] + arr1[1][1]*arr2[1][1]) % 1000000;
        return result;
    }
}