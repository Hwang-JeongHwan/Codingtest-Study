package week8_ParametricSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G4_13397_구간_나누기2 {
    static FastReader scan = new FastReader();
    static final int MAX_VALUE = 0;
    static final int  MIN_VALUE = 100001;
    static int[] arr;
    static int n, m, right;
    static void input(){

        n = scan.nextInt();
        m = scan.nextInt();
        arr = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            arr[i] = scan.nextInt();
            right = Math.max(right, arr[i]);
        }
        right--;
    }
    static boolean determination(int value){
        // 구간별 최대값이 value보다 작거나 같으면 count를 증가 시키고 최종적으로 m과 비교해 큰지 작은지 확인
        // value보다 작거나 같은 구간별 최대값이 몇개가 있는지 확인

        int count = 1; // 초기 구간은 1 -> 아무것도 하지않아도 1개의 구간은 있으니까

        int max = arr[1];
        int min = arr[1];

        for(int i = 2; i <= n; i++){
            max = Math.max(arr[i], max);
            min = Math.min(arr[i], min);
            if(max - min > value){
                count++;
                // count를 증가시키고 max, min초기화
                max = arr[i];
                min = arr[i];
            }

        }

        return count <= m;
    }
    static void solution(){
        int left = 0, mid = 0, result = 0; // 최소값은 0, 최대값은 right - 1

        while(left <= right){
            mid = (left + right) / 2;
            if(determination(mid)){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        System.out.println(left);

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
                catch (IOException e) {
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
