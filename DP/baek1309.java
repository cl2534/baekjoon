/* 동물원
이 동물원에는 사자들이 살고 있는데 사자들을 우리에 가둘 때, 가로로도 세로로도 붙어 있게 배치할 수는 없다. 
이 동물원 조련사는 사자들의 배치 문제 때문에 골머리를 앓고 있다.

동물원 조련사의 머리가 아프지 않도록 우리가 2*N 배열에 사자를 배치하는 경우의 수가 몇 가지인지를 알아내는 프로그램을 작성해 주도록 하자. 
사자를 한 마리도 배치하지 않는 경우도 하나의 경우의 수로 친다고 가정한다.
d[i][0] = d[i-1][0] + d[i-1][1] + d[i-1][2];
d[i][1] = d[i-1][0] + d[i-1][2];
d[i][2] = d[i-1][0] + d[i-1][1]
*/

import java.util.*;
public class baek1309 {
    public static void main(String [] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int [][] d = new int[n+1][3];
    d[0][0] = 0;
    for (int i = 1; i <= n; i++) {
        d[i][0] = d[i-1][0] + d[i-1][1] + d[i-1][2];
        d[i][1] = d[i-1][0] + d[i-1][2];
        d[i][2] = d[i-1][0] + d[i-1][1];
        for (int j = 0; j < 3; j++) {
            d[i][j] %= 9901;
        }
    }
    System.out.println((d[n][0] + d[n][1] + d[n][2]) % 9901);
}
}