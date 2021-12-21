package sort;

import java.io.*;
import java.util.Arrays;

public class BOJ11650 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Pos[] arr = new Pos[n];
        for (int i = 0; i < n; i++) {
            String[] pos = br.readLine().split(" ");
            arr[i] = new Pos(Integer.parseInt(pos[0]), Integer.parseInt(pos[1]));
        }
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            bw.write(arr[i].toString());
        }
        bw.flush();
    }

    static class Pos implements Comparable<Pos> {
        public int x;
        public int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return x + " " + y + "\n";
        }

        @Override
        public int compareTo(Pos o) {
            if (x < o.x)
                return -1;
            else if (x > o.x)
                return 1;
            else
                return y - o.y;
        }
    }
}
