/* 뱀과 사다리 게임 
게임은 정육면체 주사위를 사용하며, 주사위의 각 면에는 1부터 6까지 수가 하나씩 적혀있다. 
게임은 크기가 10×10이고, 총 100개의 칸으로 나누어져 있는 보드판에서 진행된다. 보드판에는 1부터 100까지 수가 하나씩 순서대로 적혀져 있다.

플레이어는 주사위를 굴려 나온 수만큼 이동해야 한다. 예를 들어, 플레이어가 i번 칸에 있고, 주사위를 굴려 나온 수가 4라면, i+4번 칸으로 이동해야 한다. 
만약 주사위를 굴린 결과가 100번 칸을 넘어간다면 이동할 수 없다. 도착한 칸이 사다리면, 사다리를 타고 위로 올라간다. 
뱀이 있는 칸에 도착하면, 뱀을 따라서 내려가게 된다. 
즉, 사다리를 이용해 이동한 칸의 번호는 원래 있던 칸의 번호보다 크고, 뱀을 이용해 이동한 칸의 번호는 원래 있던 칸의 번호보다 작아진다.

게임의 목표는 1번 칸에서 시작해서 100번 칸에 도착하는 것이다.

게임판의 상태가 주어졌을 때, 100번 칸에 도착하기 위해 주사위를 굴려야 하는 횟수의 최솟값을 구해보자.

KEY POINTS: 

1. 10 x 10 보드판이라고 해도, 1~100 까지 가는 방향은 한가지 뿐 (오른쪽으로 주사위 나온만큼 -->): 그러므로 1차 배열을 써도 무관하다. d[100]
2. y = next[y] 로 나둬서, 다음 가는 숫자가 뱀이나 사다리일 경우, 그 숫자로 바로 이동하게 한다. 
ex)
for (int i = 1; i <= 100; i++) {
    next[i] = i;
}
for (int i = 0; i < n + m; i++) {
    next[a] = b;
}

*/
import java.util.*;
public class baek16928 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] dist = new int[101];
        int[] next = new int[101];
        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i=1; i<=100; i++) {
            next[i] = i;
            dist[i] = -1;
        }
        for (int k=0; k<n+m; k++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            next[x] = y;
        }
        dist[1] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        while (!q.isEmpty()) {
            int x = q.remove();
            for (int i=1; i<=6; i++) {
                int y = x+i;
                if (y > 100) continue;
                y = next[y];            //중요
                if (dist[y] == -1) {
                    dist[y] = dist[x] + 1;
                    q.add(y);
                }
            }
        }
        System.out.println(dist[100]);
    }
}