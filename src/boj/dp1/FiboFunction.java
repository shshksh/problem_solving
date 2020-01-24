package boj.dp1;

import java.util.Scanner;

public class FiboFunction {
    static int[] cnt0 = new int[41];
    static int[] cnt1 = new int[41];

    public static void main(String[] args) {
        cnt0[0] = 1; cnt0[1] = 0;
        cnt1[0] = 0; cnt1[1] = 1;
        for (int i = 2; i < cnt0.length; i++) {
            cnt0[i] = cnt0[i-1]+cnt0[i-2];
            cnt1[i] = cnt1[i-1]+cnt1[i-2];
        }
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int k = sc.nextInt();
            System.out.println(cnt0[k] + " " + cnt1[k]);
        }
    }
}