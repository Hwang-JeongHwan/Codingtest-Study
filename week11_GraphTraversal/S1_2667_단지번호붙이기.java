package week11_GraphTraversal;
import java.io.*;
import java.util.*;
public class S1_2667_단지번호붙이기 {
    // dfs를 돌리고 끝날때 groupCount를 result에 append
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int dx[] = {0, 0, -1, 1}, dy[] = {-1, 1, 0, 0};
    static int N, groupCount;
    static String[] arr;
    static boolean[][] visited;
    static ArrayList<Integer> result;

    static void input(){
        N = scan.nextInt();
        arr = new String[N];
        visited = new boolean[N][N];
        result = new ArrayList<Integer>();

        for(int i = 0; i < N; i++){
            arr[i] = scan.nextLine();

        }
    }

    static void dfs(int x, int y){
        visited[x][y] = true;
        groupCount++;
        int nx = 0, ny = 0;
        for(int i = 0; i < 4; i++){
            nx = x + dx[i];
            ny = y + dy[i];

            if(nx >= 0 && ny >= 0 && nx < N && ny < N){
                if(arr[nx].charAt(ny) == '1'){
                    if(!visited[nx][ny]){
                        dfs(nx, ny);
                    }
                }
            }
        }

    }
    static void solution(){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!visited[i][j] && arr[i].charAt(j) == '1'){
                    groupCount = 0;
                    dfs(i, j);
                    result.add(groupCount);
                }
            }
        }
        Collections.sort(result);
        sb.append(result.size() + "\n");
        for(int i : result){
            sb.append(i + "\n");
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
        String nextLine(){
            String str = "";
            try{
                str = br.readLine();
            }
            catch(IOException e){
                e.printStackTrace();
            }
            return str;
        }
    }
}
