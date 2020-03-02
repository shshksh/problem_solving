package programmers.Level2;

public class JadenCase {
    public String solution(String s) {
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            int start = i;
            while(i < arr.length && !Character.isSpaceChar(arr[i])) {
                if(Character.isLetter(arr[i]))
                    arr[i] = Character.toLowerCase(arr[i]);
                i++;
            }
            if(Character.isLetter(arr[start]))
                arr[start] = Character.toUpperCase(arr[start]);
        }

        return new String(arr);
    }
}