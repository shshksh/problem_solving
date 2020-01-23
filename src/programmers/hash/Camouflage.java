package programmers.hash;

import java.util.HashMap;

public class Camouflage {
    public static int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String[] clothe : clothes) {
            map.put(clothe[1], map.getOrDefault(clothe[1], 1) + 1);
        }
        int sum = 1;
        for (Integer value : map.values()) {
            sum*=value;
        }
        return sum-1;
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[][] {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}}));
    }
}
