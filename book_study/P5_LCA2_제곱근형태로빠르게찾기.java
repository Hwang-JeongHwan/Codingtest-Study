package book_study;
import java.io.*;
import java.util.*;

public class P5_LCA2_제곱근형태로빠르게찾기 {
    static ArrayList<Integer>[] tree;
    static int[][] parent;
    static int[] originParent;
    static int kMax;
    static int[] depth;
    static boolean[] visited;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        tree = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        depth = new int[N + 1];
        originParent = new int[N + 1];
        kMax = 0;
        for(int i = 0; i < N + 1; i++){
            tree[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i < N - 1; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            tree[s].add(e);
            tree[e].add(s);
        }

        int maxDepth = 0;
        for(int i = 1; i < N + 1; i++){
            if(depth[i] > maxDepth){
                maxDepth = depth[i];
            }
        }
//        int find = 2;
//        while(find <= maxDepth){
//            find *= 2;
//            k++;
//        } ==
        int temp = 1;
        while(temp <= N){
            temp <<= 1; // 왼쪽으로 1 비트씩 이동 1 => 2 => 4 => 8이런식으로
            kMax++;
//            System.out.println(temp +" " + kMax);

        }
//        System.out.println(maxDepth+" " + kMax);
        parent = new int[kMax + 1][N + 1];
//        parent[0] = originParent; 이렇게 안하고 bfs에서 바로 구함
        bfs(1,1);
        for(int k = 1; k < kMax + 1; k++){
            for(int n = 1; n < N + 1; n++){
                parent[k][n] = parent[k - 1][parent[k - 1][n]];
            }
        }
//        System.out.println(Arrays.deepToString(parent));
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(LCA(a, b) + "\n");
        }
        System.out.println(sb);
    }
    public static int LCA(int a, int b){
        if(depth[a] < depth[b]){
            int temp = a;
            a = b;
            b = temp;
        }
        for(int k = kMax; k >= 0; k--){
            if(Math.pow(2, k) <= depth[a] - depth[b]){
                if(depth[b] <= depth[parent[k][a]]){ // 깊이가 큰쪽의 깊이를 줄여야함
                    //2^k 만큼 깊이를 줄임
                    a = parent[k][a];

                }
            }

        }
        for(int k = kMax; k >= 0 ; k--){
            //2^k번째 부모가 다르면 a, b 를 a, b = 2^k의 a, b 번째 노드의 부모로 바꾸줌
            if(parent[k][a] != parent[k][b]){
                a = parent[k][a];
                b = parent[k][b];
            }
        }
        int LCA = a;
        if(a != b){ // k = 0까지 반복후 a!=b면
            // 바로 위의 노드가 최소공통조상임
            LCA = parent[0][LCA];
        }
        return LCA;




    }
    public static void bfs(int start, int startDepth){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start, startDepth});
        visited[start] = true;

        while(!queue.isEmpty()){
            int[] now = queue.poll();
            int nowNode = now[0];
            int nowDepth = now[1];
            depth[nowNode] = nowDepth;
            for(int next : tree[nowNode]){
                if(!visited[next]){
                    visited[next] = true;
                    parent[0][next] = nowNode;
                    queue.offer(new int[]{next, nowDepth + 1});
                }
            }
        }
    }
}
