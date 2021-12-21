package string;

import java.util.Scanner;

public class BOJ11720 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        int k = 0;
        for (int i = 0; i < str.length(); i++) {
            k += str.charAt(i) - '0';
        }
        System.out.println(k);
    }
}
