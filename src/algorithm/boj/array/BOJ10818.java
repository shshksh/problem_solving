package algorithm.boj.array;

import java.util.Scanner;

public class BOJ10818 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int min = sc.nextInt(), max = min;
        int tmp;
        for (int i = 1; i < n; i++) {
            tmp = sc.nextInt();
            if(tmp < min)
                min = tmp;
            else if (tmp > max)
                max = tmp;
        }
        System.out.println(min + " " +  max);
    }
}