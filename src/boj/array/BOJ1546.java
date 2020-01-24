package boj.array;

import java.util.Scanner;

public class BOJ1546 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0, max = 0, k;
        for (int i = 0; i < n; i++) {
            k=sc.nextInt();
            if(k>max)
                max = k;
            sum+=k;
        }
        System.out.println((double)sum * 100 / max / n);
    }
}