import java.util.*;
public class utilityDevelopment {


class Solution {
    
  public int daysLeft(int a, int b) {
    int num = a;
    int cnt = 0;
    for (int i = 1; ; i++) {
      num += b;
      if (num >= 100) {
        cnt = i;
        break;
      }
    }
    return cnt;
  }
  
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> res = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            q.add(daysLeft(progresses[i], speeds[i]));
        }
        int prev = q.poll();
        int cnt = 1;
        while (!q.isEmpty()) {
            int cur = q.poll();
            if (prev >= cur) {
                cnt++;
            } else {
                res.add(cnt);
                cnt = 1;
                prev = cur;
            }
        }
        res.add(cnt);
        int [] ans = new int[res.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }
}
}