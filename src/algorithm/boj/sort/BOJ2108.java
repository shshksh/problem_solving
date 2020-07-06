package algorithm.boj.sort;

import java.io.*;

public class BOJ2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[8001];

        int k  = 0;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            int index = Integer.parseInt(br.readLine())+4000;
            arr[index]++;
            sum += index - 4000;
            if (arr[index] > arr[k])
                k = index;
        }
        bw.write(String.valueOf (Math.round((double)sum / n)) + "\n");

        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > 0) {
                if (cnt+arr[i] < (n+1)/2
                )
                    cnt += arr[i];
                else {
                    bw.write(String.valueOf(i - 4000) + "\n");
                    break;
                }
            }
        }

        for (int i = 0, j = 0; i < arr.length; i++) {
            if(j==2)
                break;
            if(arr[i] == arr[k]) {
                k= i;
                j++;
            }
        }
        bw.write(String.valueOf(k-4000) + "\n");

        int min = 0, max = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > 0) {
                min = i-4000;
                break;
            }
        }
        for(int i = arr.length-1; i >= 0; i--) {
            if(arr[i] > 0) {
                max = i - 4000;
                break;
            }
        }
        bw.write(String.valueOf(max-min) + "\n");

        bw.flush();
    }
}