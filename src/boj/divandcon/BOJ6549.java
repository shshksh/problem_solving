package boj.divandcon;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ6549 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
        int n;
        StringTokenizer st = new StringTokenizer(br.readLine());
        while ((n = Integer.parseInt(st.nextToken())) != 0) {
            long[] heights = new long[n];
            for (int i = 0; i < n; i++) {
                heights[i] = Long.parseLong(st.nextToken());
            }

            System.out.println(largestRect(heights, 0, n-1));
//            sb.append(largestRect(heights, 0, n-1)).append("\n");
            st = new StringTokenizer(br.readLine());
        }
//        System.out.print(sb);
    }

    private static long largestRect(long[] heights, int start, int end) {
        if (start == end)
            return heights[start];
        int mid = (start + end) / 2;
        long result = Math.max(largestRect(heights, start, mid), largestRect(heights, mid + 1, end));
        result = Math.max(result, currentRect(heights, start, end, mid, mid + 1));
        return result;
    }

    private static long currentRect(long[] heights, int start, int end, int left, int right) {
        long height = Math.min(heights[left], heights[right]);
        long width = right - left + 1;
        long area = height * width;

        while (!(left == start && right == end)) {
            long tmp = height;
            if(left == start) {
                right++;
                tmp = heights[right];
            } else if(right == end) {
                left--;
                tmp = heights[left];
            } else {
                if(heights[left-1] >= heights[right+1]) {
                    left--;
                    tmp = heights[left];
                } else if (heights[right+1] >= heights[left-1]) {
                    right++;
                    tmp = heights[right];
                }
            }
            width++;
            height = Math.min(height, tmp);
            area = Math.max(area, height * width);
        }

        return area;
    }
}