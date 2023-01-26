package book_study;
import java.io.*;
import java.util.*;
public class S1_1991_트리_순회하기 {
    static int [][] tree;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        tree = new int[26][2]; // 1 <= n <= 26, left, right
        for(int i = 0; i < n; i ++){
            st = new StringTokenizer(br.readLine());
            int node = st.nextToken().charAt(0) - 'A';
//            System.out.println(node);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
//            System.out.println("node : " + (char)(node +'A') +" left : " + left + " right : " + right );
            if(left == '.'){
                tree[node][0] = -1;
            }
            else{
                tree[node][0] = left - 'A';
            }
            if(right == '.'){
                tree[node][1] = -1;

            }
            else{
                tree[node][1] = right - 'A';
            }



        }
//        System.out.println(Arrays.toString(tree));
        // 전위 순회한 결과
        preOrder(0);
        System.out.println();

        // 중위 순회한 결과
        inOrder(0);
        System.out.println();

        // 후위 순회한 결과
        postOrder(0);
        System.out.println();

    }
    public static void preOrder(int now) {
        if (now == -1)
            return;
        System.out.print((char) (now + 'A')); // 1.현재 정점
        preOrder(tree[now][0]); // 2.왼쪽 탐색
        preOrder(tree[now][1]); // 3.오른쪽 탐색
    }
    public static void inOrder(int now) {
        if (now == -1)
            return;
        inOrder(tree[now][0]); // 1.왼쪽 탐색
        System.out.print((char) (now + 'A')); // 2.현재 정점
        inOrder(tree[now][1]); // 3.오른쪽 탐색
    }
    public static void postOrder(int now) {
        if (now == -1)
            return;
        postOrder(tree[now][0]); // 1.왼쪽 탐색
        postOrder(tree[now][1]); // 2.오른쪽 탐색
        System.out.print((char) (now + 'A')); // 2.현재 정점
    }
}