package week10_TwoPointer2;
import java.io.*;
import java.util.*;

public class G2_7453_합이_0인_네_정수 {
    static FastReader scan = new FastReader();
    static int n;
    static int[] a, b, c, d, ab, cd;

    // 네개의 배열에서 수를 하나씩 더해서 0이되는 수를 찾는거니까
    // 두개의 배열의 합을 하나의 배열에 저장
    static void input(){
        n = scan.nextInt();
        a = new int[n];
        b = new int[n];
        c = new int[n];
        d = new int[n];
        ab = new int[n * n];
        cd = new int[n * n];
        for(int i = 0; i < n; i++){
            a[i] = scan.nextInt();
            b[i] = scan.nextInt();
            c[i] = scan.nextInt();
            d[i] = scan.nextInt();

        }


    }
    static void solution(){
        int k = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                // 두개의 배열의 수를 각각 더했을때의 결과를 저장
                ab[k] = a[i] + b[j];
                cd[k] = c[i] + d[j];
                k++;
            }
        }
        Arrays.sort(ab);
        Arrays.sort(cd);

        int left = 0, right = n * n - 1;
        long leftCount = 0, rightCount = 0, sum = 0, result = 0;
        while(left < n * n && right >= 0){ // 범위를 벗어나기전까지 반복
            sum = ab[left] + cd[right];
            if(sum == 0){
                // 초기 카운트는 1 무조건 하나는 있음
                leftCount = 1;
                rightCount = 1;
                // 0이면 같은수가 몇개있는지 각각 count한뒤 곱해줌
                while(left + 1 < n * n && ab[left] == ab[left + 1]){
                    leftCount++;
                    left++;
                }
                while(right - 1>= 0 && cd[right] == cd[right - 1]){
                    rightCount++;
                    right--;
                }
                result += leftCount * rightCount;
                //곱한 뒤에 index 변경, 변경하지 않으면 계속 같은 index에 머물러 무한루프에 빠짐
                left++;
                right--;
            }
            else if(sum < 0){
                left ++;
            }
            else{
                right--;
            }
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

/*

db.containerBox.insertMany([
{name: 'bear', weight: '60', category: 'animal'},
{name: 'bear', weight: '10', category: 'animal'},
{name: 'cat', weight: '2', category: 'animal'},
{name: 'phone', weight: '1', category: 'electronic'}
])

 */