/* 연속합 2
n개의 정수로 이루어진 임의의 수열이 주어진다. 우리는 이 중 연속된 몇 개의 수를 선택해서 구할 수 있는 합 중 가장 큰 합을 구하려고 한다. 
단, 수는 한 개 이상 선택해야 한다. 또, 수열에서 수를 하나 제거할 수 있다. (제거하지 않아도 된다)

예를 들어서 10, -4, 3, 1, 5, 6, -35, 12, 21, -1 이라는 수열이 주어졌다고 하자. 
여기서 수를 제거하지 않았을 때의 정답은 12+21인 33이 정답이 된다.

만약, -35를 제거한다면, 수열은 10, -4, 3, 1, 5, 6, 12, 21, -1이 되고, 
여기서 정답은 10-4+3+1+5+6+12+21인 54가 된다.

*/
import java.util.*;

public class baek13398 {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] d = new int[n];
        int [] dr = new int[n];
        int [] a = new int[n];
        for (int i =0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            d[i] = a[i];
            if (i > 0 && d[i] < d[i-1] + a[i]) {
                d[i] = d[i-1] + a[i];
            }
        }

        for (int i = n-1; i >= 0; i--) {
            dr[i] = a[i];
            if (i < n-1 && dr[i] < dr[i+1] + a[i]) {
                dr[i] = dr[i+1] + a[i];
            }
        }
        int res = d[0];
        for (int i = 0; i < n; i++) {
            res = Math.max(res, d[i]);
        }

        for (int i = 1; i < n-1; i++) {
            res = Math.max(res, d[i-1] + dr[i+1]);
        }
        System.out.println(res);
    }
}