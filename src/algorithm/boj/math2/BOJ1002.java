package algorithm.boj.math2;

import java.util.Scanner;

public class BOJ1002 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int x1 = sc.nextInt(), y1 = sc.nextInt(), r1 = sc.nextInt(), x2 = sc.nextInt(), y2 = sc.nextInt(), r2 = sc.nextInt();
            int d = (x2-x1)*(x2-x1) + (y2-y1)*(y2-y1);
            int r3 = (r1 + r2)*(r1 + r2);
            int r4 = (r1-r2)*(r1-r2);
            if(d < r3 && d > r4)
                System.out.println(2);
            else if (d == 0 && r1 == r2)
                System.out.println(-1);
            else if (d == r3 || d == r4)
                System.out.println(1);
            else if(d > r3 || d < r4)
                System.out.println(0);
        }
    }
}