package Level1;

public class Middle {
    public static String solution(String s) {
        int len = s.length();
        if (len % 2 == 1)
            return s.substring(len / 2, len / 2 + 1);
        return s.substring(len / 2 - 1, len / 2 + 1);
    }

    public static void main(String[] args) {
        System.out.println(solution("qwer"));
    }
}
