package Level1;

import java.util.stream.LongStream;

public class TwoSum {
    public long solution(int a, int b) {
        if (a == b)
            return a;
        else if (a < b)
            return LongStream.rangeClosed(a, b).sum();
        return LongStream.rangeClosed(b, a).sum();
    }
}
