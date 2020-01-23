package programers.greedy;

import java.util.Arrays;

class Camera {
    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes, (o1, o2) -> o1[1] - o2[1]);
        int point; // 첫 진출 차량의 진출점

        for (int i = 0; i < routes.length;) {
            answer++;
            point = routes[i][1];
            while(i < routes.length && routes[i][0] <= point) {
                i++;
            }
        }

        return answer;
    }
}