package algorithm.programmers.Level2;

public class World124 {
    public static String solution(int n) {
        int k = 1;
        int m = 1;
        while(n > k*3) {
            k*=3;
            n-=k;
            m++;
        }
        n--;
        int[] arr = new int[m];
        for (int i = m-1; i >= 0; i--, n/=3) {
            arr[i] = n%3;
        }
        String answer = "";
        for (int i : arr) {
            if (i==2) {
                answer+=4;
            } else
                answer += (i+1);
        }
        return answer;
    }
}