package programmers.hash;

import java.util.HashMap;

public class PhoneNumberList {
    public boolean solution(String[] phone_book) {
        HashMap<String, Integer> list = new HashMap<>();

        for (String number : phone_book) {
            // 모든 번호에 대해 리스트에 접두사가 있거나 자신을 접두사로 가지는 번호가 있으면 return false 없으면 리스트에 추가
            for (String s : list.keySet()) {
                if(number.startsWith(s) || s.startsWith(number))
                    return false;
            }
            list.put(number, 1);
        }
        return true;
    }
}
/*
정확성  테스트
테스트 1 〉	통과 (0.57ms, 52MB)
테스트 2 〉	통과 (0.87ms, 52.5MB)
테스트 3 〉	통과 (0.54ms, 52MB)
테스트 4 〉	통과 (0.59ms, 52.5MB)
테스트 5 〉	통과 (0.56ms, 52.4MB)
테스트 6 〉	통과 (0.74ms, 51MB)
테스트 7 〉	통과 (0.83ms, 52.1MB)
테스트 8 〉	통과 (0.54ms, 52.5MB)
테스트 9 〉	통과 (0.57ms, 50.5MB)
테스트 10 〉	통과 (0.59ms, 52.5MB)
테스트 11 〉	통과 (0.80ms, 50.4MB)
효율성  테스트
테스트 1 〉	통과 (0.91ms, 59.3MB)
테스트 2 〉	통과 (0.97ms, 56.5MB)

정확성  테스트
테스트 1 〉	통과 (0.58ms, 51.9MB)
테스트 2 〉	통과 (0.49ms, 52.6MB)
테스트 3 〉	통과 (0.74ms, 52.4MB)
테스트 4 〉	통과 (0.84ms, 51.7MB)
테스트 5 〉	통과 (0.52ms, 50.2MB)
테스트 6 〉	통과 (0.60ms, 54.3MB)
테스트 7 〉	통과 (0.53ms, 53MB)
테스트 8 〉	통과 (0.63ms, 52.5MB)
테스트 9 〉	통과 (0.66ms, 52.4MB)
테스트 10 〉	통과 (0.51ms, 52.7MB)
테스트 11 〉	통과 (0.89ms, 52.4MB)
효율성  테스트
테스트 1 〉	통과 (0.86ms, 57MB)
테스트 2 〉	통과 (0.82ms, 61.7MB)

정확성  테스트
테스트 1 〉	통과 (0.80ms, 52.4MB)
테스트 2 〉	통과 (0.74ms, 52MB)
테스트 3 〉	통과 (0.73ms, 52.5MB)
테스트 4 〉	통과 (0.57ms, 52.3MB)
테스트 5 〉	통과 (0.56ms, 50.8MB)
테스트 6 〉	통과 (0.74ms, 54.4MB)
테스트 7 〉	통과 (0.55ms, 50.3MB)
테스트 8 〉	통과 (0.78ms, 52.4MB)
테스트 9 〉	통과 (0.55ms, 52.4MB)
테스트 10 〉	통과 (0.63ms, 51.8MB)
테스트 11 〉	통과 (0.56ms, 50.9MB)
효율성  테스트
테스트 1 〉	통과 (39.74ms, 57.8MB)
테스트 2 〉	통과 (47.91ms, 58.2MB)
 */
