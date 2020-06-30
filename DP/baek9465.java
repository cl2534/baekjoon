/* 스티커
상근이의 여동생 상냥이는 문방구에서 스티커 2n개를 구매했다. 스티커는 그림 (a)와 같이 2행 n열로 배치되어 있다. 상냥이는 스티커를 이용해 책상을 꾸미려고 한다.

상냥이가 구매한 스티커의 품질은 매우 좋지 않다. 스티커 한 장을 떼면, 그 스티커와 변을 공유하는 스티커는 모두 찢어져서 사용할 수 없게 된다.
즉, 뗀 스티커의 왼쪽, 오른쪽, 위, 아래에 있는 스티커는 사용할 수 없게 된다.



모든 스티커를 붙일 수 없게된 상냥이는 각 스티커에 점수를 매기고, 점수의 합이 최대가 되게 스티커를 떼어내려고 한다. 
먼저, 그림 (b)와 같이 각 스티커에 점수를 매겼다. 상냥이가 뗄 수 있는 스티커의 점수의 최댓값을 구하는 프로그램을 작성하시오. 
즉, 2n개의 스티커 중에서 점수의 합이 최대가 되면서 서로 변을 공유 하지 않는 스티커 집합을 구해야 한다.

위의 그림의 경우에 점수가 50, 50, 100, 60인 스티커를 고르면, 점수는 260이 되고 이 것이 최대 점수이다. 
가장 높은 점수를 가지는 두 스티커 (100과 70)은 변을 공유하기 때문에, 동시에 뗄 수 없다.

1. d[i][0] = 아무것도 뗴지 않았을 때, Math.max(d[i-1][0], d[i-1][1], d[i-1][2]);
2. d[i][1] = 첫번쨰 (1번 i) j 을 떼었을 떄, Math.max(d[i-1][0], d[i-1][2]) + a[i][0];
3. d[i][2] = 두번쨰 (2번 i) j 을 떼었을 때, Math.max(d[i-1][0], d[i-1][1]) + a[i][1];
d[i][j]= d[i-1][j-1] + a[i][j]
d[i][j] = 
*/
import java.util.*;
import java.io.*;

public class baek9465 {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.valueOf(br.readLine());
        while (t --> 0) {
            int n = Integer.valueOf(br.readLine());
            long [][] a = new long[n+1][2];
            {
            String [] line = br.readLine().split(" ");
            for (int i = 1; i <= n ; i++) {
                a[i][0] = Long.valueOf(line[i-1]);
            }
            }
            {
            String [] line = br.readLine().split(" ");
            for (int i = 1; i <= n; i++) {
                a[i][1] = Long.valueOf(line[i-1]);
            }
            }
            long [][] d= new long[n+1][3];
             for (int i=1; i<=n; i++) {
                d[i][0] = Math.max(d[i-1][0],Math.max(d[i-1][1],d[i-1][2]));
                d[i][1] = Math.max(d[i-1][0],d[i-1][2])+a[i][0];
                d[i][2] = Math.max(d[i-1][0],d[i-1][1])+a[i][1];
            }
            long ans = 0;
            ans = Math.max(d[n][0], Math.max(d[n][1], d[n][2]));
            System.out.println(ans);
        }
    }
}