package algorithm.boj.function;

public class BOJ4673 {
    static boolean[] chk = new boolean[10001];

    public static void main(String[] args) {
        for (int i = 1; i < chk.length; i++) {
            if(!chk[i])
                chkNum(i);
        }

        for (int i = 1; i < chk.length; i++) {
            if(!chk[i])
                System.out.println(i);
        }
    }

    private static void chkNum(int i) {
        for (int j = nextNum(i); j < chk.length; j=nextNum(j)) {
            chk[j] = true;
        }
    }

    private static int nextNum(int t) {
        for (int i = t; i > 0 ; i/=10) {
            t+= i%10;
        }
        return t;
    }
}