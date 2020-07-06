package algorithm.programmers.greedy;

public class Joystick {
//    public static int solution(String name) {
//        int answer = 0;
//        char c;
//        int exp = name.length()-1;
//
//        for (int i = 0; i < name.length(); i++) {
//            if((c=name.charAt(i)) != 'A') {
//                answer += Integer.min(c-65, 91-c);
//            } else {
//                int nextIdx = i+1;
//                int countA = 0;
//                while (nextIdx < name.length() &&
//                        name.charAt(nextIdx) == 'A'){
//                    countA ++;
//                    nextIdx++;
//                }
//                int tmp = (i-1)*2 + (name.length() -1 -i - countA) ;
//                if(exp > tmp) exp = tmp;
//            }
//        }
//
//        return answer+exp;
//    }
}
// 모든경우에 대해 최소 이동횟수가 아닌 그리디를 적용했을시 최소 이동횟수를 구해야 한다.