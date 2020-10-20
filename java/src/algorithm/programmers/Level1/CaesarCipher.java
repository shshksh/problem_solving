package algorithm.programmers.Level1;

public class CaesarCipher {
    public String solution(String s, int n) {
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if(Character.isLowerCase(arr[i])){
                arr[i] = (char) (arr[i]+n > 'z' ? (arr[i]+n)-'z'+'a'-1 : arr[i]+n);
            } else if (Character.isUpperCase(arr[i])) {
                arr[i] = (char) (arr[i]+n > 'Z' ? (arr[i]+n)-'Z'+'A'-1 : arr[i]+n);
            }
        }
        return new String(arr);
    }
}