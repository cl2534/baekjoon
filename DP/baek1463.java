
/*정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.

X가 3으로 나누어 떨어지면, 3으로 나눈다.
X가 2로 나누어 떨어지면, 2로 나눈다.
1을 뺀다.
정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다. 연산을 사용하는 횟수의 최솟값을 출력하시오. */
import java.util.*;
public class baek1463 {
    static int [] d;
    static int bottom(int n) {
        d[1] = 0;
        for (int i = 2 ; i <= n ; i++) {
            d[i] = d[i-1] + 1;
            if (i % 2 == 0 && d[i] > d[i/2] + 1) {
                d[i] = d[i/2] + 1;
            }
            if (i % 3 == 0 && d[i] > d[i/3] + 1) {
                d[i] = d[i/3] + 1;
            }
        }
        return d[n];
    }

    static int top(int n) {
        if (n == 1) return 0;
        if (d[n] > 0) return d[n];
        d[n] = top(n-1) + 1;
        if (n % 2 == 0) {
            int tmp = top(n/2) + 1;
            if (tmp < d[n]) {
                d[n] = tmp;
            }
        }
        if (n % 3 == 0) {
            int tmp = top(n/3) + 1;
            if (tmp < d[n]) {
                d[n] = tmp;
            }
        }
        return d[n];
    }
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int n  = sc.nextInt();
        d = new int[n+1];
        System.out.println(bottom[n]);
    }
}
