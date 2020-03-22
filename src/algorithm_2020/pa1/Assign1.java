package algorithm_2020.pa1;

import java.util.Scanner;

public class Assign1 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        int[] data = new int[n];
        input(n, 0, data);
        int k = sc.nextInt();
        System.out.println(rank(n,0,k, data, 0));
    }

    private static int rank(int n, int i, int k, int[] data, int cnt) {
        if(i == n)
            return cnt+1;
        if(data[i] < k)
            return rank(n,i+1, k, data, cnt+1);
        else
            return rank(n,i+1, k, data, cnt);
    }

    private static void input(int n, int i, int[] data) {
        if (i == n)
            return;
        data[i] = sc.nextInt();
        input(n, i + 1, data);
    }
}
