/* 연구소
인체에 치명적인 바이러스를 연구하던 연구소에서 바이러스가 유출되었다. 다행히 바이러스는 아직 퍼지지 않았고, 바이러스의 확산을 막기 위해서 연구소에 벽을 세우려고 한다.

연구소는 크기가 N×M인 직사각형으로 나타낼 수 있으며, 직사각형은 1×1 크기의 정사각형으로 나누어져 있다. 
연구소는 빈 칸, 벽으로 이루어져 있으며, 벽은 칸 하나를 가득 차지한다. 

일부 칸은 바이러스가 존재하며, 이 바이러스는 상하좌우로 인접한 빈 칸으로 모두 퍼져나갈 수 있다. 새로 세울 수 있는 벽의 개수는 3개이며, 꼭 3개를 세워야 한다.

예를 들어, 아래와 같이 연구소가 생긴 경우를 살펴보자.

벽을 3개 세운 뒤, 바이러스가 퍼질 수 없는 곳을 안전 영역이라고 한다. 위의 지도에서 안전 영역의 크기는 27이다.

연구소의 지도가 주어졌을 때 얻을 수 있는 안전 영역 크기의 최댓값을 구하는 프로그램을 작성하시오.
*/
import java.util.*;

class Pair {
    int x;
    int y;
    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class baek14502 {
    static int n, m;
    static int[][] a = new int[10][10];
    static int[][] b = new int[10][10];
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int bfs() {
        Queue<Pair> q = new LinkedList<Pair>();
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                b[i][j] = a[i][j];
                if (b[i][j] == 2) {
                    q.add(new Pair(i, j));
                }
            }
        }
        while (!q.isEmpty()) {
            Pair p = q.remove();
            int x = p.x;
            int y = p.y;
            for (int k=0; k<4; k++) {
                int nx = x+dx[k];
                int ny = y+dy[k];
                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (b[nx][ny] == 0) {
                        b[nx][ny] = 2;
                        q.add(new Pair(nx, ny));
                    }
                }
            }
        }
        int cnt = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (b[i][j] == 0) {
                    cnt += 1;
                }
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = new int[n][m];
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        int ans = 0;
        for (int x1=0; x1<n; x1++) {
            for (int y1=0; y1<m; y1++) {
                if (a[x1][y1] != 0) continue;
                for (int x2=0; x2<n; x2++) {
                    for (int y2=0; y2<m; y2++) {
                        if (a[x2][y2] != 0) continue;
                        for (int x3=0; x3<n; x3++) {
                            for (int y3=0; y3<m; y3++) {
                                if (a[x3][y3] != 0) continue;
                                if (x1 == x2 && y1 == y2) continue;
                                if (x1 == x3 && y1 == y3) continue;
                                if (x2 == x3 && y2 == y3) continue;
                                a[x1][y1] = 1;
                                a[x2][y2] = 1;
                                a[x3][y3] = 1;
                                int cur = bfs();
                                if (ans < cur) ans = cur;
                                a[x1][y1] = 0;
                                a[x2][y2] = 0;
                                a[x3][y3] = 0;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(ans);
    }
}