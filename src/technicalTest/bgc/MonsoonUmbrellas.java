package technicalTest.bgc;

import java.util.HashMap;
import java.util.Map;

/**
 * bnp technical test
 */

public class MonsoonUmbrellas {
    private static int solution(int num, Integer[] sizes) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int s : sizes) {
            m.put(s, 1);
        }

        for (int i = 1; i <= num; i++) {
            int min = Integer.MAX_VALUE;
            boolean found = false;
            if (m.get(i) == null) {
                for (int s : sizes) {
                    if (m.get(i - s) != null && m.get(i - s) < min) {
                        min = m.get(i - s);
                        found = true;
                    }
                }
                if (found)
                    m.put(i, min + 1);
            }
        }

        return m.get(num) == null ? -1 : m.get(num);
    }

    public static void main(String[] args) {
        System.out.println(MonsoonUmbrellas.solution(3, new Integer[]{1, 2}) == 2);
        System.out.println(MonsoonUmbrellas.solution(10, new Integer[]{3, 1}) == 4);
        System.out.println(MonsoonUmbrellas.solution(3, new Integer[]{2}) == -1);
        System.out.println(MonsoonUmbrellas.solution(10, new Integer[]{1, 2, 4, 6}) == 2);
        System.out.println(MonsoonUmbrellas.solution(11, new Integer[]{1, 2, 4, 6}) == 3);
    }
}
