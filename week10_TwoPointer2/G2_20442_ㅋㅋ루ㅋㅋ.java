package week10_TwoPointer2;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;


//부분 수열이므로 R - (중간 상관 없음) - R 의 구간을 일단 구하고,
// 양옆에 붙일 수 있는 K개수를 구하면 된다.

public class G2_20442_ㅋㅋ루ㅋㅋ {
    static FastReader scan = new FastReader();
    static ArrayList<Integer> lk, rk;
    static void input(){
        String str = scan.next();
//        System.out.println(str);
        lk = new ArrayList<>();
        rk = new ArrayList<>();
        int kCnt = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == 'K') {
                kCnt++;
            }
            else if(str.charAt(i) == 'R') {
                lk.add(kCnt);
            }
        }
        kCnt = 0;
        for(int i = str.length() - 1; i >= 0; i--) {
            if(str.charAt(i) == 'K'){
                kCnt++;
            }
            else if (str.charAt(i) == 'R') {
                rk.add(kCnt);
            }
        }

    }
    static void solution(){
        rk.sort(Comparator.reverseOrder());

        int left = 0;
        int right = rk.size() - 1;
        int max = 0;

        while (left <= right) {
            // 부분 수열이므로 R의 양끝 구간을 일단 구하고, 바깥 K의 최소값 * 2를 더해준다.
            max = Math.max(max, (right - left + 1) + (2 * Math.min(lk.get(left), rk.get(right))));

            if (lk.get(left) < rk.get(right)) {
                left++;
            }
            else {
                right--;
            }
        }
        System.out.println(max);
    }

    public static void main(String[] args) throws Exception {
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