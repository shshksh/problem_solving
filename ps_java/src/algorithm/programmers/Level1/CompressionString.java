package algorithm.programmers.Level1;

public class CompressionString {
    public static int solution(String s) {
        int answer = s.length(), length;
        for (int i = 1; i <= s.length()/2; i++) {
            length = compressBy(s, i);
            if(length < answer)
                answer = length;
        }
        return answer;
    }

    private static int compressBy(String s, int i) {
        String comp = "";
        int j = 0;
        for (; j+i < s.length();) {
            int cnt = 0;
            String prefix = s.substring(j, j+i);
            while(j < s.length() && s.substring(j).startsWith(prefix)) {
                cnt++;
                j+=i;
            }
            if(cnt > 1)
                comp += String.valueOf(cnt);
            comp += prefix;
        }
        comp += s.substring(j, s.length());
        return comp.length();
    }
}