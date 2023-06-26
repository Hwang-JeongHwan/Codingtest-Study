package week12;
import java.io.*;
import java.util.*;
/**
 * packageName    : week12
 * fileName       : 시뮬레이션_G5_21610_마법사_상어와_비바라기
 * author         : jeonghwan
 * date           : 2023/05/30
 * time           : 11:29 AM
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023/05/31        jeonghwan       최초 생성
 */
public class 시뮬레이션_G5_21610_마법사_상어와_비바라기 {
    public static class Cloud {
        int x;
        int y;

        public Cloud(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int n, m;
    static int[][] map;
    static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    static boolean[][] visited;
    static Queue<Cloud> clouds = new LinkedList<>();

    static FastReader scan = new FastReader();

    private static void input() {
        n = scan.nextInt();
        m = scan.nextInt();

        map = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = scan.nextInt();
            }
        }
        clouds.add(new Cloud(n - 1, 0));
        clouds.add(new Cloud(n - 1, 1));
        clouds.add(new Cloud(n - 2, 0));
        clouds.add(new Cloud(n - 2, 1));
        while (m-- > 0) {
            int d = scan.nextInt() - 1;
            int s = scan.nextInt();
            step12(d, s);
            step34();
            step5();
        }


        
    }

    private static void solution() {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum += map[i][j];
            }
        }
        System.out.println(sum);
    }
    private static void step12(int d, int s) {
        // 구름 이동, 구름 칸 물의 양 1 증가
        for (Cloud cloud : clouds) {
            cloud.x = (n + cloud.x + dx[d] * (s % n)) % n;
            cloud.y = (n + cloud.y + dy[d] * (s % n)) % n;
            map[cloud.x][cloud.y]++;
        }



    }

    private static void step34() {
        // 구름제거, 물복사 버그마법 시전 (대각선에 물바구니 있으면 그만큼 증가)
        while (!clouds.isEmpty()) {
            Cloud cloud = clouds.poll();
            int cnt = 0;

            visited[cloud.x][cloud.y] = true;
            for (int i = 1; i <= 7; i += 2) {
                int nx = cloud.x + dx[i];
                int ny = cloud.y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if (map[nx][ny] >= 1)
                        cnt++;
                }

            }
            map[cloud.x][cloud.y] += cnt;

        }

    }

    private static void step5() {
        // 물의양 2이상인 모든칸 구름 생기고 물양 2줄어들기 (단, 3에서 구름이 사라진 칸 무시)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && map[i][j] >= 2) {
                    map[i][j] -= 2;
                    clouds.add(new Cloud(i, j));
                }
            }
        }
        visited = new boolean[n][n];

    }



    public static void main(String[] args) {
        input();
        solution();
    }
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
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
