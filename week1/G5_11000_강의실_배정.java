package week1;
import java.util.*;
import java.io.*;

public class G5_11000_강의실_배정 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] data = new int[n][2];

        for(int i = 0; i < n; i ++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            data[i][0] = Integer.parseInt(st.nextToken());
            data[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(data, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){ // 시작 시간이 같으면 종료시간이 이른 순서대로 정렬
                    return o1[1] - o2[1];
                }
                return Integer.compare(o1[0],o2[0]);
            }
        });

//        Arrays.sort(data,(int[] o1, int[] o2)->{
//            return Integer.compare(o1[1], o2[1]);
//
//        });
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(data[0][1]);

        for(int i = 1; i < n; i ++){
            if(data[i][0] >= pq.peek()){
                pq.poll();

            }
            pq.add(data[i][1]);

        }
        System.out.println(pq.size());
        br.close();
    }
}
