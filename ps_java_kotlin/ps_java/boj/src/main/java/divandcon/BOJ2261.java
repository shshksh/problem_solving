package divandcon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2261 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] position = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            position[i][0] = Integer.parseInt(st.nextToken());
            position[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(position, (o1, o2) -> o1[0] - o2[0]);

        System.out.println(closestDistance(position, 0, n - 1));
    }

    private static long closestDistance(int[][] position, int start, int end) {
        if (start == end) {
            return Long.MAX_VALUE;
        }
        int boundary = (start + end) / 2;
        long leftClose = closestDistance(position, start, boundary);
        long rightClose = closestDistance(position, boundary + 1, end);
        long distance = Math.min(leftClose, rightClose);
        distance = Math.min(distance, boundaryDistance(position, start, end, boundary,
                distance));

        return distance;
    }

    private static long boundaryDistance(int[][] position, int start, int end,
                                         int boundary, long distance) {
        long minDistance = distance;
        distance = (long) Math.sqrt(distance);

        int leftPoint = boundary;
        int rightPoint = boundary + 1;
        while (leftPoint > start && position[leftPoint - 1][0] + distance > position[boundary][0])
            leftPoint--;
        while (rightPoint < end && position[rightPoint + 1][0] - distance < position[boundary + 1][0])
            rightPoint++;

        int[][] boundaryPosition = sortForY(position, leftPoint, rightPoint);

        for (int i = 0; i < boundaryPosition.length - 1; i++) {
            for (int j = i + 1; j < boundaryPosition.length; j++) {
                if (boundaryPosition[j][1] - boundaryPosition[i][1] <= distance) {
                    long tmp = distanceOf(boundaryPosition[i], boundaryPosition[j]);
                    minDistance = Math.min(minDistance, tmp);
                    distance = (long) Math.sqrt(minDistance);
                } else
                    break;
            }
        }

        return minDistance;
    }

    private static long distanceOf(int[] p1, int[] p2) {
        return (long) (Math.pow(p2[0] - p1[0], 2) + Math.pow(p2[1] - p1[1], 2));
    }

    private static int[][] sortForY(int[][] position, int leftPoint, int rightPoint) {
        int[][] subPosition = new int[rightPoint - leftPoint + 1][2];
        for (int i = leftPoint, j = 0; i < rightPoint + 1; i++) {
            subPosition[j++] = position[i];
        }
        Arrays.sort(subPosition, (o1, o2) -> o1[1] - o2[1]);
        return subPosition;
    }
}
