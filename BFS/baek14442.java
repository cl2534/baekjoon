/* 벽 부수고 이동하기 2
N×M의 행렬로 표현되는 맵이 있다. 맵에서 0은 이동할 수 있는 곳을 나타내고, 1은 이동할 수 없는 벽이 있는 곳을 나타낸다. 
당신은 (1, 1)에서 (N, M)의 위치까지 이동하려 하는데, 이때 최단 경로로 이동하려 한다. 
최단경로는 맵에서 가장 적은 개수의 칸을 지나는 경로를 말하는데, 이때 시작하는 칸과 끝나는 칸도 포함해서 센다.

만약에 이동하는 도중에 벽을 부수고 이동하는 것이 좀 더 경로가 짧아진다면, 벽을 K개 까지 부수고 이동하여도 된다.

맵이 주어졌을 때, 최단 경로를 구해 내는 프로그램을 작성하시오.
*/
import java.util.*;
class Pair {
    int x, y, z;
    Pair(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
public class baek14442 {
    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int l = sc.nextInt();
        sc.nextLine();
        int[][] a = new int[n][m];
        int[][][] d = new int[n][m][l+1];
        for (int i=0; i<n; i++) {
            String s = sc.nextLine();
            for (int j=0; j<m; j++) {
                a[i][j] = s.charAt(j) - '0';
            }
        }
        d[0][0][0] = 1;
        Queue<Pair> q = new LinkedList<Pair>();
        q.offer(new Pair(0, 0, 0));
        while (!q.isEmpty()) {
            Pair p = q.remove();
            int x = p.x;
            int y = p.y;
            int z = p.z;
            for (int k=0; k<4; k++) {
                int nx = x+dx[k];
                int ny = y+dy[k];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (a[nx][ny] == 0 && d[nx][ny][z] == 0) {
                    d[nx][ny][z] = d[x][y][z] + 1;
                    q.offer(new Pair(nx, ny, z));
                }
                if (z+1 <= l && a[nx][ny] == 1 && d[nx][ny][z+1] == 0) {
                    d[nx][ny][z+1] = d[x][y][z] + 1;
                    q.offer(new Pair(nx, ny, z+1));
                }
            }
        }
        int ans = -1;
        for (int i=0; i<=l; i++) {
            if (d[n-1][m-1][i] == 0) continue;
            if (ans == -1) {
                ans = d[n-1][m-1][i];
            } else if (ans > d[n-1][m-1][i]) {
                ans = d[n-1][m-1][i];
            }
        }
        System.out.println(ans);
    }
}