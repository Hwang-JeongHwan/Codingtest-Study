package week8_ParametricSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class test {
    public static int n, m;
    public static int[] a;

    public static boolean check(int mid) {
        int cnt = 1;
        int min = a[0];
        int max = a[0];
        for (int i = 1; i < n; i++) {
            if (a[i] > max) max = a[i];
            if (a[i] < min) min = a[i];
            if (max - min > mid) {
                cnt += 1;
                max = a[i];
                min = a[i];
            }
        }
        return cnt <= m;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int left = 0;
        int right = 10000;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (check(mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(left); // 구간의 최대값의 최소값을 출력
    }
}