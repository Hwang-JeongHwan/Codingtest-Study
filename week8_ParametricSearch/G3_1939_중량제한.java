package week8_ParametricSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G3_1939_중량제한 {
    static FastReader scan = new FastReader();
    static int n, m, start, end;
    static class Node{
        int num, weight;
        public Node(int num, int weight){
            this.num = num;
            this.weight = weight;
        }
    }
    static ArrayList<Node>[] graph;
    static boolean[] visited;


    static void input(){
        int a, b, c;
        n = scan.nextInt();
        m = scan.nextInt();
        graph = new ArrayList[n + 1];

        for(int i = 0; i <= n; i++){
            graph[i] = new ArrayList<Node>();

        }
        for(int i = 1; i <= m; i++){
            a = scan.nextInt();
            b = scan.nextInt();
            c = scan.nextInt();

            graph[a].add(new Node(b, c));
            graph[b].add(new Node(a, c));
        }
        start = scan.nextInt();
        end = scan.nextInt();
    }
//    static void bfs(int start){
//        Queue<Node> queue = new LinkedList<Node>();
//        queue.offer(new Node(start, 1000_000_000)); // 초기에 최대값을 큐에 넣어줌
//        Node nowNode; // 현재노드
//        int nowNum;
//        while(!queue.isEmpty()){
//            nowNode = queue.poll();
//            nowNum = nowNode.num;
//            for(Node nextNode : graph[nowNum]){
//                if(nextNode.weight <= nowNode.weight){ // 다음노드에 저장되어있는 weight가
//                    // 현재 노드의 weight보다 작거나 같을때만 이동가능
//
//                    // 현재 다음 노드번호에 저장되어있는값 보다 크면 갱신
//                    if(nextNode.weight > weightArr[nextNode.num]){
//                        weightArr[nextNode.num] = nextNode.weight;
//                        queue.offer(nextNode);
//                    }
//                }
//            }
//        }
//    }

    static boolean bfs(int limit){
        // weight의 범위가 10억이하이므로 이분탐색으로 풀어야함
        // bfs로 start부터 end까지 도달할 수 있으면 true반환
        boolean result = false;
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(start);
        visited[start] = true;
        int now;
        while(!queue.isEmpty()){
            now = queue.poll();
            if(now == end){
                result = true;
                break;
            }
            for(Node nowNode : graph[now]){
                if(!visited[nowNode.num] && nowNode.weight >= limit){
                    // 아직 방문하지 않았고 limit가 현재 노드의 weight보다 작거나 같으면 방문가능
                    visited[nowNode.num] = true;
                    queue.offer(nowNode.num);
                }
            }
        }

        return result;
    }
    static void solution(){
        int left = 1, mid = 0, right = 1000_000_000, result = 0;
        while(left <= right){
            mid = (left + right) / 2;

            visited = new boolean[n + 1];
            if(bfs(mid)){ // mid값으로 start에서 end까지 도달할 수 있으면 left값 증가 -> 최대값을 구해야 하므로
                left = mid + 1;
                result = mid;
            }
            else{
                right = mid - 1;
            }
        }
        // 같을때 left값을 조정하므로 right값 출력

        System.out.println(right);
    }
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
                try {
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
