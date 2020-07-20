/* 벽 부수고 이동하기
N×M의 행렬로 표현되는 맵이 있다. 맵에서 0은 이동할 수 있는 곳을 나타내고, 1은 이동할 수 없는 벽이 있는 곳을 나타낸다. 
당신은 (1, 1)에서 (N, M)의 위치까지 이동하려 하는데, 이때 최단 경로로 이동하려 한다. 
최단경로는 맵에서 가장 적은 개수의 칸을 지나는 경로를 말하는데, 이때 시작하는 칸과 끝나는 칸도 포함해서 센다.

만약에 이동하는 도중에 한 개의 벽을 부수고 이동하는 것이 좀 더 경로가 짧아진다면, 벽을 한 개 까지 부수고 이동하여도 된다.

맵이 주어졌을 때, 최단 경로를 구해 내는 프로그램을 작성하시오.

Key points : 
1. 벽을 안부수고 갈 경우 --> d[x][y][0]
2. 벽을 부수고 갈 경우 --> d[x][y][1]
*/
public class baek2206 {
    static int [] dx = {0, 0, 1, -1};
    static int [] dy = {1, -1, 0, 0};
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        int [][] a= new int[n][m];
        int [][][] d= new int[n][m][2];
        d[0][0][0] = 1;
        for (int i=0; i<n; i++) {
            String s = sc.nextLine();
            for (int j=0; j<m; j++) {
                a[i][j] = s.charAt(j) - '0';
            }
        }
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(0, 0, 0));
        while (!q.isEmpty()) {
            Pair p = q.remove();
            int x = p.x;
            int y = p.y;
            int z = p.z;
            for (int i = 0 ; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (a[nx][ny] == 0 && d[nx][ny][z] == 0) {
                    d[nx][ny][z] = d[x][y][z] + 1;
                    q.add(new Pair(nx, ny, z));
                }
                if (z == 0 && a[nx][ny] == 1 && d[nx][ny][z+1] == 0) {
                    d[nx][ny][z+1] = d[x][y][z] + 1;
                    q.add(new Pair(nx, ny, z+1));
                }
            }  
        }
        if (d[n-1][m-1][0] != 0 && d[n-1][m-1][1] != 0) {
            System.out.println(Math.min(d[n-1][m-1][0], d[n-1][m-1][1]));
        } else if (d[n-1][m-1][0] != 0) {
            System.out.println(d[n-1][m-1][0]);
        } else if (d[n-1][m-1][1] != 0 ) {
            System.out.println(d[n-1][m-1][1]);
        } else {
            System.out.println(-1);
        }
    }
}