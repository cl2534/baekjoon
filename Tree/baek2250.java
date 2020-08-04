/*
이진트리에서 같은 레벨(level)에 있는 노드는 같은 행에 위치한다.
한 열에는 한 노드만 존재한다.
임의의 노드의 왼쪽 부트리(left subtree)에 있는 노드들은 
해당 노드보다 왼쪽의 열에 위치하고, 오른쪽 부트리(right subtree)에 있는 노드들은 해당 노드보다 오른쪽의 열에 위치한다.
노드가 배치된 가장 왼쪽 열과 오른쪽 열 사이엔 아무 노드도 없이 비어있는 열은 없다.
*/

import java.util.*;
class Node {
    int left, right;
    public int order, depth;
    Node(int left, int right) {
        this.left = left;
        this.right = right;
    }
}
public class baek2250 {
    static Node[] a = new Node[10001];
    static int[] left = new int[10001];
    static int[] right = new int[10001];
    static int[] cnt = new int[10001];
    static int order = 0;
    static void inorder(int node, int depth) {
        if (node == -1) return;
        inorder(a[node].left, depth+1);
        a[node].order = ++order;
        a[node].depth = depth;
        inorder(a[node].right, depth+1);
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i=0; i<n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
            a[x] = new Node(y, z);
            if (y != -1) cnt[y] += 1;
            if (z != -1) cnt[z] += 1;
        }
        int root = 0;
        for (int i=1; i<=n; i++) {
            if (cnt[i] == 0) {
                root = i;
            }
        }
        inorder(root, 1);
        int maxdepth = 0;
        for (int i=1; i<=n; i++) {
            int depth = a[i].depth;
            int order = a[i].order;
            if (left[depth] == 0) {
                left[depth] = order;
            } else {
                left[depth] = Math.min(left[depth], order);
            }
            right[depth] = Math.max(right[depth], order);
            maxdepth = Math.max(maxdepth, depth);
        }
        int ans = 0;
        int ans_level = 0;
        for (int i=1; i<=maxdepth; i++) {
            if (ans < right[i]-left[i]+1) {
                ans = right[i]-left[i]+1;
                ans_level = i;
            }
        }
        System.out.println(ans_level + " " + ans);
    }
}