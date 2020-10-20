package algorithm.programmers.hash;

import java.util.HashMap;
import java.util.Map;

public class Unreachable {
    /*public static String solution(String[] participant, String[] completion) {
        // 정렬을 이용한 비교
        Arrays.sort(participant);
        Arrays.sort(completion);
        for (int i = 0; i < completion.length; i++) {
            if(!participant[i].equals(completion[i])) {
                return participant[i];
            }
        }
        // 일치하지 않는 요소가 없다면 가장 마지막 요소 반환
        return participant[participant.length-1];
    }*/
    //HashMap 을 이용한 풀이
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hm = new HashMap<>();
        for (String player : participant) hm.put(player, hm.getOrDefault(player, 0) + 1);
        for (String player : completion) hm.put(player, hm.get(player) - 1);

        for (Map.Entry<String, Integer> entry : hm.entrySet()) {
            if(entry.getValue() != 0)
                return entry.getKey();
        }

        return answer;
    }
}
