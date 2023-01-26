package book_study;
import java.util.*;
import java.io.*;

public class S1_2178_미로_탐색 {
    static int [][] arr;
    static int n, m;
    static boolean [][] visited;
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};
    static void bfs(int start_x, int start_y){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {start_x, start_y});
        visited[start_x][start_y] = true;
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];

            for(int i = 0; i < 4; i ++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= n || ny >= m){
                    continue;
                }
                if (arr[nx][ny] != 0 && !visited[nx][ny] ){
//                    System.out.println("nx : " + nx + " ny : " + ny + " x : " + x + " y : " + y);
                    arr[nx][ny] = arr[x][y] + 1;
                    queue.offer(new int[] {nx, ny});
                    visited[nx][ny] = true;
                }

            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visited = new boolean[n][m];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();

            for(int j = 0; j < m; j++){
                arr[i][j] = Integer.parseInt(line.substring(j, j + 1));
            }
        }
        bfs(0, 0);
        System.out.println(arr[n - 1][m - 1]);

    }
}
