package algorithm.algorithm_2020.pa1;

import java.util.Scanner;

public class Assign3 {
    static int n, k;
    static int[] data;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        input();
        System.out.println(loop1(0)+1);
    }

    private static int loop1(int i) {
        int cnt = 0;
        if(i == n-2)
            return cnt;
        cnt += loop2(i+1, 0, data[i]);
        return cnt + loop1(i+1);
    }

    private static int loop2(int i, int cnt, int sum) {
        if(i == n-1)
            return cnt;
        cnt += loop3(i+1, 0, sum+data[i]);
        return cnt + loop2(i+1, 0, sum);
    }

    private static int loop3(int i, int cnt, int sum) {
        if(sum >= k)
            return 0;
        if(i == n)
            return cnt;
        if(sum + data[i] == k)
            cnt++;
        return loop3(i+1, cnt, sum);
    }

    private static void input() {
        n = sc.nextInt();
        data = new int[n];
        inputData(0);
        k = sc.nextInt();
    }

    private static void inputData(int i) {
        if(i == n)
            return;
        data[i] = sc.nextInt();
        inputData(i+1);
    }

}
