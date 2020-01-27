package boj.string;

import java.util.Scanner;

public class BOJ1316 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), cnt = 0;
        for (int i = 0; i < n; i++) {
            String str = sc.next();
            boolean[] chk = new boolean[26];
            for (int j = 0; j < str.length(); j++) {
                if(!chk[str.charAt(j)-'a'])
                    chk[str.charAt(j)-'a'] = true;
                else
                if(!(str.charAt(j) == str.charAt(j-1))) {
                    cnt++;
                    break;
                }

            }
        }
        System.out.println(n-cnt);
    }
}