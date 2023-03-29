package week11_GraphTraversal;
import java.util.*;
import java.io.*;
public class S2_11725_트리의_부모_찾기 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer>[] arr;
    static int N;
    static int[] parent;

    static void input(){
        N = scan.nextInt();
        parent = new int[N + 1];
        arr = new ArrayList[N + 1];
        int start = 0, end = 0;
        for(int i = 0; i <= N; i++){
            arr[i] =  new ArrayList<Integer>();
        }
        for(int i = 1; i <= N - 1; i++){
            start = scan.nextInt();
            end = scan.nextInt();
            arr[start].add(end);
            arr[end].add(start);
        }
    }

    static void bfs(int start){
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(start);
        int now = 0;
        while(!queue.isEmpty()){
            now = queue.poll();
            for(int i : arr[now]){
                if(parent[i] == 0){
                    parent[i] = now;
                    queue.add(i);
                }
            }
        }

    }
    static void solution(){
        bfs(1);
        for(int i = 2; i <= N; i++){
            sb.append(parent[i] + "\n");
        }
        System.out.print(sb);
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
                try{
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
