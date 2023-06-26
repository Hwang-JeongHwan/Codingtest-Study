package week12;
import java.io.*;
import java.util.*;
/**
 * packageName    : week12
 * fileName       : 시뮬레이션_G5_16234_인구이동
 * author         : jeonghwan
 * date           : 2023/05/26
 * time           : 10:33 AM
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023/05/30        jeonghwan       최초 생성
 */
public class 시뮬레이션_G5_16234_인구이동 {
    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static FastReader scan = new FastReader();
    static int[][] data;
    static boolean[][] visited;
    static int N, L, R, result;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1 , 1};

    static boolean flag;
    static void input() {
        N = scan.nextInt();
        L = scan.nextInt();
        R = scan.nextInt();

        data = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                data[i][j] = scan.nextInt();
            }
        }
    }

    static void bfs(int startX, int startY) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startX);
        queue.add(startY);

        visited[startX][startY] = true;
        List<Node> nodes = new ArrayList<>();
        int total = 0;
        while (!queue.isEmpty()) {
            int x = queue.poll();
            int y = queue.poll();

            total += data[x][y];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (visited[nx][ny]) continue;
                int differ = Math.abs(data[x][y] - data[nx][ny]);
                if (differ >= L && differ <= R) {
                    visited[nx][ny] = true;
                    nodes.add(new Node(nx, ny));
                    queue.add(nx);
                    queue.add(ny);
                }


            }
        }
        // Node 리스트가 비어있지 않다면 인구이동이 발생했다는것 ->
        // 인구이동이 발생한 나라에 대해 인구수 업데이트
        if (!nodes.isEmpty()) {
            int div = total / (nodes.size() + 1);
            data[startX][startY] = div;
            for (int i = 0; i < nodes.size(); i++) {
                Node node = nodes.get(i);
                data[node.x][node.y] = div;
            }
            flag = true;
        }

    }

    //날짜 계산은 bfs 밖에서 해야함
    static void solution() {
        while (true) {
            visited = new boolean[N][N];
            flag = false;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        bfs(i, j);
                    }
                }
            }
            if (!flag) {
                return;
            }
            result++;
        }
    }
    public static void main(String[] args) {
        input();
        solution();
        System.out.println(result);
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
