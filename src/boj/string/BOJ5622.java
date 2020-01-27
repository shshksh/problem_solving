package boj.string;

import java.util.Scanner;

public class BOJ5622 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        String str = sc.next();
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) <= 'O')
                sum+=(str.charAt(i)-'A')/3 + 3;
            else if (str.charAt(i) >= 'P' && str.charAt(i) <= 'S')
                sum+=8;
            else if (str.charAt(i) >= 'T' && str.charAt(i) <= 'V')
                sum += 9;
            else
                sum += 10;
        }

        System.out.println(sum);
    }
}