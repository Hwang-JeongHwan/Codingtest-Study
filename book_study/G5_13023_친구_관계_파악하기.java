package book_study;
import java.util.*;
import java.io.*;
public class G5_13023_친구_관계_파악하기 {
    static ArrayList<Integer>[] arr;
    static boolean visited[];
    static ArrayList<Integer> trace;
    static boolean result;
    public static void dfs(int now, int depth){
        trace.add(now);
        if (depth == 5 ){
            result = true;
//            System.out.println(trace.toString() + " " + Arrays.toString(visited) + " " + depth);
            return;
        }
        visited[now] = true;
        for(int i : arr[now]){
//            System.out.println(" now : " + now + " i : " + i + " arr[now] : " + arr[now] + " visited : " + Arrays.toString(visited));
            if(!visited[i]) {
                dfs(i, depth + 1);
            }
        }
        visited[now] = false;

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new ArrayList[n];
        trace = new ArrayList<>();
        result = false;
        for (int i = 0; i < n; i++) {
            arr[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[s].add(e);
            arr[e].add(s);

        }
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {

            dfs(i, 1);
            if (result)
            {
                break;
            }
        }
        if (result) {
            System.out.println("1");

        }
        else{
            System.out.println("0");
        }
    }
}
