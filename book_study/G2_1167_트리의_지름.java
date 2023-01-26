package book_study;
import java.util.*;
import java.io.*;
public class G2_1167_트리의_지름 {
    static class Node{
        int e, cost;
        Node(int e, int cost){
            this.e = e;
            this.cost = cost;
        }
    }
    static ArrayList<Node>[] arr;
    static boolean[] visited;
    static int[] distance;
    static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while(!queue.isEmpty()){
            int now = queue.poll();
            for(Node node: arr[now]){
                int e = node.e;
                int cost = node.cost;
                if(!visited[e]){
                    distance[e] = distance[now] + cost;
                    visited[e] = true;
                    queue.offer(e);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        visited = new boolean[n + 1];
        distance = new int[n + 1];
        arr = new ArrayList[n + 1];
        for(int i = 1; i < n + 1; i++){
            arr[i] = new ArrayList<Node>();
        }
        for(int i = 0; i < n; i ++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            while(true){
                int e = Integer.parseInt(st.nextToken());
                if(e == -1){
                    break;
                }
                int cost = Integer.parseInt(st.nextToken());

                arr[s].add(new Node(e, cost));
            }
        }
        bfs(1);
//        System.out.println(Arrays.toString(distance));
        int max = 0;
        int maxIndex = 0;
        for(int i = 1; i < n + 1; i++){
            if(max < distance[i]){
                max = distance[i];
                maxIndex = i;
            }
        }


        visited = new boolean[n + 1];
        distance = new int[n + 1];
        bfs(maxIndex);
        Arrays.sort(distance);
//        System.out.println(Arrays.toString(distance));

        System.out.println(distance[n]);
    }
}
