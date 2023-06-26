package week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * packageName    : Brute_Force
 * fileName       : S3_15651_N과_M_3
 * author         : jeonghwan
 * date           : 2023/05/27
 * time           : 10:01 PM
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023/05/29        jeonghwan       최초 생성
 */


public class 그래프_S3_2606_바이러스 {
    static FastReader scan = new FastReader();
    static ArrayList<Integer>[] arr;
    static int V, E, count;
    static boolean[] visited;
    static void input(){
        V = scan.nextInt();
        E = scan.nextInt();
        visited = new boolean[V + 1];
        arr = new ArrayList[V + 1];
        int start = 0, end = 0;
        for(int i = 0; i <= V; i++){
            arr[i] = new ArrayList<>();
        }

        for(int i = 1; i <= E; i++){
            start = scan.nextInt();
            end = scan.nextInt();
            arr[start].add(end);
            arr[end].add(start);
        }
    }

    static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        int now = 0;
        while(!queue.isEmpty()){
            now = queue.poll();
            for(int i : arr[now]){
                if(!visited[i]){
                    visited[i] = true;
                    count++;
                    queue.add(i);
                }
            }
        }

    }
    static void solution(){
        bfs(1);
        System.out.print(count);

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
                catch (IOException e){
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
