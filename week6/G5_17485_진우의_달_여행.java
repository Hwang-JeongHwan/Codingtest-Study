package week6;
import java.util.*;
import java.io.*;
public class G5_17485_진우의_달_여행 {
    static int[][][] dp;
    static int[][] arr;
    static final int MAX = 987654321;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int result;
        dp = new int[3][n + 1][m + 1];
        arr = new int[n + 1][m + 1];

        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 1; i < 3; i++){
            for(int j = 1; j <= n; j++ )
                Arrays.fill(dp[i][j], MAX); // 맨 오른쪽끝인경우 0 이면 다른 값과 비교했을때 min이됨
        }

//        System.out.println(Arrays.deepToString(arr));
        for(int i = 1; i <= m; i++){
            // dp테이블 초기화
            dp[0][1][i] = arr[1][i]; // 오른쪽 대각선에서 오는 경우
            dp[1][1][i] = arr[1][i]; // 아래로 가는경우
            dp[2][1][i] = arr[1][i]; // 왼쪽 대각선에서 오는 경우
        }



        for(int i = 2; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[0][i][j] = Math.min(dp[1][i - 1][j], dp[2][i - 1][j]) + arr[i][j];
                if (j!= m) {
                    dp[1][i][j] = Math.min(dp[0][i - 1][j + 1], dp[2][i - 1][j + 1]) + arr[i][j];
                }
                if (j != 1) {
                    dp[2][i][j] = Math.min(dp[1][i - 1][j - 1], dp[0][i - 1][j - 1]) + arr[i][j];
                }
            }
        }
        result = MAX;
        for(int i = 1; i <= m; i++){
            for(int j = 0; j < 3; j++){
                result = Math.min(result, dp[j][n][i]);
            }
        }
        System.out.println(result);
    }
}
