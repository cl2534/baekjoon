/*
1, 2, 3 더하기 5
정수 4를 1, 2, 3의 합으로 나타내는 방법은 총 3가지가 있다. 합을 나타낼 때는 수를 1개 이상 사용해야 한다. 단, 같은 수를 두 번 이상 연속해서 사용하면 안 된다.

1+2+1
1+3
3+1
정수 n이 주어졌을 때, n을 1, 2, 3의 합으로 나타내는 방법의 수를 구하는 프로그램을 작성하시오.
*/

public class baek15990 {
    static int limit = 100000;
    static long mod = 1000000009L;
    static long[][] d = new long[limit+1][4];
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 1; i <= limit; i++) {
            if (i-1 >= 0) {
                d[i][1] = d[i-1][2] + d[i-1][3];
                if (i == 1) {
                    d[i][1] = 1;
                }
            }

            if (i-2 >= 0) {
                d[i][2] = d[i-1][1] + d[i-1][3];
                if (i == 2) {
                    d[i][2] = 1;
                }
            }

            if (i - 3 >= 0) {
                d[i][3] = d[i-1][2] + d[i-1][1];
                if (i == 3) {
                    d[i][3] = 1;
                }
            }
            d[i][1] %= mod;
            d[i][2] %= mod;
            d[i][3] %= mod;
        }

        for (int i =0 ;i < n; i++) {
            int num = sc.nextInt();
            System.out.println(d[num][1] + d[num][2] + d[num][3] % mod);
        }
    }
}