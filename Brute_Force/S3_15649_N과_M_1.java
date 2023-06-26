package Brute_Force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * packageName    : Brute_Force
 * fileName       : S3_15651_N과_M_3
 * author         : jeonghwan
 * date           : 2023/05/29
 * time           : 10:32 PM
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023/05/29        jeonghwan       최초 생성
 */
public class S3_15651_N과_M_3 {
    static StringBuilder sb = new StringBuilder();
    static FastReader scan = new FastReader();

    static int N, M;
    static int[] selected;
    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        selected = new int[M + 1];
    }

    // Recurrence Function (재귀 함수)
    // 만약 M 개를 전부 고름 => 조건에 맞는 탐색을 한 가지 성공한것
    // 아직 M 개를 고르지 않음 => k 번째부터 M 번째 원솔르 조건에 맞게 고르는 모든 방법을 시도한다.

    static void rec_func(int k) {
        if (k == M + 1) { // 다 고른 경우
            // selected[1...M] 배열이 새롭게 탐색된 결과
            for (int i = 1; i <= M; i++) {
                sb.append(selected[i]).append(' ');
            }
            sb.append('\n');

        } else{
            for (int cand = 1; cand <= N; cand++) {
                selected[k] = cand;
                // k + 1 번 ~ M 번을 모두 탐색하는 일을 해야 하는 상황
                rec_func(k + 1);
                selected[k] = 0;
            }
        }
    }
    public static void main(String[] args) {
        input();

        // 1 번째 원소부터 M 번째 원소를 조건에 맞는 모든 방법을 찾기
        rec_func(1);
        System.out.println(sb);

    }

    static class FastReader{
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
