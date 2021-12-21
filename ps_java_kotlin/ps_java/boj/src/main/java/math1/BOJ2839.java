package math1;

import java.util.Scanner;

public class BOJ2839 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int weigh = sc.nextInt();
        int sum = 0;
        while (weigh > 0 && weigh % 5 != 0) {
            sum++;
            weigh -= 3;
        }
        if (weigh < 0) {
            if (weigh % 3 != 0)
                System.out.println(-1);
            else
                System.out.println(sum);
        } else
            System.out.println(sum + weigh / 5);
    }
}
