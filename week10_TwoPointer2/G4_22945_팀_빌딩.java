package week10_TwoPointer2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G4_22945_팀_빌딩 {
    static FastReader scan = new FastReader();
    static int n, max;
    static int[] arr;

    static void input(){
        n = scan.nextInt();
        arr = new int[n + 1];
        for(int i = 1; i <= n; i++){
            arr[i] = scan.nextInt();
        }
    }

    static void solution(){
        int left = 1, right = n, total = 0;
        // max가 커지려면 index의 차이 - 1이 크고 Math.min(arr[left], arr[right])가 커야한다.
        // 배열의 요소를 탐색하며 진행해야 하므로 index의 차이는 크게 유지하면서 min(arr[left], arr[right]가
        // 조금이라도 더 크려면
        // 배열에서 arr[left]와 arr[right]중 작은 수의 인덱스를 변경해주면 된다.
        while(left < right){
            total = (right - left - 1) * Math.min(arr[left], arr[right]);
            max = Math.max(max, total);
            if(arr[left] < arr[right]) {
                left++;
            }
            else{
                right--;
            }
        }

        System.out.println(max);
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
    }

}
