/*
n가지 종류의 동전이 있다. 각각의 동전이 나타내는 가치는 다르다. 이 동전을 적당히 사용해서, 그 가치의 합이 k원이 되도록 하고 싶다. 그 경우의 수를 구하시오. 각각의 동전은 몇 개라도 사용할 수 있다.

사용한 동전의 구성이 같은데, 순서만 다른 것은 같은 경우이다.

dp[10] 와 1,2,5 동전이 있다면: dp[10] = dp[10 - coin[i]]

1) dp[9] + 1
2) dp[8] + 2
3) dp[5] + 5 
*/

import java.util.*;
public class baek2293 {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();
        int [] a = new int[n];
        int [] d = new int[target+1];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        d[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= target; j++) {
                if (j - a[i] >= 0) {
                    d[j] += d[j - a[i]];
                }
            }
        }
        System.out.println(d[target]);
    }
}