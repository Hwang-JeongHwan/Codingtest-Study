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
    static int N;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

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

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.valueOf(br.readLine());
        int N2 = N*N;
        int answer = 0;
        classroom = new int[N][N];
        fillNearEmptySeat();

        for (int i = 0; i < N2; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int num = Integer.valueOf(st.nextToken());
            int s1 = Integer.valueOf(st.nextToken());
            int s2 = Integer.valueOf(st.nextToken());
            int s3 = Integer.valueOf(st.nextToken());
            int s4 = Integer.valueOf(st.nextToken());

            findSeat(num, new int[]{s1, s2, s3, s4});
        }

        for (int i = 1; i <= N2; i++) {
            Student student = map.get(i);
            int cnt = 0;
            for (int friend : student.friends) {
                if (Math.abs(map.get(friend).x - student.x) + Math.abs(map.get(friend).y - student.y) == 1) {
                    cnt++;
                }
            }

            if (cnt == 1) answer += 1;
            else if (cnt == 2) answer += 10;
            else if (cnt == 3) answer += 100;
            else if (cnt == 4) answer += 1000;
        }

        System.out.println(answer);

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

        int emptyCntMax = -1;
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
                    emptyCntMax = count[i][j];
                } else if (nearScoreMax == nearScore[i][j] && emptyCntMax < count[i][j]) {
                    emptyCntMax = count[i][j];
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

}
