/* 이모티콘
영선이는 매우 기쁘기 때문에, 효빈이에게 스마일 이모티콘을 S개 보내려고 한다.

영선이는 이미 화면에 이모티콘 1개를 입력했다. 이제, 다음과 같은 3가지 연산만 사용해서 이모티콘을 S개 만들어 보려고 한다.

s = 화면, c = 클립보드 

화면에 있는 이모티콘을 모두 복사해서 클립보드에 저장한다. --> d[s][s]
클립보드에 있는 모든 이모티콘을 화면에 붙여넣기 한다. --> d[s+c][c]
화면에 있는 이모티콘 중 하나를 삭제한다. --> d[s-1][c]
모든 연산은 1초가 걸린다. 또, 클립보드에 이모티콘을 복사하면 이전에 클립보드에 있던 내용은 덮어쓰기가 된다. 클립보드가 비어있는 상태에는 붙여넣기를 할 수 없으며, 일부만 클립보드에 복사할 수는 없다. 또한, 클립보드에 있는 이모티콘 중 일부를 삭제할 수 없다. 화면에 이모티콘을 붙여넣기 하면, 클립보드에 있는 이모티콘의 개수가 화면에 추가된다.

영선이가 S개의 이모티콘을 화면에 만드는데 걸리는 시간의 최솟값을 구하는 프로그램을 작성하시오.
*/
import java.util.*;
public class baek14226 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] d = new int[n+1][n+1];
        for (int i=0; i<=n; i++) {
            Arrays.fill(d[i], -1);
        }
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(1);
        q.add(0);
        d[1][0] = 0;
        while (!q.isEmpty()) {
            int s = q.remove();
            int c = q.remove();
            if (d[s][s] == -1) {
                d[s][s] = d[s][c] + 1;
                q.add(s); q.add(s);
            }
            if (s+c <= n && d[s+c][c] == -1) {
                d[s+c][c] = d[s][c] + 1;
                q.add(s+c); q.add(c);
            }
            if (s-1 >= 0 && d[s-1][c] == -1) {
                d[s-1][c] = d[s][c] + 1;
                q.add(s-1); q.add(c);
            }
        }
        int ans = -1;
        for (int i=0; i<=n; i++) {
            if (d[n][i] != -1) {
                if (ans == -1 || ans > d[n][i]) {
                    ans = d[n][i];
                }
            }
        }
        System.out.println(ans);
    }  
}