/* 
데스나이트

게임을 좋아하는 큐브러버는 체스에서 사용할 새로운 말 "데스 나이트"를 만들었다. 
데스 나이트가 있는 곳이 (r, c)라면, (r-2, c-1), (r-2, c+1), (r, c-2), (r, c+2), (r+2, c-1), (r+2, c+1)로 이동할 수 있다.

크기가 N×N인 체스판과 두 칸 (r1, c1), (r2, c2)가 주어진다. 
데스 나이트가 (r1, c1)에서 (r2, c2)로 이동하는 최소 이동 횟수를 구해보자. 체스판의 행과 열은 0번부터 시작한다.

데스 나이트는 체스판 밖으로 벗어날 수 없다.

*/
import java.util.*;
public class baek16948 {
    final static int[] dx = {-2,-2,0,0,2,2};
    final static int[] dy = {-1,1,-2,2,-1,1};
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sx = sc.nextInt();
        int sy = sc.nextInt();
        int ex = sc.nextInt();
        int ey = sc.nextInt();
        int[][] d = new int[n][n];
        for (int i=0; i<n; i++) {
            Arrays.fill(d[i], -1);
        }
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(sx); q.add(sy);
        d[sx][sy] = 0;
        while(!q.isEmpty()) {
            int x = q.remove();
            int y = q.remove();
            for (int i = 0; i < 6; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if (d[nx][ny] == -1) {
                    q.add(nx); q.add(ny);
                    d[nx][ny] = d[x][y] + 1;
                }
            }
        }
        System.out.println(d[ex][ey]);
    }
}