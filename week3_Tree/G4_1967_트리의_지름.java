package week3_Tree;
import java.util.*;
import java.io.*;

public class G4_1967_트리의_지름 {
    static ArrayList<Node>[] arr;
    static class Node{
        int e;
        int cost;
        Node(int e, int cost){
            this.e = e;
            this.cost = cost;
        }
    }
    static boolean visited[];
    static int distance[];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        arr = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        distance = new int[n + 1];
        for(int i = 0; i < n + 1; i++){ // NullPointer Error발생되었다고 계속 틀렸다고 나왓는데
            // i = 0부터 arraylist만들어주니까 해결;; 어이없음 문제에서 노드번호가 1번부터 주어진다고 했는데
            // 0이 입력으로 들어오는지 모르겠음 ==> 이유찾음 0이 입력으로 들어오는게 아니라
            // 입력이 1이 들어왔을때 답이 0이 출력되어야 해서 그런듯;
            // i = 1부터면 n = 1일때 arr[1]에 접근 불가

            arr[i] = new ArrayList<Node>();
        }

        for(int i = 0; i < n - 1; i++){
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            arr[s].add(new Node(e, cost));
            arr[e].add(new Node(s, cost));



        }
//        for(int i = 1; i < n + 1; i++){
//            System.out.println(Arrays.toString(arr));
//        }
        bfs(1);
//        System.out.println(Arrays.toString(distance));
        int max = 0;
        int maxIndex = 0;
//        System.out.println(Arrays.toString(distance));
        for(int i = 1; i < n + 1; i++){
            if(distance[i] > max){
                max = distance[i];
                maxIndex = i;
            }
        }
        visited = new boolean[n + 1];
        distance = new int[n + 1];
        bfs(maxIndex);
        Arrays.sort(distance);
//        System.out.println(Arrays.toString(distance));
//        System.out.println(distance);
        System.out.println(distance[n]);
        br.close();
        System.exit(0);

    }
    static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while(!queue.isEmpty()){
            int now = queue.poll();
            for(Node node : arr[now]){

                int e = node.e;
                int cost = node.cost;
                if(!visited[e]) {
                    visited[e] = true;
                    distance[e] = distance[now] + cost;
                    queue.offer(e);
                }
            }

        }
    }
}
