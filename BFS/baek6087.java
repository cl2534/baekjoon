/* 레이저 통신
크기가 1×1인 정사각형으로 나누어진 W×H 크기의 지도가 있다. 지도의 각 칸은 빈 칸이거나 벽이며, 두 칸은 'C'로 표시되어 있는 칸이다.

'C'로 표시되어 있는 두 칸을 레이저로 통신하기 위해서 설치해야 하는 거울 개수의 최솟값을 구하는 프로그램을 작성하시오. 
레이저로 통신한다는 것은 두 칸을 레이저로 연결할 수 있음을 의미한다.

레이저는 C에서만 발사할 수 있고, 빈 칸에 거울('/', '\')을 설치해서 방향을 90도 회전시킬 수 있다. 

아래 그림은 H = 8, W = 7인 경우이고, 빈 칸은 '.', 벽은 '*'로 나타냈다. 왼쪽은 초기 상태, 오른쪽은 최소 개수의 거울을 사용해서 두 'C'를 연결한 것이다.

Key points: 
1. 꺾는 갯수를 알 수 있다. (카카오 시험)
*/
import java.util.*;

class Pair {
    int x, y;
    Pair(int x, int y) {
        this.x = x;
        this.y =y;
    }
}
public class baek6087 {
    static int [] dx = {0, 0, 1, -1};
    static int [] dy = {1, -1, 0, 0};
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        String [] a = new String[n];
        int sx,sy,ex,ey;
        sx = sy = ex = ey = -1;
        for (int i = 0; i < n; i++) {
            a[i] = sc.next();
            for (int j = 0; j < m; j++) {
                if (a[i].charAt(j) == 'C') {
                    if (sx == -1) {
                        sx = i;
                        sy = j;
                    } else {
                        ex = i;
                        ey = j;
                    }
                }
            }
        }
        int [][] d = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                d[i][j] = -1;
            }
        }
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(sx, sy));
        d[sx][sy] = 0;
        while (!q.isEmpty()) {
            Pair p = q.remove();
            int x = p.x;
            int y = p.y;
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                while (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (a[nx].charAt(ny) == '*') break;
                    if (d[nx][ny] == -1) {
                        d[nx][ny] = d[x][y] + 1;
                        q.add(new Pair(nx, ny));
                    }
                    nx += dx[k];
                    ny += dy[k];
                    
                }
            }
        }
        System.out.println(d[ex][ey] - 1);
    }
}