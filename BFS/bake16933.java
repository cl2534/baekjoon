/* 벽 부수고 이동하기 3
N×M의 행렬로 표현되는 맵이 있다. 맵에서 0은 이동할 수 있는 곳을 나타내고, 1은 이동할 수 없는 벽이 있는 곳을 나타낸다. 
당신은 (1, 1)에서 (N, M)의 위치까지 이동하려 하는데, 이때 최단 경로로 이동하려 한다. 
최단경로는 맵에서 가장 적은 개수의 칸을 지나는 경로를 말하는데, 이때 시작하는 칸과 끝나는 칸도 포함해서 센다. 
이동하지 않고 같은 칸에 머물러있는 경우도 가능하다. 이 경우도 방문한 칸의 개수가 하나 늘어나는 것으로 생각해야 한다.

이번 문제에서는 낮과 밤이 번갈아가면서 등장한다. 가장 처음에 이동할 때는 낮이고, 한 번 이동할 때마다 낮과 밤이 바뀌게 된다. 
이동하지 않고 같은 칸에 머무르는 경우에도 낮과 밤이 바뀌게 된다.

만약에 이동하는 도중에 벽을 부수고 이동하는 것이 좀 더 경로가 짧아진다면, 벽을 K개 까지 부수고 이동하여도 된다. 단, 벽은 낮에만 부술 수 있다.

맵이 주어졌을 때, 최단 경로를 구해 내는 프로그램을 작성하시오.

*/
import java.util.*;
class Pair {
    int x, y, z, night;
    Pair(int x, int y, int z, int night) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.night = night;
    }
}
public class bake16933 {
    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int l = sc.nextInt();
        sc.nextLine();
        int[][] a = new int[n][m];
        int[][][][] d = new int[n][m][l+1][2];
        for (int i=0; i<n; i++) {
            String s = sc.nextLine();
            for (int j=0; j<m; j++) {
                a[i][j] = s.charAt(j) - '0';
            }
        }
        d[0][0][0][0] = 1;
        Queue<Pair> q = new LinkedList<Pair>();
        q.offer(new Pair(0, 0, 0, 0));
        while (!q.isEmpty()) {
            Pair p = q.remove();
            int x = p.x;
            int y = p.y;
            int z = p.z;
            int night = p.night;
            for (int k=0; k<4; k++) {
                int nx = x+dx[k];
                int ny = y+dy[k];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (a[nx][ny] == 0 && d[nx][ny][z][1-night] == 0) {
                    d[nx][ny][z][1-night] = d[x][y][z][night] + 1;
                    q.offer(new Pair(nx, ny, z, 1-night));
                }
                if (night == 0 && z+1 <= l && a[nx][ny] == 1 && d[nx][ny][z+1][1-night] == 0) {
                    d[nx][ny][z+1][1-night] = d[x][y][z][night] + 1;
                    q.offer(new Pair(nx, ny, z+1, 1-night));
                }
            }
            if (d[x][y][z][1-night] == 0) {
                d[x][y][z][1-night] = d[x][y][z][night] + 1;
                q.offer(new Pair(x, y, z, 1-night));
            }
        }
        int ans = -1;
        for (int j=0; j<2; j++) {
            for (int i=0; i<=l; i++) {
                if (d[n-1][m-1][i][j] == 0) continue;
                if (ans == -1) {
                    ans = d[n-1][m-1][i][j];
                } else if (ans > d[n-1][m-1][i][j]) {
                    ans = d[n-1][m-1][i][j];
                }
            }
        }
        System.out.println(ans);
    }
}