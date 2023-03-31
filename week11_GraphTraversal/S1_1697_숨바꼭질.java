package week11_GraphTraversal;

import java.io.*;
import java.util.*;

public class S1_1697_숨바꼭질 {
    static FastReader scan = new FastReader();
    static int N, K;
    static int[] distance;
    static boolean[] visited;
    static void input(){
        N = scan.nextInt();
        K = scan.nextInt();
        visited = new boolean[100001];
        distance = new int[100001];
    }

    static void bfs(){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        visited[N] = true;
        distance[N] = 0;
        int x = 0, y = 0;
        while(!queue.isEmpty()){
            x = queue.poll();
            y = x - 1;
            if(0 <= y && y <= 100000 && !visited[y]){
                visited[y] = true;
                distance[y] = distance[x] + 1;
                queue.add(y);
            }
            y = x + 1;
            if(0 <= y && y <= 100000 && !visited[y]){
                visited[y] = true;
                distance[y] = distance[x] + 1;
                queue.add(y);
            }
            y = x * 2;
            if(0 <= y && y <= 100000 && !visited[y]){
                visited[y] = true;
                distance[y] = distance[x] + 1;
                queue.add(y);
            }
        }

    }
    static void solution(){
        bfs();
        System.out.println(distance[K]);
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
