/* 모양만들기
N×M인 배열에서 모양을 찾으려고 한다. 배열의 각 칸에는 0과 1 중의 하나가 들어있다. 두 칸이 서로 변을 공유할때, 두 칸을 인접하다고 한다.

1이 들어 있는 인접한 칸끼리 연결했을 때, 각각의 연결 요소를 모양이라고 부르자. 모양의 크기는 모양에 포함되어 있는 1의 개수이다.

배열의 칸 하나에 들어있는 수를 변경해서 만들 수 있는 모양의 최대 크기를 구해보자.

Key points:
1. 먼저 1로 구성된 그룹들에게 그룹 넘버를 지정한다 (bfs 이용). 그 그룹 넘버에 1의 총 갯수를 배열에 저장한다 (ex. group_size[groupNum] = 1 의 총 갯수)
2. For Loop 으로 0 을 찾고, 그 0 의 4 방향 중 한곳에 1이 있다면, 
0 을 1로 바꿨다고 가정하고 (cnt = 1), cnt += group_size[group_Num] (해당 그룹의 1 총갯수) 
3. 결과 = Math.max(cnt, 결과) 로 구한다. 

*/
import java.util.*;
public class baek16932 {
    static int n, m;
    static int[][] a;
    static int[][] group;
    static int[] group_size;
    static int groupn;
    final static int[] dx = {0,0,1,-1};
    final static int[] dy = {1,-1,0,0};
    static void bfs(int sx, int sy) {
        groupn += 1;
        Queue<Integer> q = new LinkedList<>();
        q.add(sx); q.add(sy);
        group[sx][sy] = groupn;
        int cnt = 1;
        while (!q.isEmpty()) {
            int x = q.remove();
            int y = q.remove();
            for (int k=0; k<4; k++) {
                int nx = x+dx[k];
                int ny = y+dy[k];
                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (group[nx][ny] == 0 && a[nx][ny] == 1) {
                        group[nx][ny] = groupn;
                        q.add(nx); q.add(ny);
                        cnt += 1;
                    }
                }
            }
        }
        group_size[groupn] = cnt;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = new int[n][m];
        group = new int[n][m];
        group_size = new int[n*m];
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (a[i][j] == 1 && group[i][j] == 0) {
                    bfs(i, j);
                }
            }
        }
        int ans = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (a[i][j] == 0) {
                    HashSet<Integer> near = new HashSet<>();
                    for (int k=0; k<4; k++) {
                        int nx = i+dx[k];
                        int ny = j+dy[k];
                        if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                            if (a[nx][ny] == 1) {
                                near.add(group[nx][ny]);
                            }
                        }
                    }
                    int sum = 1;
                    for (int neighbor : near) {
                        sum += group_size[neighbor];
                    }
                    if (ans < sum) ans = sum;
                }
            }
        }
        System.out.println(ans);
    }
}