package algorithm.programmers.Level1;

public class StrangeString {
    public String solution(String s) {
        char[] arr = s.toCharArray();
        for (int i = 0, j = 0; i < arr.length; i++,j++) {
            if(arr[i] == ' ')
                j = 1;
            if(j%2==0)
                arr[i] = Character.toUpperCase(arr[i]);
            else
                arr[i] = Character.toLowerCase(arr[i]);
        }
        return new String(arr);
    }
}