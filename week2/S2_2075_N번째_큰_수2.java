package week2;

import java.util.*;
import java.io.*;

public class S2_2075_N번째_큰_수2 {
    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i ++){
            pq.add(Integer.parseInt(st.nextToken()));
        }

        for (int i = 1; i < n; i ++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j ++){
                int now = Integer.parseInt(st.nextToken());
                if (now > pq.peek()){
                    pq.poll();
                    pq.add(now);
                }

            }
        }
        System.out.println(pq.peek());
        // 우선순위 큐를 사용했을때가 리스트를 사용했을때보다 더 빠름
        // ArrayList = 2096ms, Priority Queue = 880ms
    }
}


