package Level2;

public class NextNumber {

    public static int solution(int n) {
        int cnt = 0, bit = -1;
        for (int i = 1; i <= n; i <<= 1, bit++) {
            if ((n & i) > 0)
                cnt++;
        }
        if (isBiggest(n, 1 << bit, cnt)) {
            n = 1 << (bit + 1);
            for (int i = 1, f = 1; i < cnt; i++, f <<= 1) {
                n = n ^ f;
            }
        } else {
            int i = 1;
            while ((n & i) == 0) {
                i <<= 1;
            } // i 는 가장 낮은 1비트
            cnt = 0;
            while ((n & i) > 0) {
                n ^= i;
                i <<= 1;
                cnt++;
            } // i 는 1 이후에 나오는 0비트
            n |= i;
            for (int j = 1, k = 1; j < cnt; j++, k <<= 1) {
                n ^= k;
            }
        }

        return n;
    }

    private static boolean isBiggest(int n, int flag, int cnt) {
        for (int i = flag; i >= 0 && cnt > 0; i >>= 1, cnt--) {
            if ((n & i) == 0)
                return false;
        }
        return true;
    }
}
