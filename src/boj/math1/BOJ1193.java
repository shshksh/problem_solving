package boj.math1;

import java.util.Scanner;

public class BOJ1193 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i = 1;
        while(n > i*(i+1)/2){
            i++;
        }
        int u, d;
        int differ = i*(i+1)/2 - n;
        if(i%2 == 0) {
            u=i - differ;
            d=1 + differ;
        } else {
            u=1 + differ;
            d=i - differ;
        }
        System.out.println(u+"/"+d);
    }
}