/* 숨바꼭질 3
수빈이는 동생과 숨바꼭질을 하고 있다. 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다. 
수빈이는 걷거나 순간이동을 할 수 있다. 만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다. 
순간이동을 하는 경우에는 0초 후에 2*X의 위치로 이동하게 된다.

수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.

Key points: 두가지 case 가 존재 

1. x * 2 => 0 초              FIRST QUEUE
2. x + 1, x - 1 => 1초        SECOND QUEUE


*/
import java.util.*;
public class baek13549 {
    public static final int MAX = 1000000;
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        boolean[] c = new boolean[MAX];
        int[] d = new int[MAX];
        c[n] = true;
        d[n] = 0;
        Queue<Integer> q = new LinkedList<Integer>();
        Queue<Integer> next_queue = new LinkedList<Integer>();
        q.add(n);
        while (!q.isEmpty()) {
            int now = q.remove();
            for (int next : new int[]{now*2, now-1, now+1}) {
                if (next >= 0 && next < MAX) {
                    if (c[next] == false) {
                        c[next] = true;
                        if (now*2 == next) {
                            q.add(next);
                            d[next] = d[now];
                        } else {
                            next_queue.add(next);
                            d[next] = d[now] + 1;
                        }                    
                    }
                }  
            }
            if (q.isEmpty()) {
                q = next_queue;
                next_queue = new LinkedList<Integer>();
            }
        }
        System.out.println(d[m]);
    }
}