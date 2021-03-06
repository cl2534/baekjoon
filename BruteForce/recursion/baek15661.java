/*링크와 스타트 (팀 인원이 1이상이어야하고 둘의 팀이 같지 않아도 된다)
오늘은 스타트링크에 다니는 사람들이 모여서 축구를 해보려고 한다. 축구는 평일 오후에 하고 의무 참석도 아니다. 
축구를 하기 위해 모인 사람은 총 N명이다. 이제 스타트 팀과 링크 팀으로 사람들을 나눠야 한다. 두 팀의 인원수는 같지 않아도 되지만, 한 명 이상이어야 한다.

BOJ를 운영하는 회사 답게 사람에게 번호를 1부터 N까지로 배정했고, 아래와 같은 능력치를 조사했다. 
능력치 Sij는 i번 사람과 j번 사람이 같은 팀에 속했을 때, 팀에 더해지는 능력치이다. 팀의 능력치는 팀에 속한 모든 쌍의 능력치 Sij의 합이다. 
Sij는 Sji와 다를 수도 있으며, i번 사람과 j번 사람이 같은 팀에 속했을 때, 팀에 더해지는 능력치는 Sij와 Sji이다.

N=4이고, S가 아래와 같은 경우를 살펴보자.

예를 들어, 1, 2번이 스타트 팀, 3, 4번이 링크 팀에 속한 경우에 두 팀의 능력치는 아래와 같다.

스타트 팀: S12 + S21 = 1 + 4 = 5
링크 팀: S34 + S43 = 2 + 5 = 7
1, 3번이 스타트 팀, 2, 4번이 링크 팀에 속하면, 두 팀의 능력치는 아래와 같다.

스타트 팀: S13 + S31 = 2 + 7 = 9
링크 팀: S24 + S42 = 6 + 4 = 10
축구를 재미있게 하기 위해서 스타트 팀의 능력치와 링크 팀의 능력치의 차이를 최소로 하려고 한다. 
위의 예제와 같은 경우에는 1, 4번이 스타트 팀, 2, 3번 팀이 링크 팀에 속하면 스타트 팀의 능력치는 6, 링크 팀의 능력치는 6이 되어서 차이가 0이 되고 이 값이 최소이다.
*/
import java.util.*;
public class baek15661 {
    static int [][] s;
    static int n;
    static int recur(int index, ArrayList<Integer> first, ArrayList<Integer> second) {
        if (index == n) {
            if (first.size() == 0) return -1;
            if (second.size() == 0) return -1;
            int t1 = 0;
            int t2 = 0;
            for (int i = 0; i < first.size(); i++) {
                for(int j = 0; j < first.size(); j++) {
                    if (i == j) continue;
                    t1 += s[first.get(i)][first.get(j)];
                }
            }
            for (int i = 0; i < second.size(); i++) {
                for (int j = 0; j < second.size(); j++) {
                    if (i == j) continue;
                    t2 += s[second.get(i)][second.get(j)];
                    
                }
            }
            int diff = Math.abs(t1 - t2);
            return diff;
        }
        int ans = -1;
        first.add(index);
        int res1 = recur(index + 1, first, second);
        if (ans == -1 || res1 != -1 && ans > res1) {
            ans = res1;
        }
        first.remove(first.size() - 1);
        second.add(index);
        int res2 = recur(index + 1, first, second);
        if (ans == -1 || res2 != -1 && ans > res2) {
            ans = res2;
        }
        second.remove(second.size() -1);
        return ans;
    }
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        s = new int[n][n];
        for (int i= 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                s[i][j] = sc.nextInt();
            }
        }
        ArrayList<Integer> first = new ArrayList<Integer>();
        ArrayList<Integer> second = new ArrayList<Integer>();
        System.out.println(recur(0, first, second));
    }
}