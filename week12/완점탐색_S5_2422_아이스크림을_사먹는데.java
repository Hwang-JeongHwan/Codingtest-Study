package week12;
import java.util.*;
import java.io.*;
/**
 * packageName    : week12
 * fileName       : 완점탐색_S5_2422_아이스크림을_사먹는데
 * author         : jeonghwan
 * date           : 2023/05/30
 * time           : 12:25 PM
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023/05/30        jeonghwan       최초 생성
 */
public class 완점탐색_S5_2422_아이스크림을_사먹는데 {
    static FastReader scan = new FastReader();

    static int N, M, count;
    static boolean[][] arr;
    static int[] iceCream = new int[3];
    static boolean[] visited;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        arr = new boolean[N + 1][N + 1];
        visited = new boolean[N + 1];
        int x, y;
        for (int i = 1; i <= M; i++) {
            x = scan.nextInt();
            y = scan.nextInt();

            arr[x][y] = true;
            arr[y][x] = true;
        }

    }
    static void rec_func(int depth, int index) {
        if (depth == 3) {
            if (check()) {
                count++;
            }
            return;
        }
        else{
            for (int i = index; i < N + 1; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    iceCream[depth] = i;
                    rec_func(depth + 1, i + 1);
                    visited[i] = false;

                }
            }
        }
    }

    static int bruteForce() {
        int count = 0;

        for (int i = 1; i < N + 1; i++) {
            for (int j = i + 1; j < N + 1; j++) {
                for (int k = j + 1; k < N + 1; k++) {
                    if (arr[i][j] || arr[i][k] || arr[j][k])
                        continue;
                    count++;
                }
            }
        }
        return count;
    }
    static boolean check() {
        for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j < 3; j++) {
                if (arr[iceCream[i]][iceCream[j]]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        input();
        rec_func(0, 1);
        System.out.println(count);
    }
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }

}
