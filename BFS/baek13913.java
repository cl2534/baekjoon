/* 숨바꼭질 4
수빈이는 동생과 숨바꼭질을 하고 있다. 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다. 
수빈이는 걷거나 순간이동을 할 수 있다. 만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다. 
순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동하게 된다.

수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.
*/
import java.util.*;
public class baek13913 {
    public static final int MAX = 1000000;
    static void print(int[] from, int n, int m) {
        if (n != m) {
            print(from, n, from[m]);
        }
        System.out.print(m + " ");
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        boolean[] check = new boolean[MAX];
        int[] dist = new int[MAX];
        int[] from = new int[MAX];
        check[n] = true;
        dist[n] = 0;
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(n);
        while (!q.isEmpty()) {
            int now = q.remove();
            if (now-1 >= 0) {
                if (check[now-1] == false) {
                    q.add(now-1);
                    check[now-1] = true;
                    dist[now-1] = dist[now] + 1;
                    from[now-1] = now;
                }
            }
            if (now+1 < MAX) {
                if (check[now+1] == false) {
                    q.add(now+1);
                    check[now+1] = true;
                    dist[now+1] = dist[now] + 1;
                    from[now+1] = now;
                }
            }
            if (now*2 < MAX) {
                if (check[now*2] == false) {
                    q.add(now*2);
                    check[now*2] = true;
                    dist[now*2] = dist[now] + 1;
                    from[now*2] = now;
                }
            }
        }
        System.out.println(dist[m]);
        print(from, n, m);
        /* print with stack
        Stack<Integer> ans = new Stack<>();
        for (int i=m; i!=n; i=from[i]) {
            ans.push(i);
        }
        ans.push(n);
        while (!ans.isEmpty()) {
            System.out.print(ans.pop() + " ");
        }
        */
        System.out.println();
    }
}