package week3_Tree;
import java.util.*;
import java.io.*;

public class G4_3584_가장_가까운_공통_조상 {
    static ArrayList<Integer>[] tree;
    static boolean visited[];
    static int parent[];
    static int depth[];
    public static void main(String args[])  throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(st.nextToken());
        for(int tc = 0; tc < t; tc ++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
//            System.out.println(n);
            tree = new ArrayList[n + 1];
            visited = new boolean[n + 1];
            parent = new int[n + 1];
            depth = new int[n + 1];

            for(int i = 0; i < n + 1; i++){
                tree[i] = new ArrayList<Integer>();
            }
            for(int i = 0; i< n - 1; i ++){
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());

                tree[s].add(e);
                tree[e].add(s);

                parent[e] = s;
            }
            int root = 0;
            for(int i = 1; i < n + 1; i++){
                if(parent[i] == 0){
                    root = i;
                    break;
                }
            }
            bfs(root);
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(LCA(a, b) + "\n");


        }
        System.out.println(sb);

    }
    static int LCA(int a, int b){
        if(depth[a] < depth[b]){
            int temp = a;
            a = b;
            b = temp;
        }
        while(depth[a] != depth[b]){
            a = parent[a];
        }
        while(a != b){
            a = parent[a];
            b = parent[b];
        }
        return a;
    }
    static void bfs(int start){
        Queue<int[]>queue = new LinkedList<>();
        visited[start] = true;
        queue.offer(new int[]{start, 1});

        while(!queue.isEmpty()){
            int[] now = queue.poll();
            int nowNode = now[0];
            int nowDepth = now[1];
            depth[nowNode] = nowDepth;
            for(int i : tree[nowNode]){
                if(!visited[i]){
                    visited[i] = true;
                    queue.offer(new int[]{i, nowDepth + 1});
                }
            }
        }
    }
}
