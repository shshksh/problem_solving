package algorithm.programmers.bruteForce;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class findPrime {
    static int count = 0;
    static HashSet<String> set = new HashSet<>();

    public static int solution(String numbers) {
        List<String> pieces = new ArrayList<>();
        Collections.addAll(pieces, numbers.split(""));

        for (String piece : pieces) {
            if (!piece.equals("0")) {
                List<String> list = new ArrayList<>(pieces);
                list.remove(piece);
                countPrime(piece, list);
            }
        }

        return set.size();
    }

    private static void countPrime(String header, List<String> pieces) {
        if(isPrime(header)) {
            set.add(header);
            System.out.println(header);
        }
        for (String piece : pieces) {
            List<String> list = new ArrayList<>(pieces);
            list.remove(piece);

            countPrime(header+piece, list);
        }
    }

    private static boolean isPrime(String header) {
        int number = Integer.parseInt(header);
        int scope = (int)Math.sqrt(number);
        if(number> 1)
            for (int i = 2; i <= scope; i++) {
                if (number % i == 0)
                    return false;
            }
        else
            return false;

        return true;
    }

    public static void main(String[] args) {
        System.out.println(solution("011"));
    }
}
