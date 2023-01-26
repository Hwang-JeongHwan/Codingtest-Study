package book_study;
import java.util.*;
import java.io.*;
public class S2_1260_DFS와_BFS {
    static ArrayList<Integer>[] arr;
    static boolean[] visited;
    static void dfs(int start){
        if(visited[start]){
            return;
        }
        System.out.print(start + " ");
        visited[start] = true;
        for(int i : arr[start]){
            if(!visited[i]){
                dfs(i);
            }
        }
    }
    static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        System.out.print(start + " ");
        queue.offer(start);

        while(!queue.isEmpty()){
            int now = queue.poll();
            for(int i : arr[now]){
                if(!visited[i]){
                    System.out.print(i + " ");
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }

    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        arr = new ArrayList[n + 1];
        for(int i = 1; i < n + 1; i++){
            arr[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[s].add(e);
            arr[e].add(s);
        }
//        System.out.println(Arrays.toString(arr));
        for(int i = 1; i < n + 1; i ++){
            Collections.sort(arr[i]);
        }
        visited = new boolean[n + 1];

        dfs(v);
        System.out.println();
//        System.out.println(Arrays.toString(visited));
        visited = new boolean[n + 1];
//        System.out.println(Arrays.toString(visited));

        bfs(v);
    }
}
