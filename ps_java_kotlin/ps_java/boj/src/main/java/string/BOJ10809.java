package string;

import java.util.Scanner;

public class BOJ10809 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        for (char i = 'a'; i <= 'z'; i++) {
            System.out.println(word.indexOf(i));
        }
        sc.close();
    }
}
