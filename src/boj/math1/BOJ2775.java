package boj.math1;

import java.util.Scanner;

public class BOJ2775 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int floor = sc.nextInt();
            int room = sc.nextInt();
            int[] curr = new int[room];
            for (int j = 0; j < curr.length; j++) {
                curr[j] = j+1;
            }
            for (int j = 0; j < floor; j++) {
                for (int k = 1; k < room; k++) {
                    curr[k] = curr[k-1]+curr[k];
                }
            }
            System.out.println(curr[curr.length-1]);
        }
    }
}