package boj.divandcon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1629 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());;

        System.out.println(fastExpo(a, b, c));
    }

    private static long fastExpo(long a, long b, long c) {
        if(b==1)
            return (long)a%c;
        long m;
        m = fastExpo(a, b/2, c);
        if(b%2 == 0) {
            return (long)(m*m) % c;
        } else {
            return (long)(m*m)%c*a%c;
        }
    }

//    private static long fastExpo(long a, long b, long c) {
//        long m = 1;
//        long[] expo = new long[40];
//        expo[0] = a;
//        int i = 1;
//        for (; 1<<i <= b; i++) {
//            expo[i] = expo[i-1]*expo[i-1]%c;
//        }
//        i--;
//        while(b > 0) {
//            if (b >= 1<<i) {
//                m = (m*expo[i])%c;
//                b-= 1<<i;
//            }
//            i--;
//        }
//        return m;
//    }
}