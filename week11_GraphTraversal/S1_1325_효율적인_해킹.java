package week11_GraphTraversal;
import java.io.*;
import java.util.*;

public class S1_1325_효율적인_해킹 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer>[] arr;
    static int N, M, count;
    static boolean visited[];
    static int[] result;
    static void input(){
        N = scan.nextInt();
        M = scan.nextInt();
        arr = new ArrayList[N + 1];
        result = new int[N + 1];
        int start = 0, end = 0;

        for(int i = 0; i <= N; i++){
            arr[i] = new ArrayList<>();
        }

        for(int i = 1; i <= M; i++){
            start = scan.nextInt();
            end = scan.nextInt();
            arr[end].add(start);
        }

    }

    static void bfs(int start){
        visited = new boolean[N + 1];
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
        int max = 0;
        for(int i = 1; i <= N; i++){
            count = 0;
            bfs(i);
            result[i] = count;
            max = Math.max(count, max);
        }
        for(int i = 1; i <=N; i++){
            if(result[i] == max){
                sb.append(i + " ");
            }
        }
        System.out.print(sb);
    }
//    static void bfs(int start){ 이렇게 하면 시간초과 왜인지 모르겠음
//        visited = new boolean[N + 1];
//        Queue<Integer> queue = new LinkedList<>();
//        queue.add(start);
//        visited[start] = true;
//        int now = 0;
//
//        while(!queue.isEmpty()){
//            now = queue.poll();
//            for(int i : arr[now]){
//                if(!visited[i]){
//                    visited[i] = true;
//                    result[start]++;
//                    queue.add(i);
//                }
//            }
//        }
//    }
//    static void solution(){
//        int max = 0;
//        for(int i = 1; i <= N; i++){
//            bfs(i);
//            max = Math.max(result[i], max);
//        }
//        for(int i = 1; i <=N; i++){
//            if(result[i] == max){
//                sb.append(i + " ");
//            }
//        }
//        System.out.print(sb);
//    }


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
                try{
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
