/*
가르침 
남극에 사는 김지민 선생님은 학생들이 되도록이면 많은 단어를 읽을 수 있도록 하려고 한다. 
그러나 지구온난화로 인해 얼음이 녹아서 곧 학교가 무너지기 때문에, 김지민은 K개의 글자를 가르칠 시간 밖에 없다. 
김지민이 가르치고 난 후에는, 학생들은 그 K개의 글자로만 이루어진 단어만을 읽을 수 있다. 
김지민은 어떤 K개의 글자를 가르쳐야 학생들이 읽을 수 있는 단어의 개수가 최대가 되는지 고민에 빠졌다.

남극언어의 모든 단어는 "anta"로 시작되고, "tica"로 끝난다. 남극언어에 단어는 N개 밖에 없다고 가정한다. 
학생들이 읽을 수 있는 단어의 최댓값을 구하는 프로그램을 작성하시오.


*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class baek1062 {
    static int N, K;
    static boolean [] visit;
    static String [] words;
    static int max = 0;
    
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        words = new String[N];
        if (K < 5) System.out.println(0);
        else if (K == 26) System.out.println(N);
        else {
            for (int i = 0; i < N; i++) {
                String word = br.readLine();
                words[i] = word.substring(4, word.length() - 4);
            }
            K-=5;
            visit['a' - 97] = true;
            visit['n' - 97] = true;
            visit['t' - 97] = true;
            visit['i' - 97] = true;
            visit['c' - 97] = true;
            dfs(0, 0);
            System.out.println(max);
        }
    }
    static void dfs(int start, int count) {
        if (count == K) {
            int canRead = 0;
            for (int i = 0; i < N; i++) {
                boolean isTrue = true;
                for (int j = 0; j < words[i].length(); j++) {
                    if (!visit[words[i].charAt(j) - 97]) {
                        isTrue = false;
                        break;
                    }

                }
                if (isTrue) {
                    canRead++;
                }
                
            }
            max = Math.max(canRead, max);
            return;
        }
        for (int i = start; i < 26; i++) {
            if (!visit[i]) {
                visit[i] = true;
                dfs(i, count + 1);
                visit[i] = false;
            }
        }
    }
}