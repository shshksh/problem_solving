package math2;

import java.util.Scanner;

public class BOJ3053 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        System.out.println(String.format("%.6f", Math.PI * r * r));
        System.out.println(String.format("%.6f", (double) r * r * 2));
    }
}
