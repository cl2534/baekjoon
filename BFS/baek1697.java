/* 숨박꼭질

수빈이는 동생과 숨바꼭질을 하고 있다. 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다. 
수빈이는 걷거나 순간이동을 할 수 있다. 만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다. 
순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동하게 된다.

수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.
*/
import java.util.*;
public class baek1697 {
    static int Max = 1000000;
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        boolean [] check = new boolean[Max];
        int [] dist = new int[Max];
        dist[n] = 0;
        check[n] = true;
        while (!q.isEmpty()) {
            int nextN = q.poll();
            if (nextN - 1 >= 0) {
                if (check[nextN-1] == false) {
                    check[nextN-1] = true;
                    dist[nextN -1] = dist[nextN] + 1;
                    q.add(nextN - 1);
                }
            }
            
            if (nextN + 1 < Max) {
                if (check[nextN + 1] == false) {
                    check[nextN + 1] = true;
                    dist[nextN + 1] = dist[nextN] + 1;
                    q.add(nextN + 1);
                }
            }
            
            if (nextN * 2 < Max) {
                if (check[nextN * 2] == false) {
                    check[nextN * 2] = true;
                    dist[nextN * 2] = dist[nextN] + 1;
                    q.add(nextN * 2);
                }
            }
        }
        System.out.println(dist[m]);
    }
}