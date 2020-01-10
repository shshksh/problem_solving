package programers.DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;

public class Network {
    public static int solution(int n, int[][] computers) {
        int answer = 0;
        int[] flag = new int[n];
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (flag[i] == 0) {
                flag[i] = 1;
                answer++;
                queue.offer(i); // root

                while (!queue.isEmpty()) {
                    int root = queue.poll();

                    for (int j = 0; j < n; j++) {
                        if(computers[root][j] == 1 && flag[j] == 0) {
                            flag[j] = 1;
                            queue.offer(j);
                        }
                    }
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(3, new int[][] {{1,1,0}, {1,1,1}, {0,1,1}}));
    }
}
