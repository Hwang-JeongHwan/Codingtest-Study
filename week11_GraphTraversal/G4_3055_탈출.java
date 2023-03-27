package week11_GraphTraversal;
import java.io.*;
import java.util.*;
public class G4_3055_탈출 {
    static FastReader scan = new FastReader();
    static Queue<Integer> dochiQueue = new LinkedList<>(), waterQueue = new LinkedList<>();
    static int[] dx = {0, 0, -1, 1}, dy = {-1, 1, 0, 0};
    static int[][] dochiDistance, waterDistance;
    static boolean[][] dochiVisited, waterVisited;
    static int destinationX, destinationY;
    static String[] arr;
    static int R, C;

    static void input(){
        R = scan.nextInt();
        C = scan.nextInt();
        dochiDistance = new int[R][C];
        waterDistance = new int[R][C];
        dochiVisited = new boolean[R][C];
        waterVisited = new boolean[R][C];
        arr = new String[R];
        for(int i = 0; i < R; i++){
            arr[i] = scan.nextLine();
            for(int j = 0; j < C; j++){
                waterDistance[i][j] = -1;
                dochiDistance[i][j] = -1;
                if(arr[i].charAt(j) == '*'){
                    waterQueue.add(i);
                    waterQueue.add(j);
                    waterDistance[i][j] = 0;
                    waterVisited[i][j] = true;
                }
                if(arr[i].charAt(j) == 'S'){
                    dochiQueue.add(i);
                    dochiQueue.add(j);
                    dochiDistance[i][j] = 0;
                    dochiVisited[i][j] = true;
                }
                if(arr[i].charAt(j) == 'D'){
                    destinationX = i;
                    destinationY = j;
                }
            }
        }
    }
    static void waterBfs(){
        int x = 0, y = 0;
        int nx = 0, ny = 0;
        while(!waterQueue.isEmpty()){
            x = waterQueue.poll();
            y = waterQueue.poll();
            for(int i = 0; i < 4; i++) {
                nx = x + dx[i];
                ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= R || ny >= C) {
                    continue;
                }
                if (!waterVisited[nx][ny] && arr[nx].charAt(ny) != 'X' && arr[nx].charAt(ny) != 'D') {
                    waterDistance[nx][ny] = waterDistance[x][y] + 1;
                    waterVisited[nx][ny] = true;
                    waterQueue.add(nx);
                    waterQueue.add(ny);


                }
            }
        }

    }
    static void dochiBfs(){
        int x = 0, y = 0;
        int nx = 0, ny = 0;
        while(!dochiQueue.isEmpty()){
            x = dochiQueue.poll();
            y = dochiQueue.poll();
            for(int i = 0; i < 4; i++) {
                nx = x + dx[i];
                ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= R || ny >= C) {
                    continue;
                }

                if (!dochiVisited[nx][ny] && arr[nx].charAt(ny) != 'X') {
                    if(arr[nx].charAt(ny) == 'D'){
                        dochiDistance[nx][ny] = dochiDistance[x][y] + 1;
                        dochiVisited[nx][ny] = true;
                        return;
                    }
                    // waterDistance == -1 인경우도 갈 수 있음
                    if (dochiDistance[x][y] + 1 < waterDistance[nx][ny] || waterDistance[nx][ny] == -1) {
                        dochiDistance[nx][ny] = dochiDistance[x][y] + 1;
                        dochiVisited[nx][ny] = true;
                        dochiQueue.add(nx);
                        dochiQueue.add(ny);

                    }
                }
            }
        }

    }

    static void solution(){
        waterBfs();
        dochiBfs();

        if(dochiDistance[destinationX][destinationY] == -1){
            System.out.println("KAKTUS");
        }
        else{
            System.out.println(dochiDistance[destinationX][destinationY]);
        }
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
