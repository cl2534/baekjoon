/*
지원이에게 2진 수열을 가르쳐 주기 위해, 지원이 아버지는 그에게 타일들을 선물해주셨다. 그리고 이 각각의 타일들은 0 또는 1이 쓰여 있는 낱장의 타일들이다.

어느 날 짓궂은 동주가 지원이의 공부를 방해하기 위해 0이 쓰여진 낱장의 타일들을 붙여서 한 쌍으로 이루어진 00 타일들을 만들었다. 
결국 현재 1 하나만으로 이루어진 타일 또는 0타일을 두 개 붙인 한 쌍의 00타일들만이 남게 되었다.

그러므로 지원이는 타일로 더 이상 크기가 N인 모든 2진 수열을 만들 수 없게 되었다. 
예를 들어, N=1일 때 1만 만들 수 있고, N=2일 때는 00, 11을 만들 수 있다. 
(01, 10은 만들 수 없게 되었다.) 또한 N=4일 때는 0011, 0000, 1001, 1100, 1111 등 총 5개의 2진 수열을 만들 수 있다.

우리의 목표는 N이 주어졌을 때 지원이가 만들 수 있는 모든 가짓수를 세는 것이다. 단 타일들은 무한히 많은 것으로 가정하자.

dp[1] = 1 (1 만 사용)
dp[2] = 2 (00, 11)
dp[3] = dp[1] + dp[2] -> dp[1] 에서 00을 더해 100, dp[2] (11, 00) 에서 1을 더해 111, 001
dp[i] = dp[i-2] + dp[i-1];     
*/
import java.io.*;
import java.util.*;
public class baek1904 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        long[] dp = new long[N + 1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= N; i ++){
            dp[i] = (dp[i - 2] + dp[i - 1]) % 15746;
        }
        bw.write(dp[N] + "\n");

        bw.flush();
        br.close();
        bw.close();
    }
}