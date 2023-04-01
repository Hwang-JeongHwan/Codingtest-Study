package week11_GraphTraversal;

import java.io.*;
import java.util.*;

public class G5_7576_토마토 {
    static FastReader scan = new FastReader();
    static int[][] tomato;
    static int[] dx = {0, 0, -1, 1}, dy = {-1, 1, 0, 0};
    static Queue<Integer> queue;
    static int N, M, tomatoCount, total, minusCount;

    static void input(){
        M = scan.nextInt();
        N = scan.nextInt();
        tomato = new int[N][M];
        queue = new LinkedList<>();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                tomato[i][j] = scan.nextInt();
                if(tomato[i][j] == -1){
                    minusCount++;
                }
                if(tomato[i][j] == 1){
                    queue.add(i);
                    queue.add(j);
                    queue.add(0);
                    tomatoCount++;
                }
            }
        }
    }
    static void bfs(){
        int x = 0, y = 0, nx = 0, ny = 0, count = 0;
        while(!queue.isEmpty()) {
            x = queue.poll();
            y = queue.poll();
            count = queue.poll();
            for(int i = 0; i < 4; i ++){
                nx = x + dx[i];
                ny = y + dy[i];
                if(nx < 0 || ny < 0 || nx >= N || ny >= M){
                    continue;
                }
                if(tomato[nx][ny] == 0){
                    tomato[nx][ny] = 1;
                    tomatoCount++;
                    queue.add(nx);
                    queue.add(ny);
                    queue.add(count + 1);
                }
            }
        }
        total = count;
    }
    static void solution(){
        bfs();
        if(tomatoCount < (N * M) - minusCount){
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
