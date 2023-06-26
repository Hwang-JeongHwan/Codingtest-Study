package week12;
import java.io.*;
import java.util.*;
/**
 * packageName    : week12
 * fileName       : 구현_G5_21608_상어_초등학교
 * author         : jeonghwan
 * date           : 2023/05/29
 * time           : 12:59 PM
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023/05/31        jeonghwan       최초 생성
 */
public class 구현_G5_21608_상어_초등학교 {
    static int[][] classroom, count;
    static int N, N2, result;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static FastReader scan = new FastReader();
    static class Student{
        int x;
        int y;
        int[] friends;

        public Student(int x, int y, int[] flist) {
            this.x = x;
            this.y = y;
            this.friends = flist;
        }
    }

    static Map<Integer, Student> map = new HashMap<>();

    static void input() {
        N = scan.nextInt();
        N2 = N * N;
        classroom = new int[N][N];
        fillNearEmptySeat();

        for (int i = 0; i < N2; i++) {
            int num = scan.nextInt();
            int s1 = scan.nextInt();
            int s2 = scan.nextInt();
            int s3 = scan.nextInt();
            int s4 = scan.nextInt();

            findSeat(num, new int[]{s1, s2, s3, s4});
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        input();
        solution();
    }

    static void solution() {

        for (int i = 1; i <= N2; i++) {
            Student student = map.get(i);
            int cnt = 0;
            for (int friend : student.friends) {
                if (Math.abs(map.get(friend).x - student.x) + Math.abs(map.get(friend).y - student.y) == 1) {
                    cnt++;
                }
            }

            if (cnt == 1) result += 1;
            else if (cnt == 2) result += 10;
            else if (cnt == 3) result += 100;
            else if (cnt == 4) result += 1000;
        }

        System.out.println(result);
    }
    private static void findSeat(int num, int[] friends) {
        int[][] nearScore = new int[N][N]; //주변에 친한 친구가 많은 위치를 찾기 위한 배열
        for(int friend : friends) {
            if(map.containsKey(friend)) {
                Student student = map.get(friend);
                int x = student.x;
                int y = student.y;

                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if (nx >= 0 && nx < N && ny >= 0 && ny < N && classroom[nx][ny] == 0) {
                        nearScore[nx][ny]++;
                    }
                }
            }
        }

        int emptyCountMax = -1;
        int nearScoreMax = -1;
        int choiceX = -1;
        int choiceY = -1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (classroom[i][j] != 0) continue;
                if (nearScoreMax < nearScore[i][j]) {
                    choiceX = i;
                    choiceY = j;
                    nearScoreMax = nearScore[i][j];
                    emptyCountMax = count[i][j];
                } else if (nearScoreMax == nearScore[i][j] && emptyCountMax < count[i][j]) {
                    emptyCountMax = count[i][j];
                    choiceX = i;
                    choiceY = j;
                }
            }
        }

        classroom[choiceX][choiceY] = num;
        map.put(num, new Student(choiceX,choiceY, friends));

        for (int i = 0; i < 4; i++) {
            int nx = choiceX + dx[i];
            int ny = choiceY + dy[i];
            if (nx >= 0 && nx < N && ny >= 0 && ny < N && classroom[nx][ny] == 0) {
                count[nx][ny]--;
            }
        }
    }

    private static void fillNearEmptySeat() {
        count = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int cnt = 4;
                if (i == 0 || i == N - 1) cnt--;
                if (j == 0 || j == N - 1) cnt--;
                count[i][j] = cnt;
            }
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
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
