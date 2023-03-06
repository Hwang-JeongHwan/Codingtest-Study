package week8_ParametricSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G4_2110_공유기_설치 {
    static int n, c;
    static int[] arr;
    static FastReader scan = new FastReader();
    static void input(){
        n = scan.nextInt();
        c = scan.nextInt();
        arr = new int[n + 1];
        for(int i = 1; i <= n; i++){
            arr[i] = scan.nextInt();
        }
    }
    static boolean determination(int d){
        // d만큼의 거리 차이를 둔다면 c개 만큼의 공유기를 설치할 수 있는가?
        // 제일 왼쪽 집부터 가능한 많이 설치
        // d만큼의 거리를 두면서 최대로 설치한 개수와 c를 비교
        int count = 1, last = arr[1];
        for(int i = 2; i <= n; i ++){
            // 이번에 arr[i]에 설치가 가능한가?
            if(arr[i] - last >= d){
                count++;
                last = arr[i];
            }
        }
        return count >= c;
    }
    static void solution(){
        // determination을 빠르게 하기 위해 정렬
        Arrays.sort(arr, 1, n + 1);
        int L = 1, R = 1000000000, mid = 0, answer = 0;
        // [L ... R] 범위 안에 정답이 존재
        // 이분 탐색과 determination 문제를 이용해서 answer구하기
        while(L <= R){
            mid = (L + R) / 2;
            if(determination(mid)){
                answer = mid;
                L = mid + 1;

            }
            else{
                R = mid - 1;
            }
        }
        System.out.println(answer);

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
