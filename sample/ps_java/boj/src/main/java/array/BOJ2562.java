package array;

import java.util.Scanner;

public class BOJ2562 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int index = -1, max = -1;
        int tmp;
        for (int i = 1; i < 10; i++) {
            tmp = sc.nextInt();
            if (tmp > max) {
                max = tmp;
                index = i;
            }
        }
        System.out.println(max);
        System.out.println(index);
    }
}
