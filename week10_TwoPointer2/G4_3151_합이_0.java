package week10_TwoPointer2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G4_3151_합이_0 {
    static FastReader scan = new FastReader();
    static int n;
    static long count;
    static int arr[];

    static void input(){
        n = scan.nextInt();
        arr = new int[n + 1];
        for(int i = 1; i <= n; i++){
            arr[i] = scan.nextInt();
        }
    }
    static int combination(int n){
        return n * (n - 1) / 2; // index는 고정, left, right만 뽑으면 되므로 nC2를 구하면됨
    }
    static void determination(int index){
        int left = index + 1, right = n, sum = 0;
        int leftCount = 0, rightCount = 0;
        while(left < right){

            sum = arr[left] + arr[right] + arr[index];
            if(sum == 0){
                // 초기 카운트는 1 무조건 하나는 있음
                leftCount = 1;
                rightCount = 1;

                /*
                예시에서 가능한 참가자 그룹은 아래와 같다.
                (2, -5, 3), (2, 2, -4), (2, 2, -4), (-5, 2, 3), (3, -4, 1), (3, -4, 1)
                두 개의 -4는 서로 다른 참가자를 나타내는 것에 유의하라.
                (2, 2, -4)와 (3, -4, 1)이 두 번씩 나타난다.


                같은수가 있을 수 있는 배열이므로  left를 증가시키다가 0이 처음 나왓을때
                arr[left] 번째 수는 같은 값이 있다면 그 수 중에
                첫 번째 위치에 있는 수이므로 left를 증가해야함
                + arr[right]의 같은 수의 개수 만큼 더해주어야함
                즉 경우의 수는 arr[left]개수 * arr[right]

                만약 0 0 0 0 0 0으로 0을 만드는 경우는
                6C3 하지만 우리는 1개를 고정하기때문에
                0 / 0 0 0 0 0이므로 5C2만 구하면됨
                => nC2를 구하면됨
                 */
                if(arr[left] == arr[right]){// arr[index], arr[left], arr[right]가 모두 0인 경우
                    count += combination(right - left + 1);
                    break;
                }
                // left의 개수를 구함
                while(left + 1 < right && arr[left] == arr[left + 1]){
                    left++;
                    leftCount++;
                }
                // right의 개수를 구함
                while(right - 1 > left && arr[right] == arr[right - 1]){
                    right--;
                    rightCount++;
                }
                count += leftCount * rightCount; // 개수를 곱한만큼 더해줌
                // 곱한 뒤에 left와 right의 인덱스를 변경 변경해야 무한루프에 빠지지 않음
                // left + 1 < right, right - 1 > left로 두었기 때문에 0이 나오고 index = 2  left = 8 right = 9인경우
                // -5 + 2 + 3 = 0이 나오고 left + 1 < right = false, right -1 < left = false 이고
                // left < right는 true이기때문 무한루프에 빠짐
                // 그냥 두면 계속 같은 인덱스에 머물기때문에 곱한뒤에 인덱스 변경
                left++;
                right--;


            }

            else if(sum > 0){
                right--;
            }
            else{
                left++;
            }
//            if(sum < 0){ 이렇게 해도됨 위에서 같은경우가 걸러져서
//                left++;
//            }
//            else{
//                right--;
//            }
        }
    }

    static void solution(){
        Arrays.sort(arr, 1, n + 1);
        for(int i = 1; i <= n; i++){
            if(arr[i] > 0){ // 3개의 수 모두 양수가 되므로 종료
                break;
            }
            determination(i);
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        input();
        solution();

    }

    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        public FastReader(){
            this.br = new BufferedReader(new InputStreamReader(System.in));
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
    }
}
