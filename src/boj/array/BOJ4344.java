package boj.array;

import java.util.Scanner;

public class BOJ4344 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] students = new int[1000];
        for (int i = 0; i < n; i++) {
            int number = sc.nextInt();
            double sum = 0;
            for (int j = 0; j < number; j++) {
                students[j] = sc.nextInt();
                sum+=students[j];
            }
            int cnt = 0;
            sum/=number;
            for (int j = 0; j < number; j++) {
                if(students[j] > sum)
                    cnt++;
            }
            System.out.println(String.format("%.3f", (double)cnt/number * 100) + "%");
        }
    }
}