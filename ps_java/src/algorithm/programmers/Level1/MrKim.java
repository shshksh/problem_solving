package algorithm.programmers.Level1;

class MrKim {
    public String solution(String[] seoul) {
        for (int i = 0; i < seoul.length; i++) {
            if(seoul[i].equals("Kim"))
                return new String("김서방은 " + i + "에 있다");
        }
        return null;
    }
}