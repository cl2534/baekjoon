public class camouflage {
    import java.util.*;
    import java.io.*;

    class Solution {
        public int solution(String[][] clothes) {  
            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < clothes.length; i++) {
                if (map.get(clothes[i][1]) == null) {
                    map.put(clothes[i][1], 1);
                } else {
                    map.put(clothes[i][1], map.get(clothes[i][1]) + 1);
                }
            }
            int answer = 1;
            Set<String> keys = map.keySet();
            for (String key : keys) {
                answer *= (map.get(key) + 1);
            }
            answer-= 1;
            return answer;
        }
    }
}