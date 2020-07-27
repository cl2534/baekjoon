/* 말이 되고픈 원숭이 
근데 원숭이는 한 가지 착각하고 있는 것이 있다. 말은 저렇게 움직일 수 있지만 원숭이는 능력이 부족해서 총 K번만 위와 같이 움직일 수 있고, 
그 외에는 그냥 인접한 칸으로만 움직일 수 있다. 대각선 방향은 인접한 칸에 포함되지 않는다.

이제 원숭이는 머나먼 여행길을 떠난다. 격자판의 맨 왼쪽 위에서 시작해서 맨 오른쪽 아래까지 가야한다. 
인접한 네 방향으로 한 번 움직이는 것, 말의 움직임으로 한 번 움직이는 것, 모두 한 번의 동작으로 친다. 
격자판이 주어졌을 때, 원숭이가 최소한의 동작으로 시작지점에서 도착지점까지 갈 수 있는 방법을 알아내는 프로그램을 작성하시오.

Key points: 
1. 3차원 배열 : d[n][m][l] -> l (말로 이동한 횟수) 

*/

import java.util.*;
public class baek1600 {
    static final int[] dx = {0,0,1,-1,-2,-1,1,2,2,1,-1,-2};
    static final int[] dy = {1,-1,0,0,1,2,2,1,-1,-2,-2,-1};
    static final int[] cost = {0,0,0,0,1,1,1,1,1,1,1,1};
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int m = sc.nextInt();
        int n = sc.nextInt();
        int [][] a = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        int [][][] d = new int[n][m][l+1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Arrays.fill(d[i][j], -1);
            }
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(0); q.add(0); q.add(0);
        d[0][0][0] = 0;
        while (!q.isEmpty()) {
            int x = q.remove();
            int y = q.remove();
            int z = q.remove();
            for (int k = 0; k < 12; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                int nz = z + cost[k];
                if (0 <= nx && nx < n && ny >= 0 && ny < m) {
                    if (a[nx][ny] == 1) continue;
                    if (nz <= l) {
                        if (d[nx][ny][nz] == -1) {
                            d[nx][ny][nz] = d[x][y][z] + 1;
                            q.add(nx); q.add(ny); q.add(nz);
                        }
                    }
                }
            }
        }
        int res = -1;
        for (int i = 0; i <= l ; i++) {
            if (d[n-1][m-1][i] == -1) continue;
            if (res == -1 || res > d[n-1][m-1][i]) {
                res = d[n-1][m-1][i];
            }
        }
        System.out.println(res);
        
    }
}