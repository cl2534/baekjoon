/*
n개의 정수로 이루어진 임의의 수열이 주어진다. 우리는 이 중 연속된 몇 개의 수를 선택해서 구할 수 있는 합 중 가장 큰 합을 구하려고 한다. 단, 수는 한 개 이상 선택해야 한다.

예를 들어서 10, -4, 3, 1, 5, 6, -35, 12, 21, -1 이라는 수열이 주어졌다고 하자. 여기서 정답은 12+21인 33이 정답이 된다.

d[n] = a[i] 로 시작하고, d[n] 와 d[n-1] + a[i] 비교 

*/


import java.util.*;
public class baek1912 {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] d = new int[n];
        int [] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            d[i] = a[i];
            if (i == 0) continue;
            if (d[i-1] + a[i] > a[i]) {
                d[i] = d[i-1] + a[i];
            }
        }
        int res = d[0];
        for (int i = 0; i < n; i++) {
            res = Math.max(res, d[i]);
        }
        System.out.println(res);
    }
}