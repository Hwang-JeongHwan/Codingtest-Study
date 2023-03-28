package week11_GraphTraversal;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S1_16918_봄버맨 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int[] dx = {0, 0, -1, 1}, dy = {-1, 1, 0, 0};
    static char[][] arr;
    static int[][] timer;

    static int R, C, N;

    static void input(){
        R = scan.nextInt();
        C = scan.nextInt();
        N = scan.nextInt();
        arr = new char[R][C];
        timer = new int[R][C];
        String str = "";
        for(int i = 0; i < R; i++){
            str = scan.nextLine();
            for(int j = 0; j < C; j++){
                arr[i][j] = str.charAt(j);
                if(arr[i][j] == 'O'){
                    timer[i][j] = 3;
                }
            }
        }

    }
    static void solution(){
        // 이동할 위치 나타내는 변수
        int nx = 0, ny = 0;
        // N초 후의 상태를 출력하는거니까 N까지 반복
        for(int time = 1; time <= N; time++){
            if(time % 2 == 0){
                //짝수인 경우 폭탄 설치
                for(int i = 0; i < R; i++){
                    for(int j = 0; j < C; j++){
                        if(arr[i][j] == '.'){
                            arr[i][j] = 'O';
                            // 3초뒤에 터지므로 타이머에  추가
                            timer[i][j] = time + 3;
                        }
                    }
                }
            }
            else{
                for(int i = 0; i < R; i++){
                    for(int j = 0; j < C; j++){
                        // 현재 터질 시간이 되었고 폭탄이 있는 자리면 터트림
                        if(arr[i][j] == 'O' && timer[i][j] == time){
                            arr[i][j] = '.';
                            // 상하좌우 인접한면을 탐색
                            for(int k = 0; k < 4; k++){
                                nx = i + dx[k];
                                ny = j + dy[k];
                                if(nx < 0 || ny < 0 || nx >= R || ny >= C){
                                    continue;
                                }
                                // 인접한 칸에 있는 폭탄의 타이머가 현재 시간과 같지않으면 터트림
                                // 같을때 터트리면 터져야할 폭탄이 인접한 칸을 파괴시키지 못함
                                if(timer[nx][ny] != time) {
                                    arr[nx][ny] = '.';
                                }
                            }
                        }
                    }
                }
            }
        }
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    public static void main(String[] args) {
        input();
        solution();

    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
