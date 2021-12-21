package Level1;

class PYcnt {
    boolean solution(String s) {
        s = s.toLowerCase();
        int[] chk = new int[2];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'p')
                chk[0]++;
            else if (s.charAt(i) == 'y')
                chk[1]++;
        }
        return chk[0] == chk[1];
    }
}
