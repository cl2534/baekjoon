/*두 동전 

N×M 크기의 보드와 4개의 버튼으로 이루어진 게임이 있다. 
보드는 1×1크기의 정사각형 칸으로 나누어져 있고, 각각의 칸은 비어있거나, 벽이다. 두 개의 빈 칸에는 동전이 하나씩 놓여져 있고, 두 동전의 위치는 다르다.

버튼은 "왼쪽", "오른쪽", "위", "아래"와 같이 4가지가 있다. 버튼을 누르면 두 동전이 버튼에 쓰여 있는 방향으로 동시에 이동하게 된다.

동전이 이동하려는 칸이 벽이면, 동전은 이동하지 않는다.
동전이 이동하려는 방향에 칸이 없으면 동전은 보드 바깥으로 떨어진다.
그 외의 경우에는 이동하려는 방향으로 한 칸 이동한다.이동하려는 칸에 동전이 있는 경우에도 한 칸 이동한다.
두 동전 중 하나만 보드에서 떨어뜨리기 위해 버튼을 최소 몇 번 눌러야하는지 구하는 프로그램을 작성하시오.

go(step,x1,y1,x2,y2) 
1. step:버튼을 누른 횟수 
- (x1,y1):한 동전의 위치 
- (x2,y2):다른 동전의 위치 
2. 불가능한 경우: 
- step==11 
- 동전이 둘 다 떨어진 경우 
3. 정답을 찾은 경우 
- 동전 하나만 떨어진 경우 
4. 다음 경우 
- go(step+1,nx1,ny1,nx2,ny2) 
*/
import java.util.*;
public class baek16197 {
    static int n, m;
    static char [][] a;
    static int [] dx = {0, 0, 1, -1};
    static int [] dy = {1, -1, 0, 0};
    static int recur(int x1, int y1, int x2, int y2, int step) {
        if (step == 11) return -1;
        boolean fall1 = false;
        boolean fall2 = false;
        if (x1 < 0 || x1 >= n || y1 < 0 || y1 >= m) fall1 = true;
        if (x2 < 0 || x2 >= n || y2 < 0 || y2 >= m) fall2 = true;
        if (fall1 && fall2) return -1;
        if (fall1 || fall2) return step;
        int res = -1;
        for (int i = 0; i < 4; i++) {
            int nx1 = x1 + dx[i];
            int ny1 = y1 + dy[i];
            int nx2 = x2 + dx[i];
            int ny2 = y2 + dy[i];
            if (0 <= nx1 && nx1 < n && 0 <= ny1 && ny1 < m && a[nx1][ny1] == '#') {
                nx1 = x1;
                ny1 = y1;
            }
            if (0 <= nx2 && nx2 < n && 0 <= ny2 && ny2 < m && a[nx2][ny2] == '#') {
                nx2 = x2;
                ny2 = y2;
            }
            int tmp = recur(nx1, ny1, nx2, ny2, step + 1);
            if (tmp == -1) continue;
            if (res == -1 || res > tmp) {
                res = tmp;
            }
        }
        return res;
    }
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = new char[n][m];
        int x1,y1,x2,y2;
        x1=y1=x2=y2=-1;
        for (int i=0; i<n; i++) {
            a[i] = sc.next().toCharArray();
            for (int j = 0; j < m; j++) {
                if (a[i][j] == 'o') {
                    if (x1 == -1) {
                        x1 = i;
                        y1 = j;
                    } else {
                        x2 = i;
                        y2 = j;
                    }
                a[i][j] = '.';
                }
            }
        }
        System.out.println(recur(x1, y1, x2, y2, 0));
    }
}