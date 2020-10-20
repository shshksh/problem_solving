package algorithm.programmers.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class DiskControllerXXX {

    public  static int solution(int[][] jobs) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if(o1[1] < o2[1]) return -1;
            else if(o1[1] == o2[1]) {
                if(o1[0] < o2[0]) return -1;
                else return 1;
            } else return 1;
        });

        List<int[]> list = new ArrayList<>();

        //PriorityQueue를 활용한 Job 정렬
        pq.addAll(Arrays.asList(jobs));

        //list에 우선순위 순으로 정렬된 Job 순차적으로 삽입
        for (int i = 0; i < jobs.length; i++) {
            list.add(pq.poll());
        }

        int time = 0;
        int sum = 0;
        while (list.size()>0) {
            for (int i = 0; i < list.size(); i++) {
                //시작시간이 현재 시간보다 이전이라면 시작 가능
                if (time>=list.get(i)[0]) {
                    time+=list.get(i)[1];
                    sum+=time-list.get(i)[0];
                    list.remove(i);
                    break;
                }
                //시작시간이 현재 시간보다 이전인 것이 없다면 시간 1초 증가
                if (i == list.size()-1) time++;
            }
        }

        return (sum/jobs.length);
    }

    public static void main(String[] args) {
//        System.out.println(solution(new int[][] {{0,3}, {1,9}, {2,6}}));
//        System.out.println(solution(new int[][] {{0,9}, {0,4}, {0,5}, {0,7}, {0,3}}));
//        System.out.println(solution(new int[][] {{1,9}, {1,4}, {1,5}, {1,7}, {1,3}}));2
        System.out.println(solution(new int[][] {{24,10}, {18,39}, {34,20}, {37,5}, {47,22}, {20, 47}, {15,2}, {15,34}, {35, 43}, {26,1}}));
    }
}