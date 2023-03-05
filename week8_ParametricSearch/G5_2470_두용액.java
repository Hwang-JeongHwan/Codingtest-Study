package week8_ParametricSearch;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

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


    static int lower_bound(int[] A, int L, int R, int X){
        // A[L...R]에서 X이상의 수 중 제일 왼쪽 인덱스를 return 하는 함수
        // 그런게 없다면 R + 1을 return
        int M = 0, result = R + 1;

        while(L <= R){
            M = (L + R) / 2;
            if(A[M] >= X){
                result = M;
                R = M - 1;
            }
            else{
                L = M + 1;
            }
        }
        return result;

    }
    static void pro(){
        // A에 대해 이분탐색을 할 예정이니까 정렬을 미리 해둠
        Arrays.sort(A, 1, N + 1);
        int bestSum = Integer.MAX_VALUE;
        int v1 = 0, v2 = 0;
        for(int left = 1; left < N; left++){
            // A[left]용액을 쓸것이다, 고로 -A[left]와 가장 가까운 용액을 자신의 오른쪽 구간에서 찾기
            int candidate = lower_bound(A, left + 1, N, -A[left]);
            // A[candidate - 1]과 A[candidate]중에 A[left]와 섞었을 때의 정보를 정답에 갱신 시킨다.
            if(left < candidate -1 && Math.abs(A[candidate - 1] + A[left] ) < bestSum){
                bestSum = Math.abs(A[left] + A[candidate - 1]);
                v1 = A[left];
                v2 = A[candidate - 1];
            }
            if(candidate <= N && Math.abs(A[candidate] + A[left] ) < bestSum){
                bestSum = Math.abs(A[left] + A[candidate]);
                v1 = A[left];
                v2 = A[candidate];
            }

        }

        sb.append(v1 + " " + v2);
        System.out.println(sb);
    }

    public static void main(String[] args) {
        input();
        pro();
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