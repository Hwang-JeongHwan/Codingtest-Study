package week9_TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G4_1806_부분합 {
    static FastReader scan = new FastReader();
    static int n, s;
    static int[] arr;
    static void input(){
        n = scan.nextInt();
        s = scan.nextInt();
        arr = new int[n + 1];
        for(int i = 1; i <= n; i++){
            arr[i] = scan.nextInt();
        }

    }
    static void solution(){
        int right = 0, sum = 0, result = n + 1;
        for(int left = 1; left <= n; left++){
            sum -= arr[left - 1]; //left가 옮겨 왔으니까 left - 1을 구간에서 제외
            // 제일 처음부터 최적의 수가 나올수도 있기 때문에
            while(right + 1 <= n && sum < s){ // sum이 s보다 작을때 까지 계속 right를 옮기며 더해줌
                // right를 옮길수 있을만큼 옮겨주고
                right ++; // 이렇게 while문 조건을 넣어야 right를 r까지 탐색, 0부터 시작해서 right를 증가하고
                // sum에 넣어야 index계산하기가 편함
                sum += arr[right];

            }
            // sum에서 left위치의 값을 빼면서 비교 빼고 난 뒤의 sum이 s보다 크거나 같으면 result값 갱신
            // [L ... R]의 합 즉 sum이 조건을 만족하면 정답 갱신하기
            if(sum >= s){
                result = Math.min(result, right - left + 1);//길이를 구하니까 index끼리 뺀뒤 + 1
            }
        }
        // 아직도 초기값이면, sum >= s인경우가 없다는거니까
        if(result == n + 1){
            result = 0;
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        input();
        solution();
    }
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        public FastReader() {
            this.br = new BufferedReader(new InputStreamReader(System.in));
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


//    static void solution(){
//        int right = 0, sum = 0, result = n + 1;
//        for(int left = 1; left <= n; left ++){
//            // left - 1을 구간에서 제외하기
//            sum -= arr[left - 1];
//
//            // right를 옮길 수 있을 때 까지 옮기기
//            while(right + 1 <= n && sum < S){
//                // 합이 이미 n보다 크면 옮길 필요가 없음
//                right++; //right를 증가시키고 그 값을 sum에 더해줌
//                sum += arr[right];
//            }
//            // [left ... right]의 합, 즉 sum이 조건을 만족하면 정답 갱신하기
//            if(sum >= S){
//                result = Math.min(result, right - left + 1);
//            }
//        }
//        // result 값을 보고 불가능 판단
//        if(result == n + 1){
//            result = 0;
//        }
//        System.out.println(result);
//
//    }
//
//    public static void main(String[] args) {
//
//    }
//    static class FastReader{
//        BufferedReader br;
//        StringTokenizer st;
//        FastReader(){
//            br = new BufferedReader(new InputStreamReader(System.in));
//        }
//        String next(){
//            while(st == null || !st.hasMoreElements()){
//                try {
//                    st = new StringTokenizer(br.readLine());
//                }
//                catch(IOException e){
//                    e.printStackTrace();
//                }
//            }
//            return st.nextToken();
//        }
//        int nextInt(){
//            return Integer.parseInt(next());
//        }
//    }
//
//}
