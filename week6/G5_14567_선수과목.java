package week6;
import java.io.*;
import java.util.*;
public class G5_14567_선수과목 {
    static class Node{
        int number;
        int count;
        public Node(int number, int count){
            this.number = number;
            this.count = count;
//            System.out.println(this.number + " " + this.count);
        }
    }
    private static int[] indegree;

    private static ArrayList<Integer> arr[];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        indegree = new int[n + 1];
        arr = new ArrayList[n + 1];
        for(int i = 0; i <= n; i++){
            arr[i] = new ArrayList<Integer>();
        }
        int s, e;
        for(int i = 0; i < m; i ++){
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            arr[s].add(e);
            indegree[e] ++;
        }
        topologySort(n);
//        System.out.println(Arrays.toString(arr));
    }
    public static void topologySort(int n){
        Queue<Node> queue = new LinkedList<Node>();
        ArrayList<Node> result = new ArrayList<>();
        int now, cnt;
        for(int i = 1; i <= n; i++){
            if(indegree[i] == 0){
                queue.offer(new Node(i, 1));
            }
        }
        while(!queue.isEmpty()){
//            System.out.print(queue.peek() + " ");
            Node nowNode = queue.poll();
            result.add(nowNode);
            now = nowNode.number;
            cnt = nowNode.count;
//            System.out.println("now:" + now + " count: " + cnt);
            for(int i : arr[now]){
                indegree[i]--;
                if(indegree[i] == 0){
                    queue.offer(new Node(i, cnt + 1));
                }
            }
        }
//
//        for(Node i : result){
//            System.out.println(i.number + " " + i.count);
//        }
        Collections.sort(result,(o1, o2)->{
            return o1.number - o2.number;
        });
        for(Node i : result){
            System.out.print(i.count + " ");
        };


    }
}

