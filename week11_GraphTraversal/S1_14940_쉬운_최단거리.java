package week11_GraphTraversal;

import java.io.*;
import java.util.*;

public class S1_14940_쉬운_최단거리 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] dx = {0, 0, -1, 1}, dy = {-1, 1, 0, 0};
    static int[][] distance;
    static int[][] board;
    static int startX, startY;
    static void input(){
        N = scan.nextInt();
        M = scan.nextInt();
        StringTokenizer st;
        distance = new int[N][M];
        board = new int[N][M];
        for(int i = 0;  i < N; i++){
            Arrays.fill(distance[i], -1);
        }
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                board[i][j] = scan.nextInt();
                if(board[i][j] == 2){
                    startX = i;
                    startY = j;
                }
                if(board[i][j] == 0){
                    distance[i][j] = 0;
                }

            }
        }

    }
    static void bfs(){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startX);
        queue.add(startY);
        distance[startX][startY] = 0;
        int x = 0, y = 0;
        int nx = 0, ny = 0;

        while(!queue.isEmpty()){
            x = queue.poll();
            y = queue.poll();
            for(int i = 0; i < 4; i++){
                nx = x + dx[i];
                ny = y + dy[i];
                if(nx < 0 || ny < 0 || nx >= N || ny >= M){
                    continue;
                }
                if(board[nx][ny] == 1 && distance[nx][ny] == -1){
                    distance[nx][ny] = distance[x][y] + 1;
                    queue.add(nx);
                    queue.add(ny);
                }

            }
        }
    }
    static void solution(){
        bfs();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                sb.append(distance[i][j] + " ");
            }
            sb.append("\n");
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
