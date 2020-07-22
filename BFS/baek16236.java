/* 아기 상어
N×N 크기의 공간에 물고기 M마리와 아기 상어 1마리가 있다. 공간은 1×1 크기의 정사각형 칸으로 나누어져 있다. 한 칸에는 물고기가 최대 1마리 존재한다.

아기 상어와 물고기는 모두 크기를 가지고 있고, 이 크기는 자연수이다. 가장 처음에 아기 상어의 크기는 2이고, 아기 상어는 1초에 상하좌우로 인접한 한 칸씩 이동한다.

아기 상어는 자신의 크기보다 큰 물고기가 있는 칸은 지나갈 수 없고, 나머지 칸은 모두 지나갈 수 있다. 
아기 상어는 자신의 크기보다 작은 물고기만 먹을 수 있다. 따라서, 크기가 같은 물고기는 먹을 수 없지만, 그 물고기가 있는 칸은 지나갈 수 있다.

아기 상어가 어디로 이동할지 결정하는 방법은 아래와 같다.

더 이상 먹을 수 있는 물고기가 공간에 없다면 아기 상어는 엄마 상어에게 도움을 요청한다.
먹을 수 있는 물고기가 1마리라면, 그 물고기를 먹으러 간다.
먹을 수 있는 물고기가 1마리보다 많다면, 거리가 가장 가까운 물고기를 먹으러 간다.
거리는 아기 상어가 있는 칸에서 물고기가 있는 칸으로 이동할 때, 지나야하는 칸의 개수의 최솟값이다.
거리가 가까운 물고기가 많다면, 가장 위에 있는 물고기, 그러한 물고기가 여러마리라면, 가장 왼쪽에 있는 물고기를 먹는다.
아기 상어의 이동은 1초 걸리고, 물고기를 먹는데 걸리는 시간은 없다고 가정한다. 
즉, 아기 상어가 먹을 수 있는 물고기가 있는 칸으로 이동했다면, 이동과 동시에 물고기를 먹는다. 물고기를 먹으면, 그 칸은 빈 칸이 된다.

아기 상어는 자신의 크기와 같은 수의 물고기를 먹을 때 마다 크기가 1 증가한다. 예를 들어, 크기가 2인 아기 상어는 물고기를 2마리 먹으면 크기가 3이 된다.

공간의 상태가 주어졌을 때, 아기 상어가 몇 초 동안 엄마 상어에게 도움을 요청하지 않고 물고기를 잡아먹을 수 있는지 구하는 프로그램을 작성하시오.
*/
import java.util.*;
class Pair {
    int dist, x, y;
    Pair(int dist, int x, int y) {
        this.dist = dist;
        this.x = x;
        this.y = y;
    }
}
public class baek16236 {
    static final int[] dx = {0,0,1,-1};
    static final int[] dy = {1,-1,0,0};
    static Pair bfs(int[][] a, int sx, int sy, int size) {
        int n = a.length;
        ArrayList<Pair> ans = new ArrayList<>();
        int[][] d = new int[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                d[i][j] = -1;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(sx); q.add(sy);
        d[sx][sy] = 0;
        while (!q.isEmpty()) {
            int x = q.remove();
            int y = q.remove();
            for (int k=0; k<4; k++) {
                int nx = x+dx[k];
                int ny = y+dy[k];
                if (0 <= nx && nx < n && 0 <= ny && ny < n && d[nx][ny] == -1) {
                    boolean ok = false;
                    boolean eat = false;
                    // 아기 상어는 자신의 크기보다 큰 물고기가 있는 칸은 지나갈 수 없고, 나머지 칸은 모두 지나갈 수 있다.
                    if (a[nx][ny] == 0) {
                        ok = true;
                    } else if (a[nx][ny] < size) { // 아기 상어는 자신의 크기보다 작은 물고기만 먹을 수 있다.
                        ok = eat = true;
                    } else if (a[nx][ny] == size) { // 크기가 같은 물고기는 먹을 수 없지만, 그 물고기가 있는 칸은 지나갈 수 있다.
                        ok = true;
                    }
                    if (ok) {
                        q.add(nx); q.add(ny);
                        d[nx][ny] = d[x][y] + 1;
                        if (eat) {
                            ans.add(new Pair(d[nx][ny], nx, ny));
                        }
                    }
                }
            }
        }
        if (ans.isEmpty()) {
            return null;
        }
        Pair best = ans.get(0);
        for (Pair p : ans) {
            if (best.dist > p.dist) {
                best = p;
            } else if (best.dist == p.dist && best.x > p.x) {
                best = p;
            } else if (best.dist == p.dist && best.x == p.x && best.y > p.y) {
                best = p;
            }
        }
        return best;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a = new int[n][n];
        int x = 0, y = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                a[i][j] = sc.nextInt();
                if (a[i][j] == 9) {
                    x = i; y = j;
                    a[i][j] = 0;
                }
            }
        }
        int ans = 0;
        int size = 2;
        int exp = 0;
        while (true) {
            Pair p = bfs(a, x, y, size);
            if (p == null) break;
            a[p.x][p.y] = 0;
            ans += p.dist;
            exp += 1;
            if (size == exp) {
                size += 1;
                exp = 0;
            }
            x = p.x;
            y = p.y;
        }
        System.out.println(ans);
        sc.close();
    }
}