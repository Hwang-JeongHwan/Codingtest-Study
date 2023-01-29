package book_study;
import java.util.*;
import java.io.*;

public class G3_최송공통조상구하기1_LCA {
    static ArrayList<Integer> tree[];
    static boolean visited[];
    static int parent[];
    static int depth[];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        tree = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        parent = new int[n + 1];
        depth = new int[n + 1];
        for(int i = 0; i < n + 1; i++){
            tree[i] = new ArrayList<>();

        }
        for(int i = 0; i < n - 1; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            tree[s].add(e);
            tree[e].add(s);
        }
        bfs(1, 0);
//        System.out.println("parent : " + Arrays.toString(parent));
//        System.out.println("depth : " + Arrays.toString(depth));
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
//            System.out.println(LCA(a, b));
            sb.append(LCA(a, b) + "\n");
        }

        System.out.println(sb);
    }
    static int LCA(int a, int b){
//        System.out.println("depth[a] : " + depth[a] + " depth[b] : "+ depth[b]);
        if(depth[a] < depth[b]){

            int temp = a;
            a = b;
            b = temp;
            // 항상 a의 깊이가 더 깊다고 셋팅후 진행
        }
//        if(parent[a] == b){
//            return parent[a];
//        }
        while(depth[a] != depth[b]){
//            depth[a] = depth[parent[a]];
            a = parent[a];
//            System.out.println(depth[a]);
        }
//        System.out.println("while finish, depth[a] : " + depth[a] + " depth[b] : "+ depth[b]);
//        System.out.println("parent[a] : " + parent[a] + " parent[b] : " + parent[b]);
        while(a != b){ // 처음에는 부모가 다르면 반복 수행했었는데 그렇게 하니까 1퍼에서 바로 틀림

            // a == b면 바로 리턴하면 되니까 a != b면 반복
            a = parent[a];
            b = parent[b];
//            System.out.println("parent[a] : " + parent[a] + " parent[b] : " + parent[b]);
        }

        return a;
    }
    static void bfs(int start, int startDepth){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start, startDepth});
        visited[start] = true;

        while(!queue.isEmpty()){
            int[] now  = queue.poll();
            int nowNode = now[0];
            int nowDepth = now[1];
            depth[nowNode] = nowDepth;
            for(int i : tree[nowNode]){
                if(!visited[i]){
                    visited[i] = true;
                    parent[i] = nowNode;
                    queue.offer(new int[]{i, nowDepth + 1});
                }
            }
        }
    }
}
