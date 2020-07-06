package algorithm.boj.math1;

import java.util.Scanner;

public class BOJ1011 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int j = 0; j < t; j++) {
            int x = sc.nextInt(), y = sc.nextInt();
            int distance = y-x;
            long i = (long)Math.ceil(Math.sqrt((double)distance))-1;
            while(true){
                if(distance > i*i+i && distance <= (i+1)*(i+1)) {
                    System.out.println(i*2+1);
                    break;
                }
                if(distance > i*i && distance <= (i+1)*(i+1)-i){
                    System.out.println(i*2);
                    break;
                }

                i++;
            }
        }
    }
}