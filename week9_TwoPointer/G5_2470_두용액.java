package week9_TwoPointer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
// https://www.acmicpc.net/problem/2470
// 두 용액
// 이진탐색 비슷한 문제
public class G5_2470_두용액 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int[] A;
    static int N;
    static void input(){
        N = scan.nextInt();
        A = new int[N + 1];
        for(int i = 1; i <= N; i++){
            A[i] = scan.nextInt();
        }
    }



    static void solution(){
        // A에 대해 이분 탐색을 할 예정이므로 정렬
        Arrays.sort(A, 1, N + 1);
        int bestSum = Integer.MAX_VALUE, sum = 0;
        int v1 = 0, v2 = 0, L = 1, R = N;
        while(L < R){ // L == R인 상황이면 용액이 한 개 뿐인 것이므로, L < R일때 까지만 반복한다.
            sum = A[L] + A[R];
            if(bestSum > Math.abs(sum)){
                bestSum = Math.abs(sum);
                v1 = A[L];
                v2 = A[R];
            }
            // 가장 큰것과 가장 작은것을 더했을때 음수면 가장 작은수는 어떤 수와 더해도 가장 큰수와 더한것보다 0에 가까울 수 없음
            // 그렇기 때문에 가장 작은수의 위치를 옮겨줌, 0이면 탈출하는게 가장빠른긴함 0과 가장 가까운수는 0이니까 0이 나오면
            // 더이상 탐색할 필요 없음
            if(sum < 0){
                L++;
            }
            else{
                R--;
            }



        }
        System.out.println(v1 + " " + v2);
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
        long nextLong(){
            return Long.parseLong(next());
        }
        String nextLine(){
            String str = "";
            try{
                str = br.readLine();

            }
            catch(IOException e){
                e.printStackTrace();
            }
            return str;
        }
    }
}