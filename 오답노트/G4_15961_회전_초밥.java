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
        arr = new int[n + 1];
        for(int i = 1; i <= n; i++){
            arr[i] = scan.nextInt();
        }

    }
    // O(1)로 kind를 알아내기 위해 만든 함수
    // count를 증가해서 1이 되면 kind ++
    static void addCount(int x){
        count[x]++;
        if(count[x] == 1){
            kind ++;
        }

    }
    // 배열의 x번째 수를 감소 했을때 0이면 kind--
    static void eraseCount(int x){
        count[x]--;
        if(count[x] == 0){
            kind--;
        }
    }
    static void solution(){
        int right = 0, result = 0, total = 0;
        int temp = 0;
        for(int left = 1; left <= n; left++){
            eraseCount(arr[left - 1]);
            if(total >= 1){
                total--;
            }
            while(right + 1 <= n && total < k){
                right++;
                addCount(arr[right]);
                total++;
            }
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
