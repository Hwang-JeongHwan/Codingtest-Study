package week3_Tree;
import java.util.*;
import java.io.*;


public class G5_17073_나무_위의_빗물 {
    static ArrayList<Integer>[] tree;
    static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        tree = new ArrayList[500001];
        visited = new boolean[500001];
        for (int i = 0; i < 500001; i++) {
            tree[i] = new ArrayList<>();

        }
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

//            if(s > e){
//                int temp = s;
//                s = e;
//                e = temp;
//            }
//            tree[s].add(e); // 부모가 항상 작다고 생각했는데 아니었음

            tree[s].add(e);
            tree[e].add(s);
        }

//        System.out.println(count); 반복문으로도 풀이가능
//        for(int i = 2; i < n + 1; i++){
//            if(tree[i].size() == 1){
//                count++;
//            }
//
//        }
        int count = bfs(1); // bfs로도 풀이가능
//            String result = String.format("%.6f", w / count);
//            System.out.println(result);
        System.out.printf(String.format("%.10f ", (w / (double) count)));
//            System.out.println((double) w / count);

    }

    static int bfs(int start){
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while(!queue.isEmpty()){
            int now = queue.poll();
            //System.out.println(tree[now]);
            if(tree[now].size() == 1 && now != 1){
                count++;
            }
            for(int i : tree[now]){
                if(!visited[i]){
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }
        return count;
    }
}
