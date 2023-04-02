package week11_GraphTraversal;

import java.io.*;
import java.util.*;

public class G5_7579_토마토 {
    // 3차원 토마토의 위치를 담을 클래스
    static class Point{
        int x, y, z, count;
        public Point(){}
        public Point(int z, int x, int y, int count){
            this.x = x;
            this.y = y;
            this.z = z;
            this.count = count;
        }
    }
    static int[] dx = {0, 0, -1, 1, 0, 0}, dy = {-1, 1, 0, 0, 0, 0}, dz = {0, 0, 0, 0, -1, 1};
    static FastReader scan = new FastReader();
    static int[][][] board;
    static Queue<Point> queue = new LinkedList<>();
    static int N, M, H, total, minusCount, tomato;
    static void input(){
        M = scan.nextInt();
        N = scan.nextInt();
        H = scan.nextInt();
        board = new int[H][N][M];
        int spot = 0;
        for(int i = 0; i < H; i++){
            for(int j = 0; j < N; j++){
                for(int k = 0; k < M; k++){
                    spot = scan.nextInt();
                    board[i][j][k] = spot;
                    if(spot == -1){
                        minusCount++;
                    }
                    if(spot == 1){
                        tomato++;
                        queue.add(new Point(i, j ,k, 0));
                    }
                }
            }
        }
    }
    static void bfs(){
        int x = 0, y = 0, z = 0, count = 0;
        int nx = 0, ny = 0, nz = 0;
        while(!queue.isEmpty()){
            Point point = queue.poll();
            x = point.x;
            y = point.y;
            z = point.z;
            count = point.count;
            for(int i = 0; i < 6; i++){
                nx = x + dx[i];
                ny = y + dy[i];
                nz = z + dz[i];
                if(nx < 0 || ny < 0 || nz < 0 || nx >= N || ny >= M || nz >= H){
                    continue;
                }
                if(board[nz][nx][ny] == 0){
                    board[nz][nx][ny] = 1;
                    tomato++;
                    queue.add(new Point(nz, nx, ny, count + 1));
                }
            }
        }
        total = count;
    }
    static void solution(){
        bfs();
        if(tomato < N * M * H - minusCount){
            System.out.println(-1);
        }
        else{
            System.out.println(total);
        }
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

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
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

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
