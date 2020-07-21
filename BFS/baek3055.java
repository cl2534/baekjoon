/* 탈출
티떱숲의 지도는 R행 C열로 이루어져 있다. 비어있는 곳은 '.'로 표시되어 있고, 물이 차있는 지역은 '*', 돌은 'X'로 표시되어 있다. 
비버의 굴은 'D'로, 고슴도치의 위치는 'S'로 나타내어져 있다.

매 분마다 고슴도치는 현재 있는 칸과 인접한 네 칸 중 하나로 이동할 수 있다. (위, 아래, 오른쪽, 왼쪽) 물도 매 분마다 비어있는 칸으로 확장한다. 
물이 있는 칸과 인접해있는 비어있는 칸(적어도 한 변을 공유)은 물이 차게 된다. 물과 고슴도치는 돌을 통과할 수 없다. 
또, 고슴도치는 물로 차있는 구역으로 이동할 수 없고, 물도 비버의 소굴로 이동할 수 없다.

티떱숲의 지도가 주어졌을 때, 고슴도치가 안전하게 비버의 굴로 이동하기 위해 필요한 최소 시간을 구하는 프로그램을 작성하시오.

고슴도치는 물이 찰 예정인 칸으로 이동할 수 없다. 즉, 다음 시간에 물이 찰 예정인 칸으로 고슴도치는 이동할 수 없다. 
이동할 수 있으면 고슴도치가 물에 빠지기 때문이다.

Key points: 
1. water[nx][ny] = water[x][y] + 1 --> 물부터 채우고 난 뒤,
2. d[nx][ny] = d[x][y] + 1 (if water[nx][ny] == -1 && d[x][y] + 1 < water[nx][ny]) 
*/  
import java.util.*;
class Pair {
    int x, y;
    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class baek3055 {
    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        String[] a = new String[n];
        int[][] water = new int[n][m];
        int[][] d = new int[n][m];
        for (int i=0; i<n; i++) {
            a[i] = sc.nextLine();
            for (int j=0; j<m; j++) {
                water[i][j] = -1;
                d[i][j] = -1;
            }
        }
        Queue<Pair> q = new LinkedList<Pair>();
        int sx=0,sy=0,ex=0,ey=0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (a[i].charAt(j) == '*') {
                    q.offer(new Pair(i, j));
                    water[i][j] = 0;
                } else if (a[i].charAt(j) == 'S') {
                    sx = i;
                    sy = j;
                } else if (a[i].charAt(j) == 'D') {
                    ex = i;
                    ey = j;
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
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }
                if (water[nx][ny] != -1) continue;
                if (a[nx].charAt(ny) == 'X') continue;
                if (a[nx].charAt(ny) == 'D') continue;
                water[nx][ny] = water[x][y] + 1;
                q.offer(new Pair(nx, ny));
            }
        }
        q.offer(new Pair(sx, sy));
        d[sx][sy] = 0;
        while (!q.isEmpty()) {
            Pair p = q.remove();
            int x = p.x;
            int y = p.y;
            for (int k=0; k<4; k++) {
                int nx = x+dx[k];
                int ny = y+dy[k];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }
                if (d[nx][ny] != -1) continue;
                if (a[nx].charAt(ny) == 'X') continue;
                if (water[nx][ny] != -1 && d[x][y]+1 >= water[nx][ny]) continue;

                d[nx][ny] = d[x][y] + 1;
                q.offer(new Pair(nx, ny));
            }
        }
        if (d[ex][ey] == -1) {
            System.out.println("KAKTUS");
        } else {
            System.out.println(d[ex][ey]);
        }
    }
}