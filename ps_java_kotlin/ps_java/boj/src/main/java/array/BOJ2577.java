package array;

import java.util.Scanner;

public class BOJ2577 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];
        int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt(), d = a * b * c;
        for (int i = d; d > 0; d /= 10) {
            arr[d % 10]++;
        }
        for (int i : arr)
            System.out.println(i);
    }
}
