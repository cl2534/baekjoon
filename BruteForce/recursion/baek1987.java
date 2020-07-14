/* 알파벳 
세로 R칸, 가로 C칸으로 된 표 모양의 보드가 있다. 보드의 각 칸에는 대문자 알파벳이 하나씩 적혀 있고, 좌측 상단 칸 (1행 1열) 에는 말이 놓여 있다.

말은 상하좌우로 인접한 네 칸 중의 한 칸으로 이동할 수 있는데, 새로 이동한 칸에 적혀 있는 알파벳은 지금까지 지나온 모든 칸에 적혀 있는 알파벳과는 달라야 한다. 
즉, 같은 알파벳이 적힌 칸을 두 번 지날 수 없다.

좌측 상단에서 시작해서, 말이 최대한 몇 칸을 지날 수 있는지를 구하는 프로그램을 작성하시오. 말이 지나는 칸은 좌측 상단의 칸도 포함된다.
*/
import java.util.*;
public class baek1987 {
    public static final int [] dx = {0, 0, 1, -1};
    public static final int [] dy = {1, -1, 0, 0};
    public static int go(String [] board, boolean [] check, int x, int y) {
        int ans = 0;
        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (nx >= 0 && nx < board.length && ny >= 0 && ny < board[0].length()) {
                if (check[board[nx].charAt(ny) - 'A'] == false) {
                    check[board[nx].charAt(ny) - 'A'] = true;
                    int next = go(board, check, nx, ny);
                    if (ans < next) {
                        ans = next;
                    }
                    check[board[nx].charAt(ny) - 'A'] = false;
                }
            }
        }
        return ans + 1;
    }
    
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        String [] board = new String[n];
        for (int i= 0; i < n; i++) {
            board[i] = sc.nextLine();
        }
        boolean [] check = new boolean[26];
        check[board[0].charAt(0) - 'A'] = true;
        System.out.println(go(board,check,0,0));
    }
}