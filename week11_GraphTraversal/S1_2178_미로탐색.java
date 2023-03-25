package week11_GraphTraversal;
import java.io.*;
import java.util.*;
public class S1_2178_미로탐색 {
    static FastReader scan = new FastReader();
    static int N, M;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static String[] arr;
    static int[][] distance;
    static boolean[][] visited;

    static void input(){
        N = scan.nextInt();
        M = scan.nextInt();
        distance = new int[N][M];
        visited = new boolean[N][M];
        arr = new String[N];
        for(int i = 0; i < N; i++){
            arr[i] = scan.nextLine();

        }


    }
    static void bfs(int startX, int startY){
        // distance 배열 초기화
        for(int i = 0; i < N; i++){
            Arrays.fill(distance[i], -1);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startX);
        queue.add(startY);
        distance[startX][startY] = 1;
        visited[startX][startY] = true;

        int x = 0, y = 0;
        int nx = 0, ny = 0;
        while(!queue.isEmpty()){
            x = queue.poll();
            y = queue.poll();
            for(int i = 0; i < 4; i++){
                nx = x + dx[i];
                ny = y + dy[i];
                if(nx < 0 || ny < 0 || nx >= N || ny >= M){
                    continue;
                }
                if(!visited[nx][ny] && arr[nx].charAt(ny) == '1'){
                    visited[nx][ny] = true;
                    distance[nx][ny] = distance[x][y] + 1;
                    queue.add(nx);
                    queue.add(ny);
                }
            }
        }
    }
    static void solution(){
        bfs(0, 0);
        System.out.println(distance[N - 1][M - 1]);
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
            catch (IOException e){
                e.printStackTrace();
            }
            return str;
        }
    }
}
