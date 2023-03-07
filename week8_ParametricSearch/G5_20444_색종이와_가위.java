package week8_ParametricSearch;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G5_20444_색종이와_가위 {
    static int n;
    static long k;
    static FastReader scan = new FastReader();
    static void input(){
        n = scan.nextInt();
        k = scan.nextLong();

    }
    static long determination(long row, long column){
        // 가로 세로로 잘랐을때의 색종이의 갯수
        return (row + 1) * (column + 1);
    }
    static void solution(){
//        System.out.println(n + " " + k);
        // 가로 세로가 바뀌는 경우 값이 같음 -> 이런 경우 한번만 연산하기 위해 right의 범위를 2로 나눔
        long left = 0, right = n / 2; // mid가 int의 범위를 넘어갈수 있으므로 long타입으로 ex ) right = Integer.MAX_VALUE, left = Integer.MAX_VALUE / 2
        long total = 0, mid = 0;

        while(left <= right){
            mid = (left + right) / 2;
            total = determination(mid, n - mid);
            if(total == k){
                System.out.println("YES");
                return;
            }
            else if(total < k){
                left = mid + 1;
            }
            else if(total > k){
                right = mid - 1;
            }
        }
        System.out.println("NO");


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
            while (st == null || !st.hasMoreElements()){
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
    }
}