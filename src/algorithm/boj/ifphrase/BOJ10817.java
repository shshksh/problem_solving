package algorithm.boj.ifphrase;

import java.util.Scanner;

public class BOJ10817 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt(), num2 = sc.nextInt(), num3 = sc.nextInt();
        int fst, snd;
        if(num1 >= num2){
            fst = num1;
            snd = num2;
        }
        else {
            fst = num2;
            snd = num1;
        }
        snd = num3 <= snd ? snd : num3 <= fst ? num3 : fst;

        System.out.println(snd);
    }
}
