package math1;

import java.util.Scanner;

public class BOJ10250 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int height = sc.nextInt();
            int width = sc.nextInt();
            int n = sc.nextInt();
            String h = String.valueOf(n % height);
            if (h.equals("0"))
                h = String.valueOf(height);
            String room = String.valueOf((int) Math.ceil((double) n / height));
            if (Integer.parseInt(room) < 10)
                room = "0" + room;
            System.out.println(h + room);
        }
    }
}
