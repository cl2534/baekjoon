import java.util.*;
public class printer {

class Solution {
    public int solution(int[] priorities, int location) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for (int i : priorities) {
            q.add(i);
        }
        int ans = 0;
        while (!q.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                if (q.peek() == priorities[i]) {
                    q.remove();
                    ans++;
                    if (location == i) {
                        q.clear();
                        break;
                    }
                }
            }
        }
        return ans;
    }
}
}