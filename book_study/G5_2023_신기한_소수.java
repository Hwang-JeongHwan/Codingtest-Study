package book_study;

import java.util.*;
import java.io.*;
public class G5_2023_신기한_소수 {
    static int n;
    static void dfs(int num, int jari){
        if (jari == n){
            if(isPrime(num)){
                System.out.println(num);
            }
            return;
        }
        for(int i = 1; i < 10; i++){
            if(i % 2 == 0){
                continue; //짝수면 건너뛰기
            }
            if(isPrime((num * 10) + i)){
                dfs((num * 10) + i, jari + 1);
            }
        }


    }
    static boolean isPrime(int num){
        for(int i = 2; i < (num / 2) + 1; i ++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dfs(2,1);
        dfs(3,1);
        dfs(5,1);
        dfs(7,1);
        // 소수인 2, 3, 5, 7을 매개변수로 한 dfs실행

    }
}
