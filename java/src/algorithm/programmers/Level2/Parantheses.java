package algorithm.programmers.Level2;

 public class Parantheses {
    public static String solution(String p) {
        if(p.isBlank() || isCorrectString(p))
            return p;
        int separatedIndex = separate(p);
        String u = p.substring(0, separatedIndex);
        String v = "";
        if(separatedIndex < p.length())
            v = p.substring(separatedIndex, p.length());
        String answer = "";
        if(isCorrectString(u)) {
            answer += u;
            answer += solution(v);
            return answer;
        } else {
            answer += "(";
            answer += solution(v);
            answer += ")";
            if(u.length() != 0) {
                StringBuilder sb = new StringBuilder(u.substring(1, u.length()-1));
                for (int i = 0; i < sb.length(); i++) {
                    if(sb.charAt(i) == '(')
                        sb.setCharAt(i, ')');
                    else if (sb.charAt(i) == ')')
                        sb.setCharAt(i, '(');
                }
                answer += sb.toString();
            }
        }
        return answer;
    }

    private static int separate(String p) {
        int cnt = 0;
        for (int i = 0; i < p.length(); i++) {
            if(p.charAt(i) == '(')
                cnt++;
            else if (p.charAt(i) == ')')
                cnt--;
            if(cnt == 0)
                return i+1;
        }
        return -1;
    }

    private static boolean isCorrectString(String p) {
        int k = 0;
        for (int i = 0; i < p.length(); i++) {
            if(p.charAt(i) == '(')
                k++;
            else if (p.charAt(i) == ')')
                k--;
            if(k < 0)
                return false;
        }
        return true;
    }
}
