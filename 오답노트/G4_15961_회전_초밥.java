package 오답노트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G4_15961_회전_초밥 {
    static FastReader scan = new FastReader();
    static int n, d, k, c, kind;
    static int[] arr, count = new int[3001];
    static void input() {
        n = scan.nextInt();
        d = scan.nextInt();
        k = scan.nextInt();
        c = scan.nextInt();
        arr = new int[n + k + 1];
        for(int i = 1; i <= n; i++){
            arr[i] = scan.nextInt();
        }
        for(int i = n + 1; i <= n + k; i++){
            arr[i] = arr[i - n];
        }

    }

    // O(1)로 kind를 알아내기 위해 만든 함수
    // right번째 수를 증가해서 1이 되면 kind++
    // left번째 수를 감소해서 0이 되면 kind--
    static void addCount(int x){
        count[x]++;
        // x번째 수가 1이되면 먹을 수 있는 초밥의 종류가 하나 는것
        if(count[x] == 1){
            kind ++;
        }

    }
    // 배열의 x번째 수를 감소 했을때 0이면 kind--
    static void eraseCount(int x){
        count[x]--;
        // x번째 수가 0이되면 먹을 수 있는 초밥이 종류가 하나 줄어듬
        if(count[x] == 0){
            kind--;
        }
    }
    static void solution(){
        int left = 0, result = 0, total = 0;
        int temp = 0;
//        for(int left = 1; left <= n + k; left++){
//            eraseCount(arr[left - 1]);
//            if(total >= 1){
//                total--;
//            }
//            while(right + 1 <= n + k && total < k){
//                right++;
//                addCount(arr[right]);
//                total++;
//            }
//            temp = kind;
//            if(count[c] == 0){
//                temp++;
//            }
//            result = Math.max(result, temp);
//
//        }
        // 일단 k번째까지 한번 돌아보기
        for(int i = 1; i <= k; i++){
            addCount(arr[i]);
        }
        temp = kind;
        // 쿠폰을 사용할 초밥번호를 선택하지 않았으면 temp증가
        if(count[c] == 0){
            temp++;
        }
        result = Math.max(result, temp);
        // k + 1번째 수 부터 슬라이딩 윈도우 크기를 k로 유지한채 반복 수행 O(n)

        for(int right = k + 1; right <= n + k; right++){
            left = right - k;
            addCount(arr[right]);
            eraseCount(arr[left]);
            temp = kind;
            if(count[c] == 0){
                temp++;
            }
            result = Math.max(result, temp);
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
        FastReader(){
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
