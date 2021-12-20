package string;

import java.util.Scanner;

public class BOJ2908 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = new StringBuilder(sc.next()).reverse().toString();
        String str2 = new StringBuilder(sc.next()).reverse().toString();

        if (str1.compareTo(str2) < 0)
            System.out.println(str2);
        else
            System.out.println(str1);

    }
}
