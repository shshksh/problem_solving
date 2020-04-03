package boj.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split("-");
        int result = 0;
        if(arr[0].contains("+")){
            String[] tmp = arr[0].split("\\+");
            for (int i = 0; i < tmp.length; i++) {
                result += Integer.parseInt(tmp[i]);
            }
        } else
            result = Integer.parseInt(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            int sum = 0;
            if(arr[i].contains("+")) {
                String[] tmp = arr[i].split("\\+");
                for (int j = 0; j < tmp.length; j++) {
                    sum += Integer.parseInt(tmp[j]);
                }
            } else
                sum = Integer.parseInt(arr[i]);
            result -= sum;
        }

        System.out.println(result);
    }
}
