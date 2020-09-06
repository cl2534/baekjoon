import java.util.*;
public class moreHotter {

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : scoville) {
            pq.offer(num);
        }


        int answer = -1;
        int s1 = 0, s2 = 0;
        int temp = 0, times = 0;
        while (pq.size() > 1) {
            if (pq.peek() >= K) {
                break;
            }
            s1 = pq.poll();
            s2 = pq.poll();
            temp = s1 + (s2 * 2);
            pq.offer(temp);
            times++;
        }
        if (pq.poll() >= K) {
            answer = times;
        }
        return answer;
    }
}
}