package boj.unsolved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BOJ9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int clothesCnt = Integer.parseInt(br.readLine());
            HashMap<String, Integer> map = new HashMap<>();

            for (int j = 0; j < clothesCnt; j++) {
                String[] cloth = br.readLine().split(" ");
                map.put(cloth[1], map.getOrDefault(cloth[1], 1)+1);
            }

            int sum = 1;
            for (Integer value : map.values()) {
                sum *= value;
            }

            System.out.println(sum-1);
        }
    }
}