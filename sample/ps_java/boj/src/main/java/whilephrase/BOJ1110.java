package whilephrase;

import java.util.Scanner;

public class BOJ1110 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int num2 = num;
        int cnt;

        for (int i = 1; ; i++) {
            int fst = num2 % 10;
            int sec = num2 / 10 + num2 % 10;
            num2 = fst * 10 + sec % 10;

            if (num2 == num) {
                cnt = i;
                break;
            }
        }
        System.out.println(cnt);
    }

}
