package sort;

import java.io.*;
import java.util.Arrays;

public class BOJ1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = br.readLine();
        }
        Arrays.sort(arr, (o1, o2) -> {
            if (o1.length() == o2.length())
                return o1.compareTo(o2);
            return o1.length() - o2.length();
        });
        bw.write(arr[0] + "\n");
        for (int i = 1; i < arr.length; i++) {
            if (!arr[i].equals(arr[i - 1]))
                bw.write(arr[i] + "\n");
        }

        bw.flush();
    }
}
