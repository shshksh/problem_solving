package boj.string;

import java.util.Scanner;

public class BOJ1157 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next().toLowerCase();
        int[] alpha = new int[26];
        int max = 0, num = 0;
        for (int i = 0; i < str.length(); i++) {
            alpha[str.charAt(i)-'a']++;
        }
        for (int i = 0; i < alpha.length; i++) {
            if(alpha[i] > alpha[max]){
                max = i;
                num = 1;
            } else if (alpha[i] == alpha[max]) {
                num++;
            }
        }
        if(num > 1)
            System.out.println("?");
        else
            System.out.println((char)(max+'A'));
    }
}