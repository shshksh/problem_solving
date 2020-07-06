package algorithm.boj.dp1;

import java.util.Scanner;

public class Tile01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int num1 = 1, num2 = 1;
        int sum = 3, fibo;
        for (int i = 3; i < n; i++,num1%=15746,num2%=15746,sum%=15746) {
            fibo = num1 + num2;
            num1 = num2;
            num2 = fibo;
            sum+=fibo;
        }
        if(n < 4)
            System.out.println(n);
        else
            System.out.println(sum);
    }
}