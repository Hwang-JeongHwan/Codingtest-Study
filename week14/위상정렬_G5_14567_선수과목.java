package week14;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/14567
/**
 * packageName    : week14
 * fileName       : 위상정렬_G5_2252_줄_세우기
 * author         : jeonghwan
 * date           : 2023/06/18
 * time           : 8:31 PM
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023/06/18        jeonghwan       최초 생성
 */
public class 위상정렬_G5_2252_줄_세우기 {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] result, inDegree;

    static ArrayList<Integer> list[];

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        result = new int[N + 1];
        inDegree = new int[N + 1];
        list = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 1; i <= M; i++) {
            int start = scan.nextInt();
            int end = scan.nextInt();
            list[start].add(end);
            inDegree[end]++;

        }
    }

    static void solution() {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
                queue.offer(1);
            }
        }
        while (!queue.isEmpty()) {
            int x = queue.poll();
            int count = queue.poll();
            result[x] = count;
            for (int y : list[x]) {
                inDegree[y]--;
                if (inDegree[y] == 0) {
                    queue.offer(y);
                    queue.offer(count + 1);
                }
            }
        }
        for (int i = 1; i <= N; i++) {
            sb.append(result[i] + " ");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        input();
        solution();
    }
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
