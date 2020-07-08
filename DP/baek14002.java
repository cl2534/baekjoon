/*
가장 긴 증가하는 부분 수열 4
수열 A가 주어졌을 때, 가장 긴 증가하는 부분 수열을 구하는 프로그램을 작성하시오.

예를 들어, 수열 A = {10, 20, 10, 30, 20, 50} 인 경우에 가장 긴 증가하는 부분 수열은 A = {10, 20, 10, 30, 20, 50} 이고, 길이는 4이다.


*/

import java.util.*;
public class baek14002 {
    static int[] a;
    static int[] d;
    static int[] v;
    static void go(int p) {
        if (p == -1) return;
        go(v[p]);
        System.out.print(a[p] + " ");
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        a = new int[n];
        for (int i=0; i<n; i++) {
            a[i] = sc.nextInt();
        }
        d = new int[n];
        v = new int[n];
        for (int i=0; i<n; i++) {
            d[i] = 1;
            v[i] = -1;
            for (int j=0; j<i; j++) {
                if (a[j] < a[i] && d[i] < d[j]+1) {
                    d[i] = d[j]+1;
                    v[i] = j;
                }
            }
        }
        int ans = d[0];
        int p = 0;
        for (int i=0; i<n; i++) {
            if (ans < d[i]) {
                ans = d[i];
                p = i;
            }
        }
        System.out.println(ans);
        go(p);
        System.out.println();
    }
}