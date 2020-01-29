package boj.math1;

import java.util.Scanner;

public class BOJ1712 {
    public static void main(String[] args) {
        long fixedCost, productCost, price;
        Scanner sc = new Scanner(System.in);

        fixedCost = sc.nextInt();
        productCost = sc.nextInt();
        price = sc.nextInt();

        long totalCost = fixedCost + productCost, totalBenefit = price;

        int i = 1;
        if(productCost < price)
            while (totalCost >= totalBenefit) {
                totalCost += productCost;
                totalBenefit += price;
                i++;
            }
        else
            i = -1;

        System.out.println(i);

        sc.close();
    }
}
