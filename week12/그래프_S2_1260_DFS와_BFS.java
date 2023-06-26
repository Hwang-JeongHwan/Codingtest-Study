package week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * packageName    : Brute_Force
 * fileName       : S3_15651_N과_M_3
 * author         : jeonghwan
 * date           : 2023/05/27
 * time           : 10:32 PM
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023/05/29        jeonghwan       최초 생성
 */
public class 그래프_S2_1260_DFS와_BFS {
    static StringBuilder sb = new StringBuilder();
    static FastReader scan = new FastReader();

    static int N, M, V;
    static int[][] adj; // 인접행렬로 구현
    static ArrayList<Integer>[] arr; //인접리스트로 구현
    static boolean[] visited;

    static void input(){
        N = scan.nextInt();
        M = scan.nextInt();
        V = scan.nextInt();
        int x, y;
        adj = new int[N + 1][N + 1];
        arr = new ArrayList[N + 1];
//        for(int i = 1; i <= M; i++){ // 인접행렬
//            x = scan.nextInt();
//            y = scan.nextInt();
//            adj[x][y] = 1;
//            adj[y][x] = 1;
//
//        }
        for(int i = 0; i <= N; i++){
            arr[i] = new ArrayList<Integer>();
        }
        for(int i = 1; i <= M; i++){ // 인접리스트
            x = scan.nextInt();
            y = scan.nextInt();
            arr[x].add(y);
            arr[y].add(x);
        }
        for(int i = 1; i <= N; i++){
            Collections.sort(arr[i]);
        }
    }
    static void dfs(int V){  // 인접행렬
        visited[V] = true;
        sb.append(V).append(' ');

        for(int i = 1; i <= N; i++){
            if(adj[V][i] == 1){
                if(!visited[i]){
                    dfs(i);
                }
            }
        }

    }
    static void dfs2(int x){
        visited[x] = true;
        sb.append(x + " ");

        for(int y : arr[x]){
            if(visited[y]){
                continue;
            }
            dfs2(y);
        }
    }

    static void bfs(int V){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(V);
        visited[V] = true;
        int x = 0;
        while(!queue.isEmpty()){
            x = queue.poll();
            sb.append(x).append(' ');
            for(int i = 1; i <= N; i++){
                if(adj[x][i] == 1){
                    if(!visited[i]){
                        visited[i] = true;
                        queue.add(i);
                    }
                }
            }
        }
    }
    static void bfs2(int x){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        visited[x] = true;
        int now = 0;
        while(!queue.isEmpty()){
            now = queue.poll();
            sb.append(now + " ");
            for(int i : arr[now]){
                if(!visited[i]){
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
    static void solution(){
        visited = new boolean[N + 1];
        dfs2(V);
        sb.append("\n");
        visited = new boolean[N + 1];
        bfs2(V);
        System.out.println(sb);
    }

    public static void main(String[] args) {
        input();
        solution();
    }
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        public FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next(){
            while(st == null || !st.hasMoreElements()){
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch(IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt(){
            return Integer.parseInt(next());
        }
    }
}
