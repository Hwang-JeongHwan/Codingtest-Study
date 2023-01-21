package book_study;
import java.util.*;
import java.io.*;
public class S1_11724_연결요소 {
    static ArrayList<Integer>[] graph;
    static boolean visited[];
    static void dfs(int v){
        if(visited[v]){
            return;
        }
        visited[v] = true;
        for(int i: graph[v]){
            if(!visited[i]){
                dfs(i);
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        for(int i = 1; i < n + 1; i++){
            graph[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph[s].add(e);
            graph[e].add(s);

        }
//        System.out.println(Arrays.toString(graph));
//        System.out.println(graph.toString());
        int result = 0;
        for(int i = 1; i < n + 1; i++){
            if(!visited[i]){
                result ++;
                dfs(i);
            }
        }
        System.out.println(result);
    }
}
