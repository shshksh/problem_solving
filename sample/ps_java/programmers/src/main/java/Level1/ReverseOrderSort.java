package Level1;

class ReverseOrderSort {
    public String solution(String s) {
        int[] arr = s.chars().sorted().toArray();
        char[] str = new char[arr.length];
        for (int i = 0; i < str.length; i++)
            str[i] = (char) arr[i];
        return new StringBuilder(new String(str)).reverse().toString();
    }
}
