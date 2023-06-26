package week12;
import java.util.*;
import java.io.*;
/**
 * packageName    : week12
 * fileName       : S5_15721_번데기
 * author         : jeonghwan
 * date           : 2023/05/30
 * time           : 12:09 PM
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023/05/30        jeonghwan       최초 생성
 */
public class 완전탐색_S5_15721_번데기 {

    static FastReader scan = new FastReader();
    static int A, T, X;

    static void input() {
        A = scan.nextInt();
        T = scan.nextInt();
        X = scan.nextInt();

    }

    static int solution() {
        int b = 0, d = 0, n = 2;

        while (true) {
            for (int i = 0; i < 4; i++) {
                if (i % 2 == 0) {
                    b++;
                }
                else{
                    d++;
                }
                if (b == T && X == 0) {
                    return (b + d - 1) % A;
                }
                if (d == T && X == 1) {
                    return (b + d - 1) % A;
                }
            }

            for (int i = 0; i < n; i++) {
                b++;
                if (b == T && X == 0) {
                    return (b + d - 1) % A;
                }
            }
            for (int i = 0; i < n; i++) {
                d++;
                if (d == T && X == 1) {
                    return (b + d - 1) % A;
                }
            }
            n++;
        }
    }

    public static void main(String[] args) {
        input();
        System.out.println(solution());

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
