/*
정수 4를 1, 2, 3의 합으로 나타내는 방법은 총 7가지가 있다. 합을 나타낼 때는 수를 1개 이상 사용해야 한다.

1+1+1+1
1+1+2
1+2+1
2+1+1
2+2
1+3
3+1
정수 n이 주어졌을 때, n을 1, 2, 3의 합으로 나타내는 방법의 수를 구하는 프로그램을 작성하시오. */
import java.util.*;
public class baek9095 {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] d= new int[11];
        d[0] = 1;
        for (int i = 1; i <= 10; i++) {
            if (i - 1 >= 0) {
                d[i] += d[i-1];
            }
            if (i - 2 >= 0) {
                d[i] += d[i-2];
            }
            if (i - 3 >= 0) {
                d[i] += d[i-3];
            }
        }
        for (int i = 0 ; i< n; i++) {
            System.out.println(d[sc.nextInt()]);
        }
    }
}