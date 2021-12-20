package math3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ5086 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String number = br.readLine();
        while (!number.equals("0 0")) {
            StringTokenizer st = new StringTokenizer(number);
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            if (n1 % n2 == 0)
                System.out.println("multiple");
            else if (n2 % n1 == 0)
                System.out.println("factor");
            else
                System.out.println("neither");

            number = br.readLine();
        }
    }
}
