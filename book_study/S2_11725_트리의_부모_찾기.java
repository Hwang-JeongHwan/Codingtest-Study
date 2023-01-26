package book_study;
import java.io.*;
import java.util.*;
public class S2_11725_트리의_부모_찾기 {
    static ArrayList<Integer>[] arr;
    static int parent[];

    static void dfs(int now){
//        if(parent[now] != 0){
//            return;
//        }
        for(int i : arr[now]){
            if(parent[i] == 0) {
                parent[i] = now;
                dfs(i);
            }
        }
    }
    static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        parent[start] = 1;

        while(!queue.isEmpty()){
            int now = queue.poll();
            for(int i : arr[now]){
                if(parent[i] == 0){
                    parent[i] = now;
                    queue.offer(i);
                }
            }
        }
    }

    public static void main(String[] args )throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        arr = new ArrayList[n + 1];
        parent = new int[n + 1];
        for(int i = 1; i < n + 1; i++){
            arr[i] = new ArrayList<Integer>();

        }
        for(int i = 0; i < n - 1; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[s].add(e);
            arr[e].add(s);
        }

//        bfs(1);
//        for(int i = 2; i < n + 1; i++){
//            System.out.println(parent[i]);
//        }
        parent = new int[n + 1];
        parent[1] = 1;
        dfs(1);
        for(int i = 2; i < n + 1; i++){
            System.out.println(parent[i]);
        }

    }

}
