package week12;
import java.util.*;
import java.io.*;
/**
 * packageName    : week12
 * fileName       : 구현_G1_21611_마법사_상어와_블리자드
 * author         : jeonghwan
 * date           : 2023/05/31
 * time           : 1:15 PM
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023/05/31        jeonghwan       최초 생성
 */
public class 구현_G1_21611_마법사_상어와_블리자드 {
    static FastReader scan = new FastReader();
    static int N, M;

    static int[] d, s; // 방향, 속력
    static int dx[] = { 0, -1, 1, 0, 0 }; // 1~4 상하좌우
    static int dy[] = { 0, 0, 0, -1, 1 };
    static int result; // 구슬 폭발 합
    static int[][] xy, data; // 좌표

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();

        data = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                data[i][j] = scan.nextInt();
            }
        }

        d = new int[M]; // M개의 방향
        s = new int[M]; // s개의 거리
        xy = new int[N * N][2]; // 칸 번호
        for (int i = 0; i < M; i++) {
            d[i] = scan.nextInt();
            s[i] = scan.nextInt();
        }


    }


    private static void makeXy() { // x,y좌표에 따른 칸 번호 생성
        int x = N / 2, y = N / 2;
        int nx = 0, ny = 0;
        int curDir = 3;
        int d = 1; // 이동해야하는 양
        int num = 1;

        while (true) {
            for (int k = 0; k < 2; k++) {
                for (int i = 0; i < d; i++) {
                    if (x == 0 && y == 0)
                        return;
                    nx = x + dx[curDir];
                    ny = y + dy[curDir];
                    xy[num][0] = nx;
                    xy[num][1] = ny;
                    num++;

                    x = nx;
                    y = ny;
                }
                curDir = nextDir[curDir];
            }
            d++;

        }

    }

    private static void simulation() {
        makeXy();
        for (int time = 0; time < M; time++) {
            // 현재 상어 위치에서 d 방향으로 s만큼 구슬 파괴시키기
            breakRing(d[time], s[time]);

            // 구슬 파괴 후 빈칸 생긴 칸 기준으로 당기기
            moveInside();

            //4개 이상이 같으면 폭발시키기
            while (true) {
                if (!bomb4()) // 더 이상 폭발시킬 것이 없을 경우
                    break;
                else {
                    moveInside(); // 폭발 시켰으면 폭발 후, 이동
                }

            }
            // 그룹 개수, 그룹값 2개로 쪼개기
            split2();
        }

    }

    private static void breakRing(int d, int s) { // 1. 현재 상어 위치에서 d 방향으로 s만큼 구슬 파괴시키기
        int nx = N / 2, ny = N / 2;
        for (int i = 0; i < s; i++) {
            nx += dx[d];
            ny += dy[d];
            if (nx < 0 || nx >= N || ny < 0 || ny >= N)
                break;
            data[nx][ny] = 0;
        }

    }


    static int nextDir[] = { 0, 3, 4, 2, 1 }; // 다음 이동 방향

    private static void moveInside() { // 2. 구슬 파괴 후 빈칸 생긴 칸 기준으로 당기기
        for (int i = 1; i < N * N; i++) {
            int cx = xy[i][0];
            int cy = xy[i][1];
            if (data[cx][cy] == 0) {
                int[] nxy = find(i); // i보다 큰 것중에 0 아닌 값 찾기
                int nx = nxy[0];
                int ny = nxy[1];
                data[cx][cy] = data[nx][ny];
                data[nx][ny] = 0;
            }
        }
    }

    private static boolean bomb4() { // 연속되는 4개 터뜨리기.
        int x = N / 2, y = N / 2; // 시작점
        int nx = 0, ny = 0;
        int curDir = 3; // 시작 방향
        int d = 1; // 이동해야하는 양
        int cnt = 0; // 연속으로 같은거 나오는 횟수
        List<int[]> list = new ArrayList<>(); // 연속으로 같은거 나오는 좌표
        boolean flag = false; // 폭발여부

        while (true) {
            if (x == 0 && y == 0) // (0,0) 도달하면 끝
                break;

            for (int k = 0; k < 2; k++) {
                for (int i = 0; i < d; i++) {
                    if (x == 0 && y == 0)
                        return flag;
                    nx = x + dx[curDir];
                    ny = y + dy[curDir];


                    if (cnt == 0 && data[x][y] != 0 && data[x][y] == data[nx][ny]) { // cnt=0일 때 map[x][y]==map[nx][ny]이면 cnt + 2 처리
                        cnt += 2;
                        list.add(new int[] { x, y });
                        list.add(new int[] { nx, ny });
                    } else if (cnt != 0 && data[x][y] != 0 && data[x][y] == data[nx][ny]) { // cnt >0인 경우, 계속 연속되고 있는 상황이기 때문에 map[nx][ny] 개수만 추가
                        cnt++;
                        list.add(new int[] { nx, ny });
                    }

                    if (data[x][y] != data[nx][ny]) { // 연속하지 않을 경우
                        if (cnt >= 4) { // 4개 이상 연속하면
                            flag = true; // 폭발 발생
                            for (int j = 0; j < list.size(); j++) {
                                int cur[] = list.get(j);
                                int cx = cur[0], cy = cur[1];
                                result += data[cx][cy];
                                data[cx][cy] = 0; // 폭발한 자리는 0으로 정리
                            }
                        }
                        cnt = 0; // cnt 변수 초기화
                        list.clear(); // 폭발할 x, y좌표 담는 리스트 초기화
                    }

                    x = nx; // 좌표 이동
                    y = ny;
                }

                curDir = nextDir[curDir];
            }
            d++;

        }
        return flag;

    }


    private static void split2() { // A그룹, B그룹으로 쪼개기
        int newMap[][] = new int[N][N];

        // map 탐색하면서 생긴 그룹들 newMap에 삽입.
        int cnt = 1;
        int num = 1;
        int cx=0, cy =0, nx= 0, ny= 0;
        for (int i = 1; i < N * N; i++) {
            cx = xy[i][0];
            cy = xy[i][1];
            if(data[cx][cy]==0)
                break;
            if (i != N * N - 1) {

                nx = xy[i + 1][0];
                ny = xy[i + 1][1];
            }
            if (i != N * N - 1 && data[cx][cy] == data[nx][ny]) {

                cnt++;
            } else {
                if (num >= N * N)
                    break;
                int newX = xy[num][0];
                int newY = xy[num][1];
                num++;
                if (num >= N * N)
                    break;
                int newX2 = xy[num][0];
                int newY2 = xy[num][1];
                num++;
                newMap[newX][newY] = cnt;
                newMap[newX2][newY2] = data[cx][cy];
                cnt = 1;

            }
        }
        data = copy(newMap);
    }

    private static int[][] copy(int[][] data) {
        int copyData[][] = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                copyData[i][j] = data[i][j];
        }
        return copyData;
    }



    private static int[] find(int num) { // 칸 번호에 해당하는 X, Y 좌표 반환
        int nxy[] = new int[2];
        for (int i = num + 1; i < N * N; i++) {
            int cx = xy[i][0];
            int cy = xy[i][1];
            if (data[cx][cy] != 0) {
                nxy[0] = cx;
                nxy[1] = cy;
                break;
            }
        }
        return nxy;
    }

    public static void main(String[] args) {
        input();
        simulation();
        System.out.println(result);

    }
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
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
    }
}
