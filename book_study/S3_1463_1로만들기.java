package book_study;
import java.util.Scanner;
import java.util.Arrays;
public class S3_1463_1로만들기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] dp = new int[n + 3];
        dp[2] = 1;
        dp[3] = 1;
        for(int i = 4; i < n + 1; i++){
//            if(i % 3 == 0 && i % 2 == 0){
//                dp[i] = Math.min(Math.min(dp[i / 3], dp[i / 2]), dp[i - 1]) + 1;
//            }
//            else if(i % 3 == 0){
//                dp[i] = Math.min(dp[i / 3], dp[i - 1]) + 1;
//            }
//            else if(i % 2 == 0){
//                dp[i] = Math.min(dp[i / 2], dp[i - 1]) + 1 ;
//            }
//            else{
//                dp[i] = dp[i - 1] + 1;
//            }
            dp[i] = dp[i - 1] + 1;
            //dp[i]의 최적 값은 1을 빼는 경우입니다
            if(i % 3 == 0){
                dp[i] = Math.min(dp[i / 3] + 1, dp[i]);
                // '1을 빼는 경우가 고려된' 최적값이 저장된 dp[i]와, 3으로 나누는 경우를 고려한 최적값을
                // dp[i]에 갱신합시다
            }
            if(i % 2 == 0){
                dp[i] = Math.min(dp[i / 2] + 1, dp[i]);
                /* '1을 빼는 경우가 고려되었고', '3으로 나누는 경우 역시 고려한' 최적값이 저장된 dp[i]를
                다시 2로 나누는 경우와 고려한 최적값을 dp[i]에 갱신합시다
                이제 dp[i]는 '1을 빼는 경우', '3으로 나누는 경우', '2로 나누는 경우'
                 이 세 가지를 모두 고려한 최적값이 저장되었습니다.
            */
            }



        }
        System.out.println(Arrays.toString(dp));
        System.out.println(dp[n]);
    }
}
