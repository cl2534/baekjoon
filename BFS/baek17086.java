/* 아기 상어 2
N×M 크기의 공간에 아기 상어 여러 마리가 있다. 공간은 1×1 크기의 정사각형 칸으로 나누어져 있다. 한 칸에는 아기 상어가 최대 1마리 존재한다.

어떤 칸의 안전 거리는 그 칸과 가장 거리가 가까운 아기 상어와의 거리이다. 
두 칸의 거리는 하나의 칸에서 다른 칸으로 가기 위해서 지나야 하는 칸의 수이고, 이동은 인접한 8방향(대각선 포함)이 가능하다.

안전 거리가 가장 큰 칸을 구해보자. 

Key points: 

1. 각각의 칸에서 시작해, 다음 가까운 아기상어 (숫자 1) 까지의 거리를 구할 수 있다. 
*/
import java.util.*;
public class baek17086 {
    static int [][] a ;
    static int [][] d;
    static int n, m;
    final static int[] dx = {0,0,1,-1,1,1,-1,-1};
    final static int[] dy = {1,-1,0,0,1,-1,1,-1};
    static int go(int sx, int sy) {
        for (int i = 0 ;i < n; i++) {
            for (int j = 0 ;j < m; j++) {
                d[i][j] = -1;
            }
        }
        d[sx][sy] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(sx); q.add(sy);
        while (!q.isEmpty()) {
            int x = q.remove();
            int y = q.remove();
            for (int k = 0; k < 8; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (0 <= nx && nx < n && ny >= 0 && ny < m) {
                    if (d[nx][ny] == -1) {
                        if (a[nx][ny] == 1) return d[x][y] + 1;
                        else {
                            q.add(nx); q.add(ny);
                            d[nx][ny] = d[x][y] + 1;
                        }
                    }
                }
            }
        }
        return 0;
    }
    
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = new int[n][m];
        d = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == 0) {
                    int dist = go(i, j);
                    if (res < dist) res = dist;
                }
            }
        }
        System.out.println(res);
    }
}