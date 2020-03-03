package programmers.Level2;

public class Ngcm {
    public int solution(int[] arr) {
        int result = arr[0];
        for (int i = 0; i < arr.length; i++)
            result = gcm(result, arr[i]);
        return result;
    }

    private int gcm(int p, int q) {
        return p * q / gcd(p,q);
    }

    private int gcd(int p, int q) {
        if(q == 0)
            return p;
        return gcd(q, p%q);
    }
}