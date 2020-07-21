/* 움직이는 미로 탈출 
욱제는 학교 숙제로 크기가 8×8인 체스판에서 탈출하는 게임을 만들었다. 체스판의 모든 칸은 빈 칸 또는 벽 중 하나이다. 
욱제의 캐릭터는 가장 왼쪽 아랫 칸에 있고, 이 캐릭터는 가장 오른쪽 윗 칸으로 이동해야 한다.

이 게임의 특징은 벽이 움직인다는 점이다. 1초마다 모든 벽이 아래에 있는 행으로 한 칸씩 내려가고, 가장 아래에 있어서 아래에 행이 없다면 벽이 사라지게 된다. 
욱제의 캐릭터는 1초에 인접한 한 칸 또는 대각선 방향으로 인접한 한 칸으로 이동하거나, 현재 위치에 서 있을 수 있다. 이동할 때는 빈 칸으로만 이동할 수 있다.

1초 동안 욱제의 캐릭터가 먼저 이동하고, 그 다음 벽이 이동한다. 벽이 캐릭터가 있는 칸으로 이동하면 더 이상 캐릭터는 이동할 수 없다.

욱제의 캐릭터가 가장 오른쪽 윗 칸으로 이동할 수 있는지 없는지 구해보자.
*/
import java.util.*;
public class baek16954 {
    final static int[] dx = {0,0,1,-1,1,-1,1,-1,0};
    final static int[] dy = {1,-1,0,0,1,1,-1,-1,0};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 8;
        String[] a = new String[n];
        for (int i=0; i<n; i++) {
            a[i] = sc.next();
        }
        Queue<Integer> q = new LinkedList<>();
        boolean[][][] check = new boolean[8][8][9];
        check[7][0][0] = true;
        q.add(7); q.add(0); q.add(0);
        boolean ans = false;
        while (!q.isEmpty()) {
            int x = q.remove();
            int y = q.remove();
            int t = q.remove();
            if (x == 0 && y == 7) ans = true;
            for (int k=0; k<9; k++) {
                int nx = x+dx[k];
                int ny = y+dy[k];
                int nt = Math.min(t+1, 8);
                if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                    if (nx-t >= 0 && a[nx-t].charAt(ny) == '#') continue;
                    if (nx-t-1 >= 0 && a[nx-t-1].charAt(ny) == '#') continue;
                    if (check[nx][ny][nt] == false) {
                        check[nx][ny][nt] = true;
                        q.add(nx); q.add(ny); q.add(nt);
                    }
                }
            }
        }
        System.out.println(ans ? 1 : 0);
    }
}