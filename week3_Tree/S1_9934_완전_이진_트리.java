package week3_Tree;
import java.nio.file.NoSuchFileException;
import java.util.*;
import java.io.*;
public class S1_9934_완전_이진_트리 {
    // 이분탐색 처럼 start, end, mid를 이용해서 풀면됨
    static ArrayList<Integer> []result;
    static int tree[];
    static int k;
    public static void main(String[] args) throws IOException, NoSuchElementException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        k = Integer.parseInt(st.nextToken());
        result = new ArrayList[k + 1];
        for(int i = 0; i < k + 1; i ++){
            result[i] = new ArrayList<>();
        }
        tree = new int[(int)Math.pow(2, k) - 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < tree.length; i ++){
            tree[i] = Integer.parseInt(st.nextToken());
//            System.out.println(tree[i]);
        }
        solution(0, tree.length - 1, 1);
        for(int i = 1; i < k + 1; i ++){
            for(int j : result[i]){
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
    public static void solution(int start, int end, int depth){
        if(depth == k + 1){
            return;
        }
        int mid = (start + end )/ 2;
        result[depth].add(tree[mid]);

        solution(start, mid - 1, depth + 1);
        solution(mid + 1, end, depth + 1);

    }
}
