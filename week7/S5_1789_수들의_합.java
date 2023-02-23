package week7;
import java.util.*;

public class S5_1789_수들의_합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();
        long sum = 0, cnt = 0;
        for (int i = 1; i <= n; i++) {
            if(sum > n) break;
            sum += i;
            cnt++;
        }

        System.out.println(cnt-1);
    }
}

