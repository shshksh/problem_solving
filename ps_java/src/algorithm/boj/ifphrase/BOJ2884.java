package algorithm.boj.ifphrase;

import java.util.Scanner;

public class BOJ2884 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int m = sc.nextInt();
        if(m < 45) {
            if(t == 0)
                t=23;
            else
                t-=1;
            m+=15;
        } else
            m-=45;
        System.out.println(t + " " + m);
    }
}
