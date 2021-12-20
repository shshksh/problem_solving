package sort;

public class MaxNumber {
    static int num = 0;

    public static String solution(int[] numbers) {
        quickSort(numbers, 0, numbers.length - 1, 2);

        StringBuilder sb = new StringBuilder();
        for (int number : numbers) {
            sb.append(number);
        }
        if (sb.toString().charAt(0) == '0')
            return "0";
        return sb.toString();
    }

    public static int compare(int s1, int s2) {
        if (s1 == s2)
            return 0;

        int[] component1 = new int[4];
        int[] component2 = new int[4];

        int j = 0, k = 0;
        for (int i = s1; i > 0; i /= 10, j++)
            component1[j] = i % 10;
        for (int i = s2; i > 0; i /= 10, k++)
            component2[k] = i % 10;

        if (j == 0)
            j = 1;
        if (k == 0)
            k = 1;
        int s = j, t = k;
        int p = 20;
        while (p > 0) {
            if (j == 0) j = s;
            if (k == 0) k = t;
            if (component1[j - 1] < component2[k - 1])
                return -1;
            else if (component1[j - 1] > component2[k - 1])
                return 1;
            j--;
            k--;
            p--;
        }
        return 0;
    }

    private static long quickSort(int[] data, int p, int r, int c) {
        int q;
        if (num > 2000)
            return -1;

        num++;
        long start = System.currentTimeMillis();
        if (p < r) {
            q = partition(data, p, r, c);
            quickSort(data, p, q - 1, c);
            quickSort(data, q + 1, r, c);
        }
        long end = System.currentTimeMillis();
        if (num > 2000)
            return -1000;

        num--;
        return end - start;
    }

    private static int partition(int[] data, int p, int r, int c) {
        int i = p - 1, tmp;
        int pivot = choosePivot(data, p, r, c);
        tmp = data[pivot];
        data[pivot] = data[r];
        data[r] = tmp;

        for (int j = p; j < r; j++) {
            if (compare(data[j], data[r]) > 0) {
                i++;
                tmp = data[i];
                data[i] = data[j];
                data[j] = tmp;
            }
        }
        tmp = data[i + 1];
        data[i + 1] = data[r];
        data[r] = tmp;

        return i + 1;
    }

    private static int choosePivot(int[] data, int p, int r, int c) {
        if (c == 1) {
            return r;
        } else if (c == 2) {
            int q = (p + r) / 2;
            int min, max;
            if (data[p] >= data[q]) {
                max = p;
                min = q;
            } else {
                max = q;
                min = p;
            }
            if (data[r] >= data[max])
                return max;
            else if (data[r] >= data[min])
                return r;
            else
                return min;
        } else if (c == 3) {
            return (int) (Math.random() * (r - p)) + p;
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{0, 1000, 0, 0}));
    }
}
